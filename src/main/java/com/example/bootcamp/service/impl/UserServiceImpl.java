package com.example.bootcamp.service.impl;

import com.example.bootcamp.dto.UserDTO;
import com.example.bootcamp.entity.User;
import com.example.bootcamp.entity.VolunteerCenter;
import com.example.bootcamp.exception.UserNotFoundException;
import com.example.bootcamp.exception.VolunteerCenterNotFoundException;
import com.example.bootcamp.repository.UserRepository;
import com.example.bootcamp.repository.VolunteerCenterRepository;
import com.example.bootcamp.service.UserService;
import com.example.bootcamp.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final VolunteerCenterRepository volunteerCenterRepository;

    //конструктор с инъекцией зависимостей
    public UserServiceImpl(UserRepository userRepository, VolunteerCenterRepository volunteerCenterRepository) {
        this.userRepository = userRepository;
        this.volunteerCenterRepository = volunteerCenterRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::convertToDto)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        VolunteerCenter volunteerCenter = volunteerCenterRepository.findById(userDTO.getVolunteerCenterId())
                .orElseThrow(() -> new VolunteerCenterNotFoundException("Volunteer Center not found!"));

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setSecondName(userDTO.getSecondName());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setAvatarUrl(userDTO.getAvatarUrl());
        user.setRole(userDTO.getRole());
        user.setStatus(userDTO.getStatus());
        user.setVolunteerCenter(volunteerCenter);

        //установка новых полей
        user.setAge(userDTO.getAge());
        user.setExperience(userDTO.getExperience());
        user.setDescription(userDTO.getDescription());
        user.setRating(userDTO.getRating());
//        user.setPassword(userDTO.getPassword());

        return UserMapper.convertToDto(userRepository.save(user));
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));

        user.setFirstName(userDTO.getFirstName());
        user.setSecondName(userDTO.getSecondName());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setAvatarUrl(userDTO.getAvatarUrl());
        user.setRole(userDTO.getRole());
        user.setStatus(userDTO.getStatus());

        //новые поля 7 февраля 21-02
        user.setAge(userDTO.getAge());
        user.setExperience(userDTO.getExperience());
        user.setDescription(userDTO.getDescription());

        if (userDTO.getRating() != null) {
            user.setRating(userDTO.getRating());
        }

        if (userDTO.getVolunteerCenterId() != null) {
            VolunteerCenter volunteerCenter = volunteerCenterRepository.findById(userDTO.getVolunteerCenterId())
                    .orElseThrow(() -> new VolunteerCenterNotFoundException("Volunteer Center not found!"));
            user.setVolunteerCenter(volunteerCenter);
        }

        return UserMapper.convertToDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    //новый метод для получения части пользователей
    @Override
    public List<UserDTO> getUsers(int offset, int limit) {
        //получаем всех пользователей — отсортированных по id
        List<User> allUsers = userRepository.findAll(Sort.by("id"));
        int total = allUsers.size();

        //если offset больше или равен общему количеству пользователей — сбрасываем его в 0
        if (offset >= total) {
            offset = 0;
        }

        //вычисляем индекс последнего элемента (не превышает общее число)
        int toIndex = Math.min(offset + limit, total);

        //формируем подсписок и преобразуем в DTO
        return allUsers.subList(offset, toIndex)
                .stream()
                .map(UserMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUserRating(Long id, Double rating) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
        user.setRating(rating.intValue()); // Преобразование Double в Integer
        return UserMapper.convertToDto(userRepository.save(user));
    }

    //новый метод для получения рейтинга
    @Override
    public Double getUserRating(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
        return user.getRating().doubleValue(); // Преобразуем Integer в Double
    }

}

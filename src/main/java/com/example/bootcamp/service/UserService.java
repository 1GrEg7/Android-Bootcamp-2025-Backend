package com.example.bootcamp.service;

import com.example.bootcamp.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);

    //новый метод для получения порции пользователей
    List<UserDTO> getUsers(int offset, int limit);

    //новый метод для обновления рейтинга
    UserDTO updateUserRating(Long id, Double rating);

    //новый метод для получения рейтинга
    Double getUserRating(Long id);
}

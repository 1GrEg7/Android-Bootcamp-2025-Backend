package com.example.bootcamp.util;

import com.example.bootcamp.dto.UserDTO;
import com.example.bootcamp.entity.User;

public class UserMapper {

    public static UserDTO convertToDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setSecondName(user.getSecondName());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setAvatarUrl(user.getAvatarUrl());
        dto.setRole(user.getRole());
        dto.setStatus(user.getStatus());
        if (user.getVolunteerCenter() != null) {
            //для входящих данных всё ещё можно установить ID центра
            dto.setVolunteerCenterId(user.getVolunteerCenter().getId());
            //для ответа – устанавливаем только название центра
            dto.setVolunteerCenter(user.getVolunteerCenter().getName());
        }
        return dto;
    }
}

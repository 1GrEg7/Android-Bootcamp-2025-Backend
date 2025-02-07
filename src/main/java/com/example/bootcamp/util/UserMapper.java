//package com.example.bootcamp.util;
//
//import com.example.bootcamp.dto.UserDTO;
//import com.example.bootcamp.entity.User;
//
//public class UserMapper {
//
//    public static UserDTO convertToDto(User user) {
//        if (user == null) {
//            return null;
//        }
//
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(user.getId());
//        userDTO.setUsername(user.getUsername());
//        userDTO.setEmail(user.getEmail());
//        userDTO.setPhoneNumber(user.getPhoneNumber());
//        userDTO.setAvatarUrl(user.getAvatarUrl());
//        userDTO.setRole(user.getRole());
//        userDTO.setStatus(user.getStatus());
//
//        return userDTO;
//    }
//
//    public static User convertToEntity(UserDTO userDTO) {
//        if (userDTO == null) {
//            return null;
//        }
//
//        User user = new User();
//        user.setId(userDTO.getId());
//        user.setUsername(userDTO.getUsername());
//        user.setEmail(userDTO.getEmail());
//        user.setPhoneNumber(userDTO.getPhoneNumber());
//        user.setAvatarUrl(userDTO.getAvatarUrl());
//        user.setRole(userDTO.getRole());
//        user.setStatus(userDTO.getStatus());
//
//        return user;
//    }
//}

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
            dto.setVolunteerCenterId(user.getVolunteerCenter().getId());
            dto.setVolunteerCenter(user.getVolunteerCenter());
        }
        return dto;
    }
}

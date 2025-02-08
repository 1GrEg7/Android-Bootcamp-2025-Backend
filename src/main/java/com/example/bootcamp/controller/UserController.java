package com.example.bootcamp.controller;

import com.example.bootcamp.dto.UserDTO;
import com.example.bootcamp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //существующий endpoint для получения всех пользователей
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    //существующий endpoint для получения пользователя по id
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    //новый endpoint для получения порции пользователей (пагинация)
    //пример запроса: GET /api/users/paginated?offset=0&limit=2
    @GetMapping("/paginated")
    public ResponseEntity<List<UserDTO>> getPaginatedUsers(
            @RequestParam("offset") int offset,
            @RequestParam("limit") int limit) {
        List<UserDTO> users = userService.getUsers(offset, limit);
        return ResponseEntity.ok(users);
    }

    //существующий endpoint для создания пользователя
    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    //существующий endpoint для обновления пользователя
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable long id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(id, userDTO));
    }

    //существующий endpoint для удаления пользователя
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/rating")
    public ResponseEntity<UserDTO> updateUserRating(@PathVariable long id, @RequestParam Double rating) {
        return ResponseEntity.ok(userService.updateUserRating(id, rating));
    }

    //новый эндпоинт для получения рейтинга
    @GetMapping("/{id}/rating")
    public ResponseEntity<Double> getUserRating(@PathVariable long id) {
        return ResponseEntity.ok(userService.getUserRating(id));
    }

}

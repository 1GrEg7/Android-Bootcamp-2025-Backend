package com.example.bootcamp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

    private long id;
    private String firstName;
    private String secondName;
    private String email;
    private String phoneNumber;
    private String avatarUrl;
    private String role;
    private String status;

    //поле используется при создании/обновлении (приёме данных)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long volunteerCenterId;

    //поле будет выводиться (только для чтения) и содержит название центра
    @JsonProperty(value = "volunteerCenter", access = JsonProperty.Access.READ_ONLY)
    private String volunteerCenter;

    private Integer age;
    private Integer experience;
    private String description;
    private Integer rating;

    //геттеры и сеттеры

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    //firstName
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //secondName
    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    //email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //avatarUrl
    public String getAvatarUrl() {
        return avatarUrl;
    }
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    //role
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    //status
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    //volunteerCenterId (для входящих данных)
    public Long getVolunteerCenterId() {
        return volunteerCenterId;
    }
    public void setVolunteerCenterId(Long volunteerCenterId) {
        this.volunteerCenterId = volunteerCenterId;
    }

    //volunteerCenter (выводится название центра)
    public String getVolunteerCenter() {
        return volunteerCenter;
    }
    public void setVolunteerCenter(String volunteerCenter) {
        this.volunteerCenter = volunteerCenter;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getExperience() {
        return experience;
    }
    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
}

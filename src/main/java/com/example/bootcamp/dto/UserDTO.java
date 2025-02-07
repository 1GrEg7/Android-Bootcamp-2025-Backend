package com.example.bootcamp.dto;

import com.example.bootcamp.entity.VolunteerCenter;

public class UserDTO {

    private long id;
    private String firstName;
    private String secondName;
    private String email;
    private String phoneNumber;
    private String avatarUrl;
    private String role;
    private String status;
    private Long volunteerCenterId;
    private VolunteerCenter volunteerCenter;

    // Геттеры и сеттеры

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // secondName
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    // email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // avatarUrl
    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    // role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // volunteerCenterId
    public Long getVolunteerCenterId() {
        return volunteerCenterId;
    }

    public void setVolunteerCenterId(Long volunteerCenterId) {
        this.volunteerCenterId = volunteerCenterId;
    }

    // volunteerCenter
    public VolunteerCenter getVolunteerCenter() {
        return volunteerCenter;
    }

    public void setVolunteerCenter(VolunteerCenter volunteerCenter) {
        this.volunteerCenter = volunteerCenter;
    }
}

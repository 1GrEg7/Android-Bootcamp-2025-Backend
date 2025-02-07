package com.example.bootcamp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //новые поля для разделения имени
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "role")
    private String role;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "volunteer_center_id", referencedColumnName = "id")
    private VolunteerCenter volunteerCenter;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    //геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    //volunteerCenter
    public VolunteerCenter getVolunteerCenter() {
        return volunteerCenter;
    }

    public void setVolunteerCenter(VolunteerCenter volunteerCenter) {
        this.volunteerCenter = volunteerCenter;
    }

    //createdAt
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

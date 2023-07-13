package com.polaris.appWebPolaris.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.polaris.appWebPolaris.enums.Role;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;


@Entity
@Table(name = "user_login")
public class UserLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonIgnore
    private UserProfile userProfile;

    @ManyToOne
    @JoinColumn(name = "work_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonIgnore
    private UserWork works;


    public UserLogin() {
    }

    public UserLogin(Long id, String email, String password, Role role, UserProfile userProfile, UserWork works) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.userProfile = userProfile;
        this.works = works;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public UserWork getWorks() {
        return works;
    }

    public void setWorks(UserWork works) {
        this.works = works;
    }
}

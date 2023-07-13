//package com.polaris.appWebPolaris.dto;
//
//import java.util.Objects;
//
//
//public class UserLoginDto {
//    private String email;
//    private String password;
//    private String role;
//    private Long profileId;
//    private Long workId;
//
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public Long getProfileId() {
//        return profileId;
//    }
//
//    public void setProfileId(Long profileId) {
//        this.profileId = profileId;
//    }
//
//    public Long getWorkId() {
//        return workId;
//    }
//
//    public void setWorkId(Long workId) {
//        this.workId = workId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof UserLoginDto)) return false;
//        UserLoginDto that = (UserLoginDto) o;
//        return Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(role, that.role) && Objects.equals(profileId, that.profileId) && Objects.equals(workId, that.workId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(email, password, role, profileId, workId);
//    }
//
//    @Override
//    public String toString() {
//        return "UserLoginDto{" +
//                "email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", role='" + role + '\'' +
//                ", profileId=" + profileId +
//                ", workId=" + workId +
//                '}';
//    }
//}

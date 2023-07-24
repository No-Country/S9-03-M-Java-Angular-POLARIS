package com.polaris.appWebPolaris.domain.dto;

import com.polaris.appWebPolaris.enums.SkillsEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class VolunteerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dni;
    private LocalDate dateOfBirth;
    private String gender;
    private String province;
    private String locality;
    private String education;
    private String numberCellphone;
    private String description;
    private String availability;
    private String imageProfile;
    private String otherSkills;
    private List<SkillsEnum> skillList;
    private List<ReviewDto> reviewList;

    private String rol;

    @Override
    public String toString() {
        return "VolunteerDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dni='" + dni + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", province='" + province + '\'' +
                ", locality='" + locality + '\'' +
                ", education='" + education + '\'' +
                ", numberCellphone='" + numberCellphone + '\'' +
                ", description='" + description + '\'' +
                ", availability='" + availability + '\'' +
                ", imageProfile='" + imageProfile + '\'' +
                ", otherSkills='" + otherSkills + '\'' +
                ", skillList=" + skillList +
                ", reviewList=" + reviewList +
                ", rol='" + rol + '\'' +
                '}';
    }
}

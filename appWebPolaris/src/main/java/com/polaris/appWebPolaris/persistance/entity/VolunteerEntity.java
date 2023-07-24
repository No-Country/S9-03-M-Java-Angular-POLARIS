package com.polaris.appWebPolaris.persistance.entity;

import com.polaris.appWebPolaris.enums.SkillsEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "volunteers")
@DiscriminatorValue("Volunteer")
public class VolunteerEntity extends CustomerEntity{

    private String firstName;
    private String lastName;
    private String dni;
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
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
    @OneToMany(mappedBy = "volunteer",cascade = CascadeType.ALL)
    private List<VolunteerInstitutionEntity> volunteerInstitutionList;
    @OneToMany(mappedBy = "volunteer",cascade = CascadeType.ALL)
    private List<ReviewEntity> reviewList;

}

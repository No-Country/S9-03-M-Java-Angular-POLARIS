package com.polaris.appWebPolaris.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstNameVolunteer;

    @Column(name = "last_name")
    private String lastName;

    private Integer dni;
    private String gender;
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "contact_number")
    private String contactNumber;
    private String address;
    private String country;
    private boolean residential;
    private String availability;
    private String profession;

    @Column(name = "is_validated")
    private boolean isValidated;
    private boolean experience;
    private String presentation;

    @Column(name = "postal_code")
    private Integer postalCode;

    @OneToMany(mappedBy = "userProfile")
    private List<UserReview> userReviews;


    public UserProfile() {
    }

    public UserProfile(Long id, String firstNameVolunteer, String lastName, Integer dni, String gender, Date dateOfBirth, String contactNumber, String address, String country, boolean residential, String availability, String profession, boolean isValidated, boolean experience, String presentation, Integer postalCode, List<UserReview> userReviews) {
        this.id = id;
        this.firstNameVolunteer = firstNameVolunteer;
        this.lastName = lastName;
        this.dni = dni;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.address = address;
        this.country = country;
        this.residential = residential;
        this.availability = availability;
        this.profession = profession;
        this.isValidated = isValidated;
        this.experience = experience;
        this.presentation = presentation;
        this.postalCode = postalCode;
        this.userReviews = userReviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstNameVolunteer() {
        return firstNameVolunteer;
    }

    public void setFirstNameVolunteer(String firstNameVolunteer) {
        this.firstNameVolunteer = firstNameVolunteer;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isResidential() {
        return residential;
    }

    public void setResidential(boolean residential) {
        this.residential = residential;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public boolean isValidated() {
        return isValidated;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }

    public boolean isExperience() {
        return experience;
    }

    public void setExperience(boolean experience) {
        this.experience = experience;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public List<UserReview> getUserReviews() {
        return userReviews;
    }

    public void setUserReviews(List<UserReview> userReviews) {
        this.userReviews = userReviews;
    }
}

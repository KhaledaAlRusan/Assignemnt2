package com.example.demo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "Participant1")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long participantId;

    @NotEmpty
    @Column(name = "participantName", nullable = false)
    private String participantName;

    @NotNull
    @Column(name = "schoolGrade", nullable = false)
    private Integer schoolGrade;

    @Min(6)
    @Max(10)
    @Column(name = "age")
    private Integer age;

    @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    private Date dob;

    @Email
    @Column(name = "email")
    private String email;

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public Integer getSchoolGrade() {
        return schoolGrade;
    }

    public void setSchoolGrade(Integer schoolGrade) {
        this.schoolGrade = schoolGrade;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

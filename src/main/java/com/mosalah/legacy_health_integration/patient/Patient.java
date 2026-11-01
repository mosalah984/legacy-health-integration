package com.mosalah.legacy_health_integration.patient;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "national_id", nullable = false, unique = true, length = 30)
    private String nationalId;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "blood_type", length = 20)
    private String bloodType;

    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    protected Patient() {
        // Required by JPA
    }

    public static Patient create(
            String nationalId,
            String firstName,
            String lastName,
            LocalDate dateOfBirth,
            String bloodType
    ) {
        Patient patient = new Patient();

        patient.nationalId = nationalId;
        patient.firstName = firstName;
        patient.lastName = lastName;
        patient.dateOfBirth = dateOfBirth;
        patient.bloodType = bloodType;

        return patient;
    }

    @PrePersist
    protected void onCreate() {
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = OffsetDateTime.now(ZoneOffset.UTC);
    }

    // getters and setters
    public UUID getId() {
        return id;
    }

    public String getNationalId() {
        return nationalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getBloodType() {
        return bloodType;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
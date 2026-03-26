package top.yousef.domain.entities;


import jakarta.persistence.*;
import top.yousef.domain.enums.Gender;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {

    @Id
    @SequenceGenerator(
            name = "patientsSeq",
            sequenceName = "patients_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientsSeq")
    public Long id;

    // --- Identity Fields ---
    @Column(unique = true, nullable = false)
    public String keycloakId;

    @Column(length = 100)
    public String name;

    @Column(length = 100)
    public String avatar;

    // --- Patient Specific Fields ---

    @Column(nullable = false)
    public boolean privacyConsent = false;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    public Gender gender;

    public LocalDate birthDate;

    @Column(length = 255)
    public String address;

    @Column(length = 100)
    public String occupation;

    @Column(length = 100)
    public String emergencyContactName;

    @Column(length = 100)
    public String emergencyContactNumber;

    @Column(length = 100)
    public String insuranceProvider;

    @Column(length = 100)
    public String insurancePolicyNumber;

    @Column(length = 100)
    public String allergies;

    @Column(length = 100)
    public String currentMedication;

    @Column(length = 100)
    public String familyMedicalHistory;

    @Column(length = 100)
    public String pastMedicalHistory;

    @Column(length = 100)
    public String identificationType;

    @Column(length = 100)
    public String identificationNumber;

    @Column(length = 100)
    public String identificationDocumentId;

    @Column(length = 100)
    public String identificationDocumentUrl;

    public String primaryPhysicianId;
}
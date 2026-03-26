package top.yousef.presentation.dtos;

import top.yousef.domain.enums.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PatientProfileResponse(
        String id,

        String keycloakId,


        String name,


        String avatar,


        boolean privacyConsent,


        Gender gender,

        LocalDate birthDate,


        String address,


        String occupation,


        String emergencyContactName,


        String emergencyContactNumber,


        String insuranceProvider,


        String insurancePolicyNumber,


        String allergies,


        String currentMedication,


        String familyMedicalHistory,


        String pastMedicalHistory,


        String identificationType,


        String identificationNumber,


        String identificationDocumentId,


        String identificationDocumentUrl,

        String primaryPhysicianId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}

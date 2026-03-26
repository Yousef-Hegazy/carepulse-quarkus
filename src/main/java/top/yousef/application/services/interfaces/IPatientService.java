package top.yousef.application.services.interfaces;

import io.smallrye.mutiny.Uni;
import top.yousef.presentation.dtos.PatientProfileResponse;

public interface IPatientService {
    Uni<PatientProfileResponse> getProfile(String keycloakId);
}

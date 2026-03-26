package top.yousef.application.services;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import top.yousef.application.mappers.PatientMapper;
import top.yousef.application.services.interfaces.IPatientService;
import top.yousef.domain.entities.Patient;
import top.yousef.presentation.dtos.PatientProfileResponse;

@ApplicationScoped
public class PatientService implements IPatientService {

    @Inject
    PatientMapper patientMapper;

    @Override
    @WithSession
    public Uni<PatientProfileResponse> getProfile(String keycloakId) {
        return Patient.<Patient>find("keycloakId", keycloakId)
                .firstResult()
                .onItem().ifNotNull().transform(patientMapper::toDto)
                .onItem().ifNull().failWith(() -> new NotFoundException("Patient not found"));
    }
}

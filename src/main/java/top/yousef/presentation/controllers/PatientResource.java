package top.yousef.presentation.controllers;


import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;
import top.yousef.application.services.interfaces.IPatientService;
import top.yousef.presentation.dtos.PatientProfileResponse;

import java.io.IOException;

@Path("/api/patients")
@Authenticated
@Produces(MediaType.APPLICATION_JSON)
public class PatientResource {

    @Inject
    IPatientService patientService;

    @Inject
    @RequestScoped
    JsonWebToken jwt;

    @GET
    @Path("/profile")
    public Uni<PatientProfileResponse> getPatientProfile() throws IOException {
        var kycId = jwt.getClaim("sub");

        if (kycId == null) {
            throw new NotFoundException();
        }

        return patientService.getProfile(kycId.toString());
    }
}

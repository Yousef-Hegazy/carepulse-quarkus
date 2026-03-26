package top.yousef.application.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import top.yousef.domain.entities.Patient;
import top.yousef.presentation.dtos.PatientProfileResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface PatientMapper {
    PatientProfileResponse toDto(Patient patient);
}

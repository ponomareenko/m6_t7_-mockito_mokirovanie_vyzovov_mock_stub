package ru.netology.patient.service.medical;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.patient.entity.BloodPressure;
import ru.netology.patient.entity.HealthInfo;
import ru.netology.patient.entity.PatientInfo;
import ru.netology.patient.repository.PatientInfoFileRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MedicalServiceImplTest {
    @Mock
    private PatientInfoFileRepository patientInfoFileRepository;

    @InjectMocks
    private MedicalServiceImpl medicalServiceimpl;

    @Test
    void methodWorkCheckBloodPressure() {
        PatientInfo expected = new PatientInfo(
                "user1",
                "Ivan",
                "Ivanov",
                LocalDate.of(1999, 9, 7),
                new HealthInfo(
                        new BigDecimal(36),
                        new BloodPressure(60, 120)));

        Mockito.when(patientInfoFileRepository
                .getById("user1"))
                .thenReturn(new PatientInfo(
                        "user1",
                        "Ivan",
                        "Ivanov",
                        LocalDate.of(1999, 9, 7),
                        new HealthInfo(
                                new BigDecimal(36),
                                new BloodPressure(60, 120)
                        )
                ));

        ArgumentCaptor<PatientInfo> patientInfoCaptor = ArgumentCaptor.forClass(PatientInfo.class);

        // when
        medicalServiceimpl.checkBloodPressure("user1", new BloodPressure(60, 150));

//        // then
//        Mockito.verify(medicalServiceimpl)
//                        .checkBloodPressure(patientInfoCaptor.capture());

        // then2
        Mockito.verify(patientInfoFileRepository)
                .getById("user1");

        PatientInfo patientInfoCaptured = patientInfoCaptor.getValue();

        Assertions.assertEquals(expected, patientInfoCaptured);
    }

    @Test
    void methodWorkCheckTemperature() {

    }

    @Test
    void methodWorkGetPatientInfo() {
        
    }
}

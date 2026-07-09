package ru.netology.patient.service.alert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SendAlertServiceImplTest {
    @Mock
    private SendAlertServiceImpl sendAlertServiceImpl;

    @Test
    void callCheckSend() {
        sendAlertServiceImpl = Mockito.mock(SendAlertServiceImpl.class);

        ArgumentCaptor<String> messageCaptor = ArgumentCaptor.forClass(String.class);

        // when
        sendAlertServiceImpl.send("lol");

        // then
        Mockito.verify(sendAlertServiceImpl)
                .send(messageCaptor.capture());

        String capturedMessage = messageCaptor.getValue();

        assertEquals("lol", capturedMessage);}
}

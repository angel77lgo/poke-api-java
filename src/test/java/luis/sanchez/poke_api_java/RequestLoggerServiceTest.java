package luis.sanchez.poke_api_java;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import luis.sanchez.poke_api_java.models.db.RequestLogger;
import luis.sanchez.poke_api_java.models.dto.RequestLoggerDto;
import luis.sanchez.poke_api_java.repositories.RequestLoggerRepository;
import luis.sanchez.poke_api_java.services.RequestLoggerService;



class RequestLoggerServiceTest {
     @Mock
    private RequestLoggerRepository requestLoggerRepository;

    @InjectMocks
    private RequestLoggerService requestLoggerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateLogRequest() {
        // Arrange
        RequestLoggerDto loggerDto = new RequestLoggerDto();
        loggerDto.setIpOrigin("127.0.0.1");
        loggerDto.setRequestTime(LocalDateTime.now());
        loggerDto.setRequestMethod("POST");
        loggerDto.setRequestPayload("Sample request payload");
        loggerDto.setResponsePayload("Sample response payload");

        // Act
        requestLoggerService.createLogRequest(loggerDto);

        // Assert
        verify(requestLoggerRepository, times(1)).save(any(RequestLogger.class));
    }

    @Test
    void testCreateLogRequest_NullDto() {
        // Arrange & Act
        assertThrows(NullPointerException.class, () -> {
            requestLoggerService.createLogRequest(null);
        });

        // Assert: No interaction with the repository
        verify(requestLoggerRepository, times(0)).save(any(RequestLogger.class));
    }
}

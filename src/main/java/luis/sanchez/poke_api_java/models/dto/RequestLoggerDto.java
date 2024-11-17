package luis.sanchez.poke_api_java.models.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestLoggerDto {
    private String ipOrigin;
    private LocalDateTime requestTime;
    private String requestMethod;
    private String requestPayload;
    private String responsePayload;
}

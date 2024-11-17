package luis.sanchez.poke_api_java.models.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity()
@Table(name = "request_logger")
@Getter
@Setter
public class RequestLogger {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ip_origin", nullable = false)
    private String ipOrigin;

    @Column(name = "request_time", nullable = false)
    private LocalDateTime requestTime;

    @Column(name = "method", nullable = false)
    private String method;

    @Column(name = "request_payload")
    private String requestPayload;

    @Column(name = "response_payload")
    private String responsePayload;
}

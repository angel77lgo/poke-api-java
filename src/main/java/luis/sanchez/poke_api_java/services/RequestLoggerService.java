package luis.sanchez.poke_api_java.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import luis.sanchez.poke_api_java.models.db.RequestLogger;
import luis.sanchez.poke_api_java.models.dto.RequestLoggerDto;
import luis.sanchez.poke_api_java.repositories.RequestLoggerRepository;

@Service
public class RequestLoggerService {
    private final RequestLoggerRepository requestLoggerRepository;

    public RequestLoggerService(RequestLoggerRepository requestLoggerRepository) {
        this.requestLoggerRepository = requestLoggerRepository;
    }

    @Transactional
    public void createLogRequest(RequestLoggerDto loggerDto) {
        RequestLogger requestLogger = new RequestLogger();

        requestLogger.setIpOrigin(loggerDto.getIpOrigin());
        requestLogger.setRequestTime(loggerDto.getRequestTime());
        requestLogger.setMethod(loggerDto.getRequestMethod());

        requestLogger.setRequestPayload(loggerDto.getRequestPayload());
        requestLogger.setResponsePayload(loggerDto.getResponsePayload());
        

        requestLoggerRepository.save(requestLogger);
    }
}

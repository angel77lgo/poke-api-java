package luis.sanchez.poke_api_java.repositories;

import luis.sanchez.poke_api_java.models.db.RequestLogger;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestLoggerRepository extends CrudRepository<RequestLogger, UUID> {

}

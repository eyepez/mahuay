package com.synappsys.mahuay.repository;

import com.synappsys.mahuay.model.Supervisor;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interface: SupervisorRepository
 * Repository interface for managing Supervisor entities.
 * Provides methods for CRUD operations and custom queries.
 *
 * @author eyepez
 * Creation date 15/09/2025
 */
public interface SupervisorRepository extends MongoRepository<Supervisor, String> {

  Optional<Supervisor> findByDocumentNumber(String documentNumber);
}

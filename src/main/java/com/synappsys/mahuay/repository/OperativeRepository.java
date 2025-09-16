package com.synappsys.mahuay.repository;

import com.synappsys.mahuay.model.Operative;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interface: OperativeRepository
 * Repository interface for managing Operative entities in the MongoDB database.
 * Provides methods to perform CRUD operations for operatives.
 *
 * @author eyepez
 * Creation date 02/07/2025
 */
public interface OperativeRepository extends MongoRepository<Operative, String> {

  Optional<Operative> findByName(String name);
}

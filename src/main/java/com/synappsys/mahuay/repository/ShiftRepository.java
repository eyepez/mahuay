package com.synappsys.mahuay.repository;

import com.synappsys.mahuay.model.Shift;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository: ShiftRepository
 * Interface for managing Shift entities in the database.
 * Provides methods for CRUD operations on shifts.
 *
 * @author eyepez
 * Creation date 15/09/2025
 */
public interface ShiftRepository extends MongoRepository<Shift, String> {

  Optional<Shift> findByName(String name);
}

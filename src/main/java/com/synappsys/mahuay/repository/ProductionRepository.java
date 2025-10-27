package com.synappsys.mahuay.repository;

import com.synappsys.mahuay.model.Production;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interface: ProductionRepository
 * Repository interface for managing Production entities in the database.
 * Provides methods to perform CRUD operations for productions.
 *
 * @author eyepez
 * Creation date 21/09/2025
 */
public interface ProductionRepository extends MongoRepository<Production, String> {


}

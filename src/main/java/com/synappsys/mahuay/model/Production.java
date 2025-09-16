package com.synappsys.mahuay.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

/**
 * Class: Production
 * Represents a production record in the system.
 *
 * @author eyepez
 * Creation date 02/07/2025
 */
@Document(collection = "productions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Production {

  @Id
  private String id;

  //azogado
  private double amalgamation;
  //chichiqueo
  private double panning;
  private LocalDate day;
  //refogado
  private double reprocessing;

  private String supervisorId;
  private String operativeId;
  private String shiftId;
}
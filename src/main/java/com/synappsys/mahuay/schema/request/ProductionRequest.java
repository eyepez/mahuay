package com.synappsys.mahuay.schema.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class: ProductionRequest
 * Represents a request to create or update a production entry.
 * Contains fields required for production operations.
 *
 * @author eyepez
 * Creation date 15/09/2025
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionRequest {

  @JsonProperty("azogado")
  private double amalgamation;

  @JsonProperty("chichiqueo")
  private double panning;

  @JsonProperty("fecha")
  private LocalDate day;

  @JsonProperty("refogado")
  private double reprocessing;

  @JsonProperty("supervisor")
  private String supervisorId;

  @JsonProperty("chute")
  private String operativeId;

  @JsonProperty("turno")
  private String shiftId;
}

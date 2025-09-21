package com.synappsys.mahuay.schema.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class: ShiftRequest
 * Represents a request to create or update a work shift.
 * Contains fields required for shift operations.
 *
 * @author eyepez
 * Creation date 02/07/2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShiftRequest {

  @NotBlank
  @JsonProperty("nombre")
  private String name;

  @JsonProperty("horaInicio")
  private LocalTime startDate;

  @JsonProperty("horaFin")
  private LocalTime endDate;
}

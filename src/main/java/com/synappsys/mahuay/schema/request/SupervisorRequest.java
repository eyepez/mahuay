package com.synappsys.mahuay.schema.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class: SupervisorRequest
 * Represents a request to create or update a supervisor.
 * Contains fields required for supervisor operations.
 *
 * @author eyepez
 * Creation date 15/09/2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupervisorRequest {

  @NotBlank
  @JsonProperty("nombre")
  private String name;

  @NotBlank
  @JsonProperty("apellido")
  private String lastName;

  @NotBlank
  @JsonProperty("numeroDocumento")
  private String documentNumber;

  @NotBlank
  @JsonProperty("numeroTelefono")
  private String phoneNumber;
}

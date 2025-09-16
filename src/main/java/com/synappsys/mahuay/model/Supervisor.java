package com.synappsys.mahuay.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Class: Supervisor
 * Represents a supervisor in the system.
 *
 * @author eyepez
 * Creation date 02/07/2025
 */
@Document(collection = "supervisors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supervisor {

  @Id
  private String id;

  @NotBlank
  @Size(max = 50)
  private String name;

  @NotBlank
  @Size(max = 50)
  private String lastName;

  @NotBlank
  @Size(max = 11)
  private String documentNumber;

  @NotBlank
  @Size(max = 20)
  private String phoneNumber;

  private boolean state;
}
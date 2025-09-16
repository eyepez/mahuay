package com.synappsys.mahuay.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class: Shift
 * Represents a work shift in the system.
 *
 * @author eyepez
 * Creation date 02/07/2025
 */
@Document(collection = "shifts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shift {

  @Id
  private String id;

  @NotBlank
  @Size(max = 50)
  private String name;

  private LocalTime startDate;
  private LocalTime endDate;
  private boolean state;

}
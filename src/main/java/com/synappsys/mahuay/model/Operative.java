package com.synappsys.mahuay.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class: Operative
 * Represents a work operative in the system.
 *
 * @author eyepez
 * Creation date 02/07/2025
 */
@Document(collection = "operatives")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operative {

  @Id
  private String id;

  private String name;
  private String supervisorId;
  private boolean state;
}

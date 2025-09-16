package com.synappsys.mahuay.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

/**
 * Class: ProductionDay
 * Represents daily summary information for production.
 *
 * @author eyepez
 * Creation date 02/07/2025
 */
@Document(collection = "production_day")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductionDay {

  @Id
  private String id;

  private LocalDate day;
  private double totalReprocessing;
  private double totalSmelted;
}
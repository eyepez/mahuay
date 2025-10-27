package com.synappsys.mahuay.schema.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class: ProductionResponseDto
 * Data Transfer Object for transferring production data with additional details.
 *
 * @author eyepez
 * Creation date 21/09/2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductionResponseDto {

  private String id;
  private LocalDate day;
  private double amalgamation;
  private double panning;
  private double reprocessing;
  private String supervisorName;
  private String operativeName;
  private String shiftName;
  private double totalReprocessing;
  private double totalSmelted;
}

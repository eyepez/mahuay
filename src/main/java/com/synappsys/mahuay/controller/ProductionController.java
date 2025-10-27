package com.synappsys.mahuay.controller;

import com.synappsys.mahuay.model.Operative;
import com.synappsys.mahuay.model.Production;
import com.synappsys.mahuay.model.Shift;
import com.synappsys.mahuay.model.Supervisor;
import com.synappsys.mahuay.repository.OperativeRepository;
import com.synappsys.mahuay.repository.ProductionRepository;
import com.synappsys.mahuay.repository.ShiftRepository;
import com.synappsys.mahuay.repository.SupervisorRepository;
import com.synappsys.mahuay.schema.dto.ProductionResponseDto;
import com.synappsys.mahuay.schema.request.ProductionRequest;
import com.synappsys.mahuay.schema.response.MessageResponse;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class: ProductionController
 * Controller for managing operations related to shifts and supervisors.
 *
 * @author eyepez
 * Creation date 15/09/2025
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/productions")
@AllArgsConstructor
@Slf4j
public class ProductionController {

  private final ProductionRepository productionRepository;
  private final SupervisorRepository supervisorRepository;
  private final OperativeRepository operativeRepository;
  private final ShiftRepository shiftRepository;

  @PostMapping("")
  public ResponseEntity<MessageResponse> registerProduction(@Valid @RequestBody ProductionRequest request) {
    log.info("Registering production init");
    Production savedProduction = productionRepository.save(toProduction(request));
    log.info("Production registered successfully: {}", savedProduction.getId());
    return ResponseEntity.ok(new MessageResponse("Production registered successfully!"));
  }

  @GetMapping("")
  public ResponseEntity<List<ProductionResponseDto>> getAllProductions() {
    log.info("Fetching all productions with details");
    List<Production> productions = productionRepository.findAll();

    // Agrupa las producciones por día y calcula el total de reprocessing
    Map<LocalDate, Double> totalReprocessingByDay = productions.stream()
        .collect(Collectors.groupingBy(
            Production::getDay,
            Collectors.summingDouble(Production::getReprocessing)
        ));

    // Mapea las producciones a los DTO, usando los totales calculados
    List<ProductionResponseDto> productionResponses = productions.stream()
        .map(prod -> {
          String supervisorName = supervisorRepository.findById(prod.getSupervisorId())
              .map(Supervisor::getName)
              .orElse("Desconocido");
          String operativeName = operativeRepository.findById(prod.getOperativeId())
              .map(Operative::getName)
              .orElse("Desconocido");
          String shiftName = shiftRepository.findById(prod.getShiftId())
              .map(Shift::getName)
              .orElse("Desconocido");

          // Obtiene el total de reprocessing para la fecha de este registro
          double totalReprocessing = totalReprocessingByDay.getOrDefault(prod.getDay(), 0.0);
          double totalSmelted = 0.0; // Aún debes calcular esto

          return new ProductionResponseDto(
              prod.getId(),
              prod.getDay(),
              prod.getAmalgamation(),
              prod.getPanning(),
              prod.getReprocessing(),
              supervisorName,
              operativeName,
              shiftName,
              totalReprocessing,
              totalSmelted
          );
        })
        .toList();

    return ResponseEntity.ok(productionResponses);
  }

  private Production toProduction(ProductionRequest request) {
    Production production = new Production();
    production.setShiftId(request.getShiftId());
    production.setSupervisorId(request.getSupervisorId());
    production.setOperativeId(request.getOperativeId());
    production.setAmalgamation(request.getAmalgamation());
    production.setPanning(request.getPanning());
    production.setReprocessing(request.getReprocessing());
    production.setDay(request.getDay());
    return production;
  }
}

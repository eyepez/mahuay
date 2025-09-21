package com.synappsys.mahuay.controller;

import com.synappsys.mahuay.model.Operative;
import com.synappsys.mahuay.repository.OperativeRepository;
import com.synappsys.mahuay.schema.request.OperativeRequest;
import com.synappsys.mahuay.schema.response.MessageResponse;
import jakarta.validation.Valid;
import java.util.List;
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
 * Controller: OperativeController
 * Handles HTTP requests related to operative registration.
 * Provides endpoints for registering operatives and checking for existing operatives by document number.
 *
 * @author eyepez
 * Creation date 02/07/2025
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/operatives")
@AllArgsConstructor
@Slf4j
public class OperativeController {

  private final OperativeRepository operativeRepository;

  @PostMapping("")
  public ResponseEntity<MessageResponse> registerOperative(@Valid @RequestBody OperativeRequest request) {
    log.info("Registering operative init");
    return operativeRepository.findByName(request.getName())
        .map(existingOperative -> {
          log.warn("Operative with name {} already exists", request.getName());
          return ResponseEntity.badRequest()
              .body(new MessageResponse("Error: Operative with this document number already exists!"));
        })
        .orElseGet(() -> {
          Operative savedOperative = operativeRepository.save(toOperative(request));
          log.info("Operative registered successfully: {}", savedOperative.getId());
          return ResponseEntity.ok(new MessageResponse("Operative registered successfully!"));
        });
  }

  @GetMapping("")
  public ResponseEntity<List<Operative>> getAllOperatives() {
    log.info("Fetching all operatives");
    List<Operative> operatives = operativeRepository.findAll();
    return ResponseEntity.ok(operatives);
  }

  private Operative toOperative(OperativeRequest request) {
    Operative operative = new Operative();
    operative.setName(request.getName());
    operative.setSupervisorId(request.getSupervisorId());
    operative.setState(true);
    return operative;
  }
}

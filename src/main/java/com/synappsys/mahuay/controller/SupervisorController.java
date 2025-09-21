package com.synappsys.mahuay.controller;

import com.synappsys.mahuay.model.Supervisor;
import com.synappsys.mahuay.repository.SupervisorRepository;
import com.synappsys.mahuay.schema.request.SupervisorRequest;
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
 * Controller: SupervisorController
 * Handles HTTP requests related to supervisors.
 * Provides endpoints for managing supervisors.
 * @author eyepez
 * Creation date 15/09/2025
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/supervisors")
@AllArgsConstructor
@Slf4j
public class SupervisorController {

  private final SupervisorRepository supervisorRepository;

  @PostMapping("")
  public ResponseEntity<MessageResponse> registerSupervisor(@Valid @RequestBody SupervisorRequest request) {
    log.info("Registering supervisor init");
    return supervisorRepository.findByDocumentNumber(request.getDocumentNumber())
        .map(existingSupervisor -> {
          log.warn("Supervisor with documentNumber {} already exists", request.getDocumentNumber());
          return ResponseEntity.badRequest()
              .body(new MessageResponse("Error: Supervisor with this name already exists!"));
        })
        .orElseGet(() -> {
          Supervisor savedSupervisor = supervisorRepository.save(toSupervisor(request));
          log.info("Supervisor registered successfully: {}", savedSupervisor.getId());
          return ResponseEntity.ok(new MessageResponse("Supervisor registered successfully!"));
        });
  }

  @GetMapping("")
  public ResponseEntity<List<Supervisor>> getAllSupervisors() {
    log.info("Fetching all supervisors");
    List<Supervisor> supervisors = supervisorRepository.findAll();
    return ResponseEntity.ok(supervisors);
  }

  private Supervisor toSupervisor(SupervisorRequest request) {
    Supervisor supervisor = new Supervisor();
    supervisor.setName(request.getName());
    supervisor.setLastName(request.getLastName());
    supervisor.setDocumentNumber(request.getDocumentNumber());
    supervisor.setPhoneNumber(request.getPhoneNumber());
    supervisor.setState(true);
    return supervisor;
  }
}

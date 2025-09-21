package com.synappsys.mahuay.controller;

import com.synappsys.mahuay.model.Shift;
import com.synappsys.mahuay.repository.ShiftRepository;
import com.synappsys.mahuay.schema.request.ShiftRequest;
import com.synappsys.mahuay.schema.response.MessageResponse;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/shifts")
public class ShiftController {

  private final ShiftRepository shiftRepository;

  @PostMapping("")
  public ResponseEntity<MessageResponse> registerShift(@Valid @RequestBody ShiftRequest request) {
    log.info("Registering shift init");
    return shiftRepository.findByName(request.getName())
        .map(existingShift -> {
          log.warn("Shift with name {} already exists", request.getName());
          return ResponseEntity.badRequest()
              .body(new MessageResponse("Error: Shift with this name already exists!"));
        })
        .orElseGet(() -> {
          Shift savedShift = shiftRepository.save(toShift(request));
          log.info("Shift registered successfully: {}", savedShift.getId());
          return ResponseEntity.ok(new MessageResponse("Shift registered successfully!"));
        });
  }

  @GetMapping("")
  public ResponseEntity<List<Shift>> getAllShifts() {
    log.info("Fetching all shifts");
    List<Shift> shifts = shiftRepository.findAll();
    return ResponseEntity.ok(shifts);
  }

  private Shift toShift(ShiftRequest request) {
    Shift shift = new Shift();
    shift.setName(request.getName());
    shift.setStartDate(request.getStartDate());
    shift.setEndDate(request.getEndDate());
    shift.setState(true);
    return shift;
  }
}
package com.synappsys.mahuay.controller;

import com.synappsys.mahuay.schema.request.ProductionRequest;
import com.synappsys.mahuay.schema.response.MessageResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

  @PostMapping("")
  public ResponseEntity<MessageResponse> registerProduction(@Valid @RequestBody ProductionRequest request) {
    log.info("Registering production init");
    return ResponseEntity.ok(new MessageResponse("Production registered successfully!"));
  }
}

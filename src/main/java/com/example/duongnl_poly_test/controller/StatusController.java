package com.example.duongnl_poly_test.controller;

import com.example.duongnl_poly_test.dto.StatusDTO;
import com.example.duongnl_poly_test.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<List<StatusDTO>> getAllStatus() {
        List<StatusDTO> listStatusDTO = statusService.getAllStatus();
        return ResponseEntity.ok(listStatusDTO);

    }
}

package com.ringcentral.test.controllers;

import com.ringcentral.test.dtos.CarDto;
import com.ringcentral.test.dtos.CarInfoDto;
import com.ringcentral.test.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<CarInfoDto>> getCars() {
        return ResponseEntity.ok(carService.getCars());
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<CarInfoDto>> getCarsPaged(@PageableDefault(sort = { "title" }, direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(carService.getCars(pageable));
    }

    @GetMapping("/{carId}")
    public ResponseEntity<CarDto> getCar(@PathVariable Integer carId) {
        return carService.getCar(carId)
                .map(ResponseEntity::ok).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found"));
    }
}


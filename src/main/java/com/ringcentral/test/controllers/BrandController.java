package com.ringcentral.test.controllers;

import com.ringcentral.test.dtos.BrandDto;
import com.ringcentral.test.services.BrandService;
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
@RequestMapping("/api/v1/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<List<BrandDto>> getBrands() {
        return ResponseEntity.ok(brandService.getBrands());
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<BrandDto>> getBrandsPaged(@PageableDefault(sort = { "country" }, direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(brandService.getBrands(pageable));
    }

    @GetMapping("/{brandId}")
    public ResponseEntity<BrandDto> getBrand(@PathVariable Integer brandId) {
        return brandService.getBrand(brandId)
            .map(ResponseEntity::ok).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Brand not found"));
    }
}


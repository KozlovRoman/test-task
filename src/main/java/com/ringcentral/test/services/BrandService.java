package com.ringcentral.test.services;

import com.ringcentral.test.dtos.BrandDto;
import com.ringcentral.test.entities.Brand;
import com.ringcentral.test.repositories.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;

    private static BrandDto toDto(Brand brand) {
        return new BrandDto(brand.getId(), brand.getTitle(), brand.getCountry().getTitle());
    }

    public Optional<BrandDto> getBrand(Integer id) {
        return brandRepository.findById(id).map(BrandService::toDto);
    }

    public Page<BrandDto> getBrands(Pageable pageable) {
        return brandRepository.findAll(pageable).map(BrandService::toDto);
    }

    public List<BrandDto> getBrands() {
        return StreamSupport.stream(brandRepository.findAll().spliterator(), false)
            .map(BrandService::toDto)
            .collect(Collectors.toList());
    }
}

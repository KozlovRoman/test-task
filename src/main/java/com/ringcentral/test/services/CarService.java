package com.ringcentral.test.services;

import com.ringcentral.test.dtos.CarDto;
import com.ringcentral.test.dtos.CarInfoDto;
import com.ringcentral.test.entities.Generation;
import com.ringcentral.test.entities.Model;
import com.ringcentral.test.entities.Modification;
import com.ringcentral.test.repositories.ModificationRepository;
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
public class CarService {
    private final ModificationRepository modificationRepository;

    private static CarInfoDto toInfoDto(Modification modification) {
        Model model = modification.getGeneration().getModel();
        return new CarInfoDto(modification.getId(), model.getSegment().getTitle(),
            model.getBrand().getId(), model.getTitle(), modification.getGeneration().getTitle(), modification.getTitle());
    }

    private static CarDto toDto(Modification modification) {
        Generation generation = modification.getGeneration();
        Model model = generation.getModel();
        return new CarDto(modification.getId(), model.getSegment().getTitle(),
            model.getBrand().getId(), model.getTitle(), modification.getGeneration().getTitle(), modification.getTitle(),
            generation.getYears(), modification.getFuelType(), modification.getEngineType(), modification.getEngineDisplacement(),
            modification.getHorsepower(), modification.getGearboxType(), modification.getWheelDriveType(), generation.getLength(), generation.getWidth(),
            generation.getHeight(), modification.getBodyStyle(), modification.getAcceleration(), modification.getMaxSpeed());
    }

    public List<CarInfoDto> getCars() {
        return StreamSupport.stream(modificationRepository.findAll().spliterator(), false)
            .map(CarService::toInfoDto)
            .collect(Collectors.toList());
    }

    public Page<CarInfoDto> getCars(Pageable pageable) {
        return modificationRepository.findAll(pageable).map(CarService::toInfoDto);
    }

    public Optional<CarDto> getCar(Integer carId) {
        return modificationRepository.findById(carId).map(CarService::toDto);
    }
}

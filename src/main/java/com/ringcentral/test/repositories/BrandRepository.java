package com.ringcentral.test.repositories;

import com.ringcentral.test.entities.Brand;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BrandRepository extends PagingAndSortingRepository<Brand, Integer> {
}

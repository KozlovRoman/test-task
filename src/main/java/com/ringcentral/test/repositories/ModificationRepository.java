package com.ringcentral.test.repositories;

import com.ringcentral.test.entities.Modification;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ModificationRepository extends PagingAndSortingRepository<Modification, Integer> {
}

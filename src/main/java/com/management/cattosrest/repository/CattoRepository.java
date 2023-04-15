package com.management.cattosrest.repository;

import com.management.cattosrest.entity.Catto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CattoRepository extends JpaRepository<Catto, Long> {
}

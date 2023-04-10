package com.payroll.gatosrest.repository;

import com.payroll.gatosrest.entity.Gato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GatosRepository extends JpaRepository<Gato, Long> {
}

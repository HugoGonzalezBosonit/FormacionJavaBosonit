package com.bosonit.cliente.repository;

import com.bosonit.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {}

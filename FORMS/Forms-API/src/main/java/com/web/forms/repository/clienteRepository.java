package com.web.forms.repository;

import com.web.forms.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clienteRepository extends JpaRepository<Cliente, Long> {

}

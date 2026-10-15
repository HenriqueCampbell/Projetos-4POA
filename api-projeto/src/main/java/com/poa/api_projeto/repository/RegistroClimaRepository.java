package com.poa.api_projeto.repository;


import com.poa.api_projeto.model.RegistroClima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroClimaRepository extends JpaRepository<RegistroClima, Long> {

}
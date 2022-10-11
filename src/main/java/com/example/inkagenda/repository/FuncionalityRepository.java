package com.example.inkagenda.repository;

import com.example.inkagenda.model.Funcionality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface FuncionalityRepository extends JpaRepository<Funcionality, Long> {
}

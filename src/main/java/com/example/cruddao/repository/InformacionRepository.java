package com.example.cruddao.repository;

import com.example.cruddao.model.Informacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformacionRepository extends JpaRepository<Informacion, Long> {
}

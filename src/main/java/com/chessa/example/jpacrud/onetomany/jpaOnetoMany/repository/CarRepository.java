package com.chessa.example.jpacrud.onetomany.jpaOnetoMany.repository;


import com.chessa.example.jpacrud.onetomany.jpaOnetoMany.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Cars, Long> {
}

package com.guilherme.sistema_pet.repository;

import com.guilherme.sistema_pet.model.PetModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PetRepository extends JpaRepository<PetModel,Long>{
}

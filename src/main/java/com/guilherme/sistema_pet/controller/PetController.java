package com.guilherme.sistema_pet.controller;
import com.guilherme.sistema_pet.model.PetModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.guilherme.sistema_pet.repository.PetRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @PostMapping
    public ResponseEntity<PetModel> criarPet(@RequestBody PetModel pet) {
        PetModel novoPet = petRepository.save(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPet);
    }


    @GetMapping
    public ResponseEntity<List<PetModel>> listarPets() {
        List<PetModel> pets = petRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(pets);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPet(@PathVariable Long id) {
        Optional<PetModel> pet = petRepository.findById(id);

        if (pet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pet não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(pet.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody PetModel pet) {

        Optional<PetModel> petExistente = petRepository.findById(id);

        if (petExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pet não encontrado");
        }

        pet.setId(id);
        PetModel petAtualizado = petRepository.save(pet);

        return ResponseEntity.status(HttpStatus.OK).body(petAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPet(@PathVariable Long id) {
        Optional<PetModel> pet = petRepository.findById(id);

        if (pet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pet não encontrado");
        }

        petRepository.delete(pet.get());
        return ResponseEntity.status(HttpStatus.OK)
                .body("Pet deletado com sucesso");
    }

}

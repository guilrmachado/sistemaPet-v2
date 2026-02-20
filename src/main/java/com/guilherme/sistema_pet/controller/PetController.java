package com.guilherme.sistema_pet.controller;
import com.guilherme.sistema_pet.model.PetModel;
import com.guilherme.sistema_pet.service.PetService;
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

    private final PetService service;

    public PetController(PetService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PetModel> criarPet(@RequestBody PetModel pet) {
        PetModel novoPet = service.salvar(pet);
        return ResponseEntity.ok(novoPet);
    }


    @GetMapping
    public ResponseEntity<List<PetModel>> listarPets() {
        List<PetModel> pets = service.listar();
        return ResponseEntity.ok(pets);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PetModel> buscarPet(@PathVariable Long id) {
        PetModel pet = service.buscarPorId(id);
        return ResponseEntity.ok(pet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody PetModel pet) {

        PetModel petExistente = service.atualizar(id,pet);
        return ResponseEntity.ok(petExistente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPet(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok("Pet deletado com sucesso");
    }

}

package com.guilherme.sistema_pet.service;

import com.guilherme.sistema_pet.model.PetModel;
import com.guilherme.sistema_pet.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final PetRepository repository;

    public PetService(PetRepository repository){
        this.repository = repository;
    }

    public PetModel salvar(PetModel pet){
        if (pet.getPeso() > 60 || pet.getPeso() < 0.5){
            throw new IllegalArgumentException("Peso inválido.");
        }
        if (pet.getNome() == null || pet.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }

        if (!pet.getNome().matches("[A-Za-zÀ-ÿ ]+")) {
            throw new IllegalArgumentException("Nome só pode conter letras.");
        }

        if (pet.getNome().trim().split("\\s+").length < 2) {
            throw new IllegalArgumentException("Digite nome e sobrenome.");
        }
        if (pet.getIdade() > 20) {
            throw new IllegalArgumentException("Idade inválida.");
        }

        if (pet.getIdade() < 1) {
             double idade = pet.getIdade() / 12;
            pet.setIdade(idade);
        }
        if (pet.getRaca() == null || pet.getRaca().trim().isEmpty()) {
            throw new IllegalArgumentException("Raça não pode ser vazio.");
        }

        if (!pet.getRaca().matches("[A-Za-zÀ-ÿ ]+")) {
            throw new IllegalArgumentException("Raça inválida.");
        }
        return repository.save(pet);
    }

    public List<PetModel> listar(){
        return repository.findAll();
    }

    public PetModel buscarPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

    }

    public PetModel atualizar(Long id,PetModel petAtualizado){
        PetModel petExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        petExistente.setNome(petAtualizado.getNome());
        petExistente.setIdade(petAtualizado.getIdade());
        petExistente.setCasa(petAtualizado.getCasa());
        petExistente.setBairro(petAtualizado.getBairro());
        petExistente.setCidade(petAtualizado.getCidade());
        petExistente.setRaca(petAtualizado.getRaca());
        petExistente.setSexo(petAtualizado.getSexo());
        petExistente.setTipo(petAtualizado.getTipo());
        petExistente.setPeso(petAtualizado.getPeso());
        petExistente.setRua(petAtualizado.getRua());
        return repository.save(petExistente);
    }

    public void deletar(Long id){
        PetModel petExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));
        repository.delete(petExistente);
    }
}

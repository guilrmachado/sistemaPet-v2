package com.guilherme.sistema_pet.service;

import com.guilherme.sistema_pet.model.PetModel;
import com.guilherme.sistema_pet.model.SEXO;
import com.guilherme.sistema_pet.model.TIPO;
import com.guilherme.sistema_pet.repository.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetServiceTest {

    @Mock
    private PetRepository repository;

    @InjectMocks
    private PetService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveBuscarPetPorId() {
        PetModel pet = new PetModel();
        pet.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(pet));

        PetModel resultado = service.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
    }

    @Test
    void deveLancarExcecaoQuandoNaoEncontrar() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            service.buscarPorId(1L);
        });
    }

    @Test
    void deveSalvarPetValido() {

        PetModel pet = new PetModel();
        pet.setNome("Max Rodrigues");
        pet.setPeso(10.0);
        pet.setIdade(5.0);
        pet.setTipo(TIPO.CACHORRO);
        pet.setRaca("Viralata");
        pet.setSexo(SEXO.FEMEA);
        pet.setBairro("Tijuca");
        pet.setCasa(302);
        pet.setRua("Rua Afonso Pena");
        pet.setCidade("Rio de Janeiro");

        when(repository.save(pet)).thenReturn(pet);

        PetModel resultado = service.salvar(pet);

        assertNotNull(resultado);
        assertEquals("Max Rodrigues", resultado.getNome());

        verify(repository, times(1)).save(pet);
    }

    @Test
    void naoDeveSalvarPetComPesoInvalido() {

        PetModel pet = new PetModel();
        pet.setNome("Rex");
        pet.setPeso(-5.0); // peso inválido

        assertThrows(IllegalArgumentException.class, () -> {
            service.salvar(pet);
        });

        verify(repository, never()).save(any());
    }

}
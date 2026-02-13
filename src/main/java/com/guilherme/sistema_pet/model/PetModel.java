package com.guilherme.sistema_pet.model;
import jakarta.persistence.*;

@Entity
@Table(name = "pets")
public class PetModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Enumerated(EnumType.STRING)
    private TIPO tipo;
    @Enumerated(EnumType.STRING)
    private SEXO sexo;
    private String rua;
    private Integer casa;
    private String bairro;
    private String cidade;
    private Double idade;
    private Double peso;
    private String raca;

    public PetModel() {
    }

    public PetModel(Long id, String nome, TIPO tipo, SEXO sexo, String rua, Integer casa, String bairro, String cidade, Double idade, Double peso, String raca) {
        this.id= id;
        this.nome = nome;
        this.tipo = tipo;
        this.sexo = sexo;
        this.rua = rua;
        this.casa = casa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TIPO getTipo() {
        return tipo;
    }

    public void setTipo(TIPO tipo) {
        this.tipo = tipo;
    }

    public SEXO getSexo() {
        return sexo;
    }

    public void setSexo(SEXO sexo) {
        this.sexo = sexo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getCasa() {
        return casa;
    }

    public void setCasa(Integer casa) {
        this.casa = casa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Double getIdade() {
        return idade;
    }

    public void setIdade(Double idade) {
        this.idade = idade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "Tipo: " + tipo + "\n" +
                "Sexo: " + sexo + "\n" +
                "Idade: " + idade + "\n" +
                "Peso: " + peso + "\n" +
                "Rua: " + rua + "\n" +
                "Número: " + casa + "\n" +
                "Bairro: " + bairro + "\n" +
                "Cidade: " + cidade + "\n" +
                "Raça: " + raca + "\n" +
                "------------------------\n";
    }
}

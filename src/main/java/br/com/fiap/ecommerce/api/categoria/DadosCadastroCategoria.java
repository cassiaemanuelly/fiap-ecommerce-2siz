package br.com.fiap.ecommerce.api.categoria;

<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroCategoria(
        @NotBlank //Não aceita nulos ou espaços em branco
        @Size(min = 3, max = 60) //define tamanho mínimo e/ou máximo
        @Column(unique=true) //obriga valores não repetidos
        String nome,

        @Size(max = 255)
        String descricao) {
=======
public record DadosCadastroCategoria(String nome, String descricao) {
>>>>>>> ecca596878f6db7bdf7a3bdc3050edb379740301
}

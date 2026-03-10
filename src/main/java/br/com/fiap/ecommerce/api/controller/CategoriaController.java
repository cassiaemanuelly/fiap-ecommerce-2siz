package br.com.fiap.ecommerce.api.controller;

import br.com.fiap.ecommerce.api.categoria.Categoria;
import br.com.fiap.ecommerce.api.categoria.CategoriaRepository;
import br.com.fiap.ecommerce.api.categoria.DadosCadastroCategoria;
import br.com.fiap.ecommerce.api.categoria.DadosListagemCategoria;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //define que esta classe é um controller REST
@RequestMapping("categorias") //define o caminho que recebrá as requisições
public class CategoriaController {

    @Autowired //spring instancia o objeto para nós
    private CategoriaRepository categoriaRepository;

    @Transactional //rollback no banco em caso de erros
    @PostMapping //recebe as requisições do tipo POST
    //Recebe o conteúdo de Body e garante que é válido conforme as retrições do DTO
    public void cadastrarCategoria(@RequestBody @Valid DadosCadastroCategoria dados){
        categoriaRepository.save(new Categoria(dados));
    }

    @GetMapping //recebe as requisições do tipo GET
    public List<DadosListagemCategoria> listarCategorias(){
         return categoriaRepository.findAll()
                 .stream()
                 .map(DadosListagemCategoria::new)
                 .toList();
    }
}

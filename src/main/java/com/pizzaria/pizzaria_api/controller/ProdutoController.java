package com.pizzaria.pizzaria_api.controller;

import com.pizzaria.pizzaria_api.dto.ProdutoDTO;
import com.pizzaria.pizzaria_api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
@CrossOrigin("http://localhost:4200")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<ProdutoDTO> findById(@RequestParam("id") final Long id){
        try {
            ProdutoDTO produtoDTO = this.produtoService.findById(id);

            return ResponseEntity.ok(produtoDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new ProdutoDTO());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProdutoDTO>> findAll(){
        try {
            List<ProdutoDTO> produtoDTO = this.produtoService.findAll();

            return ResponseEntity.ok(produtoDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new ArrayList<>());
        }
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody final ProdutoDTO produtoDTO){
        try {
            this.produtoService.create(produtoDTO);

            return ResponseEntity.ok("Cadastrado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestParam("id") final Long id, @RequestBody final ProdutoDTO produtoDTO){
        try {
            this.produtoService.update(id, produtoDTO);

            return ResponseEntity.ok("Editado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam("id") final Long id){
        try {
            this.produtoService.delete(id);

            return ResponseEntity.ok("Exlcuido com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

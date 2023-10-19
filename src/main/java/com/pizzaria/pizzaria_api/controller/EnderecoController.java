package com.pizzaria.pizzaria_api.controller;

import com.pizzaria.pizzaria_api.dto.EnderecoDTO;
import com.pizzaria.pizzaria_api.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@CrossOrigin("http://localhost:4200")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<EnderecoDTO> findById(@RequestParam("id") final Long id){
        try {
            EnderecoDTO enderecoDTO = this.enderecoService.findById(id);

            return ResponseEntity.ok(enderecoDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new EnderecoDTO());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<EnderecoDTO>> findAll(){
        try {
            List<EnderecoDTO> enderecosDTO = this.enderecoService.findAll();

            return ResponseEntity.ok(enderecosDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new ArrayList<EnderecoDTO>());
        }
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody final EnderecoDTO enderecoDTO){
        try {
            this.enderecoService.create(enderecoDTO);

            return ResponseEntity.ok("Cadastrado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestParam("id") final Long id, @RequestBody final EnderecoDTO enderecoDTO){
        try {
            this.enderecoService.update(id, enderecoDTO);

            return ResponseEntity.ok("Editado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam("id") final Long id){
        try {
            this.enderecoService.delete(id);

            return ResponseEntity.ok("Exlcuido com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

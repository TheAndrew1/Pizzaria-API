package com.pizzaria.pizzaria_api.controller;

import com.pizzaria.pizzaria_api.dto.FuncionarioDTO;
import com.pizzaria.pizzaria_api.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
@CrossOrigin("http://localhost:4200")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<FuncionarioDTO> findById(@RequestParam("id") final Long id){
        try {
            FuncionarioDTO funcionarioDTO = this.funcionarioService.findById(id);

            return ResponseEntity.ok(funcionarioDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new FuncionarioDTO());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<FuncionarioDTO>> findAll(){
        try {
            List<FuncionarioDTO> funcionariosDTO = this.funcionarioService.findAll();

            return ResponseEntity.ok(funcionariosDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new ArrayList<FuncionarioDTO>());
        }
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody final FuncionarioDTO funcionarioDTO){
        try {
            this.funcionarioService.create(funcionarioDTO);

            return ResponseEntity.ok("Cadastrado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestParam("id") final Long id, @RequestBody final FuncionarioDTO funcionarioDTO){
        try {
            this.funcionarioService.update(id, funcionarioDTO);

            return ResponseEntity.ok("Editado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam("id") final Long id){
        try {
            this.funcionarioService.delete(id);

            return ResponseEntity.ok("Exlcuido com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

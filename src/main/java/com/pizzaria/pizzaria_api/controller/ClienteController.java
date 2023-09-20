package com.pizzaria.pizzaria_api.controller;

import com.pizzaria.pizzaria_api.dto.ClienteDTO;
import com.pizzaria.pizzaria_api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<ClienteDTO> findById(@RequestParam("id") final Long id){
        try {
            ClienteDTO clienteDTO = this.clienteService.findById(id);

            return ResponseEntity.ok(clienteDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new ClienteDTO());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<ClienteDTO>> findAll(){
        try {
            List<ClienteDTO> clientesDTO = this.clienteService.findAll();

            return ResponseEntity.ok(clientesDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new ArrayList<ClienteDTO>());
        }
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody final ClienteDTO clienteDTO){
        try {
            this.clienteService.create(clienteDTO);

            return ResponseEntity.ok("Cadastrado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestParam("id") final Long id, @RequestBody final ClienteDTO clienteDTO){
        try {
            this.clienteService.update(id, clienteDTO);

            return ResponseEntity.ok("Editado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam("id") final Long id){
        try {
            this.clienteService.delete(id);

            return ResponseEntity.ok("Exlcuido com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
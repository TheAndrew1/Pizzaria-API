package com.pizzaria.PizzariaAPI.Controller;

import com.pizzaria.PizzariaAPI.DTO.ClienteDTO;
import com.pizzaria.PizzariaAPI.Service.ClienteService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
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
}

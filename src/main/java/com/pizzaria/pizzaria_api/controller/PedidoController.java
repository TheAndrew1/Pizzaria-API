package com.pizzaria.pizzaria_api.controller;

import com.pizzaria.pizzaria_api.dto.PedidoDTO;
import com.pizzaria.pizzaria_api.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pedido")
@CrossOrigin("http://localhost:4200")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<PedidoDTO> findById(@RequestParam("id") final Long id){
        try {
            PedidoDTO pedidoDTO = this.pedidoService.findById(id);

            return ResponseEntity.ok(pedidoDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new PedidoDTO());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<PedidoDTO>> findAll(){
        try {
            List<PedidoDTO> pedidosDTO = this.pedidoService.findAll();

            return ResponseEntity.ok(pedidosDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new ArrayList<PedidoDTO>());
        }
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody final PedidoDTO pedidoDTO){
        try {
            this.pedidoService.create(pedidoDTO);

            return ResponseEntity.ok("Cadastrado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestParam("id") final Long id, @RequestBody final PedidoDTO pedidoDTO){
        try {
            this.pedidoService.update(id, pedidoDTO);

            return ResponseEntity.ok("Editado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam("id") final Long id){
        try {
            this.pedidoService.delete(id);

            return ResponseEntity.ok("Exlcuido com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

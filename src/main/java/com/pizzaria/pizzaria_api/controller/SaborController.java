package com.pizzaria.pizzaria_api.controller;

import com.pizzaria.pizzaria_api.dto.SaborDTO;
import com.pizzaria.pizzaria_api.service.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sabor")
@CrossOrigin("http://localhost:4200")
public class SaborController {
    @Autowired
    private SaborService saborService;

    @GetMapping
    public ResponseEntity<SaborDTO> findById(@RequestParam("id") final Long id){
        try {
            SaborDTO saborDTO = this.saborService.findById(id);

            return ResponseEntity.ok(saborDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new SaborDTO());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<SaborDTO>> findAll(){
        try {
            List<SaborDTO> saboresDTO = this.saborService.findAll();

            return ResponseEntity.ok(saboresDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new ArrayList<>());
        }
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody final SaborDTO saborDTO){
        try {
            this.saborService.create(saborDTO);

            return ResponseEntity.ok("Cadastrado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestParam("id") final Long id, @RequestBody final SaborDTO saborDTO){
        try {
            this.saborService.update(id, saborDTO);

            return ResponseEntity.ok("Editado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam("id") final Long id){
        try {
            this.saborService.delete(id);

            return ResponseEntity.ok("Exlcuido com sucesso!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

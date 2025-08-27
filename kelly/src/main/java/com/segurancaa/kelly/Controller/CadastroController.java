package com.segurancaa.kelly.Controller;

import com.segurancaa.kelly.Bunisses.CadastroService;
import com.segurancaa.kelly.Infrascture.Entites.Cadastro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {
    private final CadastroService service;

    public CadastroController(CadastroService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Cadastro>salvar(@RequestBody Cadastro cadastro) {
        return ResponseEntity.ok(service.salvar(cadastro));
    }
    @GetMapping
    public ResponseEntity<List<Cadastro>> listar() {
        return ResponseEntity.ok(service.listar());
    }
}

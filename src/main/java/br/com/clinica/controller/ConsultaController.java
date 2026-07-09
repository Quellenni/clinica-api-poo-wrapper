package br.com.clinica.controller;

import br.com.clinica.dto.ConsultaRequest;
import br.com.clinica.dto.ConsultaResponse;
import br.com.clinica.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsultaResponse agendar(@RequestBody @Valid ConsultaRequest request) {
        return consultaService.agendar(request);
    }

    @GetMapping
    public List<ConsultaResponse> listar() {
        return consultaService.listar();
    }

    @GetMapping("/{id}")
    public ConsultaResponse buscarPorId(@PathVariable Long id) {
        return consultaService.buscarPorId(id);
    }

    @PatchMapping("/{id}/cancelar")
    public ConsultaResponse cancelar(@PathVariable Long id) {
        return consultaService.cancelar(id);
    }
}

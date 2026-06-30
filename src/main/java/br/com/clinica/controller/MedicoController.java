package br.com.clinica.controller;

import br.com.clinica.dto.MedicoRequest;
import br.com.clinica.dto.MedicoAtualizacaoRequest;
import br.com.clinica.dto.MedicoResponse;
import br.com.clinica.dto.PacienteAtualizacaoRequest;
import br.com.clinica.dto.PacienteResponse;
import br.com.clinica.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService){
        this.medicoService = medicoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedicoResponse cadastrar(@RequestBody @Valid MedicoRequest request) {
        return medicoService.cadastrar(request);
    }

    @GetMapping
    public List<MedicoResponse> listar() {
        return medicoService.listar();
    }

    @GetMapping("/{id}")
    public MedicoResponse buscarPorId(@PathVariable Long id) {
        return medicoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public MedicoResponse atualizar(@PathVariable Long id, @RequestBody @Valid MedicoAtualizacaoRequest request) {
        return medicoService.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        medicoService.excluir(id);
    }
}

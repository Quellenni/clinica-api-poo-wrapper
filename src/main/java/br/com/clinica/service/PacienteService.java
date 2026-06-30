package br.com.clinica.service;

import br.com.clinica.dto.PacienteRequest;
import br.com.clinica.dto.PacienteAtualizacaoRequest;
import br.com.clinica.exception.RecursoNaoEncontradoException;
import br.com.clinica.exception.RegraNegocioException;
import br.com.clinica.dto.PacienteResponse;
import br.com.clinica.model.Paciente;
import br.com.clinica.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public PacienteResponse cadastrar(PacienteRequest request) {
        if(pacienteRepository.findByCpf(request.getCpf()).isPresent()) {
            throw new RegraNegocioException("Já existe um paciente cadastrado com este CPF.");
        }
        Paciente paciente = new Paciente(
                request.getNome(),
                request.getCpf(),
                request.getTelefone()
        );

        Paciente pacienteSalvo = pacienteRepository.save(paciente);
        return new PacienteResponse(pacienteSalvo);
    }

    public List<PacienteResponse> listar() {
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteResponse::new)
                .toList();
    }

    public PacienteResponse buscarPorId(Long id){
        Paciente paciente = buscarPaciente(id);
        return new PacienteResponse(paciente);
    }

    public PacienteResponse atualizar(Long id, PacienteAtualizacaoRequest request){
        
        Paciente paciente = buscarPaciente(id);

        paciente.atualizarDados(request.getNome(), request.getTelefone());

        Paciente pacienteAtualizado = pacienteRepository.save(paciente);
        return new PacienteResponse(pacienteAtualizado);
    }

    public void excluir(Long id){
        Paciente paciente = buscarPaciente(id);

        pacienteRepository.delete(paciente);
    }

    private Paciente buscarPaciente(Long id){
        return pacienteRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Paciente não encontrado"));
    }
}

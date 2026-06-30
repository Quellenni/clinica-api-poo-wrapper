package br.com.clinica.service;

import br.com.clinica.model.Medico;
import br.com.clinica.repository.MedicoRepository;
import br.com.clinica.dto.MedicoAtualizacaoRequest;
import br.com.clinica.dto.MedicoRequest;
import br.com.clinica.dto.MedicoResponse;
import br.com.clinica.exception.RecursoNaoEncontradoException;
import br.com.clinica.exception.RegraNegocioException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public MedicoResponse cadastrar(MedicoRequest request) {
        if(medicoRepository.findByCrm(request.getCrm()).isPresent()) {
            throw new RegraNegocioException("Já existe um médico cadastrado com este CRM.");
        }
        Medico medico = new Medico(
                request.getNome(),
                request.getCrm(),
                request.getEspecialidade(),
                request.getTelefone()
        );

        Medico medicoSalvo = medicoRepository.save(medico);
        return new MedicoResponse(medicoSalvo);
    }

    public List<MedicoResponse> listar() {
        return medicoRepository.findAll()
                .stream()
                .map(MedicoResponse::new)
                .toList();
    }

    public MedicoResponse buscarPorId(Long id){
        Medico medico = buscarMedico(id);

        return new MedicoResponse(medico);
    }

    public MedicoResponse atualizar(Long id, MedicoAtualizacaoRequest request){
        Medico medico = buscarMedico(id);

        medico.atualizarDados(request.getNome(), request.getEspecialidade(), request.getTelefone());
        Medico medicoAtualizado = medicoRepository.save(medico);
        return new MedicoResponse(medicoAtualizado);
    }

    public void excluir(Long id){
        Medico medico = buscarMedico(id);

        medicoRepository.delete(medico);
    }

    private Medico buscarMedico(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Médico não encontrado."));
    }
}

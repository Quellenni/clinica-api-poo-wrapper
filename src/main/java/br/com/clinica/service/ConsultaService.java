package br.com.clinica.service;

import br.com.clinica.dto.ConsultaRequest;
import br.com.clinica.dto.ConsultaResponse;
import br.com.clinica.exception.RecursoNaoEncontradoException;
import br.com.clinica.exception.RegraNegocioException;
import br.com.clinica.model.Consulta;
import br.com.clinica.model.Medico;
import br.com.clinica.model.Paciente;
import br.com.clinica.model.StatusConsulta;
import br.com.clinica.repository.ConsultaRepository;
import br.com.clinica.repository.MedicoRepository;
import br.com.clinica.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public ConsultaService(
            ConsultaRepository consultaRepository,
            PacienteRepository pacienteRepository,
            MedicoRepository medicoRepository
    ) {
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
    }

    public ConsultaResponse agendar(ConsultaRequest request) {
        Paciente paciente = buscarPaciente(request.getPacienteId());
        Medico medico = buscarMedico(request.getMedicoId());

        validarDisponibilidadeDoMedico(request);
        validarDisponibilidadeDoPaciente(request);

        Consulta consulta = new Consulta(
                paciente,
                medico,
                request.getDataHora(),
                StatusConsulta.AGENDADA
        );

        Consulta consultaSalva = consultaRepository.save(consulta);
        return new ConsultaResponse(consultaSalva);
    }

    public List<ConsultaResponse> listar() {
        return consultaRepository.findAll()
                .stream()
                .map(ConsultaResponse::new)
                .toList();
    }

    public ConsultaResponse buscarPorId(Long id) {
        Consulta consulta = buscarConsulta(id);
        return new ConsultaResponse(consulta);
    }

    public ConsultaResponse cancelar(Long id) {
        Consulta consulta = buscarConsulta(id);
        consulta.cancelar();

        Consulta consultaCancelada = consultaRepository.save(consulta);
        return new ConsultaResponse(consultaCancelada);
    }

    private void validarDisponibilidadeDoMedico(ConsultaRequest request) {
        boolean medicoIndisponivel = consultaRepository.existsByMedicoIdAndDataHora(
                request.getMedicoId(),
                request.getDataHora()
        );

        if (medicoIndisponivel) {
            throw new RegraNegocioException("Já existe uma consulta para este médico nesta data e horário.");
        }
    }

    private void validarDisponibilidadeDoPaciente(ConsultaRequest request) {
        boolean pacienteIndisponivel = consultaRepository.existsByPacienteIdAndDataHora(
                request.getPacienteId(),
                request.getDataHora()
        );

        if (pacienteIndisponivel) {
            throw new RegraNegocioException("Já existe uma consulta para este paciente nesta data e horário.");
        }
    }

    private Consulta buscarConsulta(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Consulta não encontrada."));
    }

    private Paciente buscarPaciente(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Paciente não encontrado."));
    }

    private Medico buscarMedico(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Médico não encontrado."));
    }
}

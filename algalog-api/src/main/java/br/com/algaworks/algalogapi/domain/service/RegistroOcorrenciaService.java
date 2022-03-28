package br.com.algaworks.algalogapi.domain.service;

import br.com.algaworks.algalogapi.domain.exception.NegocioException;
import br.com.algaworks.algalogapi.domain.model.Entrega;
import br.com.algaworks.algalogapi.domain.model.Ocorrencia;
import br.com.algaworks.algalogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {
    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return entrega.adicionarOcorrencia(descricao);
    }

}

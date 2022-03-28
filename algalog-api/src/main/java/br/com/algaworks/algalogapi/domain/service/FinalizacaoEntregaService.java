package br.com.algaworks.algalogapi.domain.service;

import br.com.algaworks.algalogapi.domain.exception.NegocioException;
import br.com.algaworks.algalogapi.domain.model.Entrega;
import br.com.algaworks.algalogapi.domain.model.StatusEntrega;
import br.com.algaworks.algalogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private EntregaRepository entregaRepository;
    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public void finalizar(Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        entrega.finalizar();
        entregaRepository.save(entrega);
    }
}

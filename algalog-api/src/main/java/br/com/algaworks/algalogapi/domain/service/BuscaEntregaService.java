package br.com.algaworks.algalogapi.domain.service;

import br.com.algaworks.algalogapi.domain.exception.EntidadeNaoEncontradaException;
import br.com.algaworks.algalogapi.domain.exception.NegocioException;
import br.com.algaworks.algalogapi.domain.model.Entrega;
import br.com.algaworks.algalogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;
    public Entrega buscar(Long entregaId){
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega nao encontrada"));
    }
}

package br.com.algaworks.algalogapi.domain.service;

import br.com.algaworks.algalogapi.domain.exception.NegocioException;
import br.com.algaworks.algalogapi.domain.model.Cliente;
import br.com.algaworks.algalogapi.domain.model.Entrega;
import br.com.algaworks.algalogapi.domain.model.StatusEntrega;
import br.com.algaworks.algalogapi.domain.repository.ClienteRepository;
import br.com.algaworks.algalogapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
    private CatalogoClienteService catalogoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega){
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

        return entregaRepository.save(entrega);
    }
}

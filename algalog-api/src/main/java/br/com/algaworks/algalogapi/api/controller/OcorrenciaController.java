package br.com.algaworks.algalogapi.api.controller;

import br.com.algaworks.algalogapi.api.assembler.OcorrenciaAssembler;
import br.com.algaworks.algalogapi.api.model.input.OcorrenciaInput;
import br.com.algaworks.algalogapi.api.model.input.OcorrenciaModel;
import br.com.algaworks.algalogapi.domain.model.Entrega;
import br.com.algaworks.algalogapi.domain.model.Ocorrencia;
import br.com.algaworks.algalogapi.domain.service.BuscaEntregaService;
import br.com.algaworks.algalogapi.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaAssembler ocorrenciaAssembler;
    private BuscaEntregaService buscaEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId,
                                     @Valid @RequestBody OcorrenciaInput ocorrenciaInput){
        Ocorrencia ocorrenciaRegistrada =  registroOcorrenciaService.
                registrar(entregaId, ocorrenciaInput.getDescricao());

        return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);

    }

    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
    }

}

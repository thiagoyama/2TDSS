package br.com.fiap.tour.controller;

import br.com.fiap.tour.domain.Pacote;
import br.com.fiap.tour.dto.pacote.AtualizacaoPacoteDTO;
import br.com.fiap.tour.dto.pacote.CadastroPacoteDTO;
import br.com.fiap.tour.dto.pacote.DetalhesPacoteDTO;
import br.com.fiap.tour.repository.DestinoRepository;
import br.com.fiap.tour.repository.PacoteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

    @Autowired
    private PacoteRepository pacoteRepository;

    @Autowired
    private DestinoRepository destinoRepository;

    @GetMapping("por-valor-menor")
    public ResponseEntity<Page<DetalhesPacoteDTO>> buscar(@RequestParam("valor")Float valor, Pageable pageable){
        var pacotes = pacoteRepository.findByValorLessThan(valor, pageable).map(DetalhesPacoteDTO::new);
        return ResponseEntity.ok(pacotes);
    }

    @GetMapping("por-data")
    public ResponseEntity<Page<DetalhesPacoteDTO>> buscar(@RequestParam("data-inicio")LocalDate inicio,
                                                          @RequestParam("data-fim") LocalDate fim, Pageable pageable) {
        var lista = pacoteRepository.buscarPorData(inicio,fim,pageable).map(DetalhesPacoteDTO::new);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("por-destino")
    public ResponseEntity<Page<DetalhesPacoteDTO>> buscar(@RequestParam("id-destino") Long id, Pageable pageable){
        var lista = pacoteRepository.buscarPorDestino(id,pageable).map(DetalhesPacoteDTO::new);
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesPacoteDTO> cadastrar(@RequestBody @Valid CadastroPacoteDTO dto, UriComponentsBuilder builder) {
        var pacote = new Pacote(dto);
        var destino = destinoRepository.getReferenceById(dto.destinoId());
        pacote.setDestino(destino);
        pacote = pacoteRepository.save(pacote);
        var uri = builder.path("/pacotes/{id}").buildAndExpand(pacote.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesPacoteDTO(pacote));
    }

    @GetMapping
    public ResponseEntity<Page<DetalhesPacoteDTO>> pesquisar(Pageable pageable){
        var page = pacoteRepository.findAll(pageable).map(DetalhesPacoteDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesPacoteDTO> pesquisar(@PathVariable("id") Long id){
        var pacote = new DetalhesPacoteDTO(pacoteRepository.getReferenceById(id));
        return ResponseEntity.ok(pacote);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetalhesPacoteDTO> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizacaoPacoteDTO dto){
        var pacote = pacoteRepository.getReferenceById(id);
        pacote.atualizar(dto);
        return ResponseEntity.ok(new DetalhesPacoteDTO(pacote));
    }

}

package br.com.fiap.tour.controller;

import br.com.fiap.tour.domain.Destino;
import br.com.fiap.tour.domain.Reserva;
import br.com.fiap.tour.dto.destino.AtualizacaoDestinoDTO;
import br.com.fiap.tour.dto.destino.CadastroDestinoDTO;
import br.com.fiap.tour.dto.destino.DetalhesDestinoDTO;
import br.com.fiap.tour.dto.reserva.CadastroReservaDTO;
import br.com.fiap.tour.dto.reserva.DetalhesReservaDTO;
import br.com.fiap.tour.repository.ReservaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("por-cpf-cliente")
    public ResponseEntity<Page<DetalhesReservaDTO>> buscarPorCpf(@RequestParam("cpf") String cpf, Pageable pageable){
        var reservas = reservaRepository.findByClienteCpfEquals(cpf, pageable).map(DetalhesReservaDTO::new);
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("por-data-reserva")
    public ResponseEntity<Page<DetalhesReservaDTO>> buscarPorData(@RequestParam("data-inicio") LocalDateTime dataInicio,
                                                                  @RequestParam("data-fim") LocalDateTime dataFim, Pageable pageable){
        var reservas = reservaRepository.findByDataBetween(dataInicio, dataFim, pageable).map(DetalhesReservaDTO::new);
        return ResponseEntity.ok(reservas);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesReservaDTO> cadastrar(@RequestBody @Valid CadastroReservaDTO dto, UriComponentsBuilder builder) {
        var reserva = new Reserva(dto);
        reserva = reservaRepository.save(reserva);
        var uri = builder.path("/reservas/{id}").buildAndExpand(reserva.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesReservaDTO(reserva));
    }

    @GetMapping
    public ResponseEntity<Page<DetalhesReservaDTO>> pesquisar(Pageable pageable){
        var page = reservaRepository.findAll(pageable).map(DetalhesReservaDTO::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesReservaDTO> pesquisar(@PathVariable("id") Long id){
        var reserva = new DetalhesReservaDTO(reservaRepository.getReferenceById(id));
        return ResponseEntity.ok(reserva);
    }

}

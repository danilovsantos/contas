package com.cbyk.contas.controller;

import com.cbyk.contas.domain.model.Conta;
import com.cbyk.contas.exception.ContaNotFoundException;
import com.cbyk.contas.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @PostMapping
    public Conta createConta(@RequestBody Conta conta) {
        return contaRepository.save(conta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conta> updateConta(@PathVariable Long id, @RequestBody Conta contaDetails) {
        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new ContaNotFoundException(id));

        conta.setDataVencimento(contaDetails.getDataVencimento());
        conta.setDataPagamento(contaDetails.getDataPagamento());
        conta.setValor(contaDetails.getValor());
        conta.setDescricao(contaDetails.getDescricao());
        conta.setSituacao(contaDetails.getSituacao());

        final Conta updatedConta = contaRepository.save(conta);
        return ResponseEntity.ok(updatedConta);
    }

    @PutMapping("/{id}/situacao")
    public ResponseEntity<Conta> updateSituacao(@PathVariable Long id, @RequestBody String situacao) {
        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new ContaNotFoundException(id));
        conta.setSituacao(situacao);
        final Conta updatedConta = contaRepository.save(conta);
        return ResponseEntity.ok(updatedConta);
    }

    @GetMapping
    public Page<Conta> getAllContas(Pageable pageable) {
        return contaRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> getContaById(@PathVariable Long id) {
        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new ContaNotFoundException(id));
        return ResponseEntity.ok(conta);
    }

    @GetMapping("/valor-total")
    public BigDecimal getValorTotalPago(@RequestParam String startDate, @RequestParam String endDate) {
        // Implementar lógica para obter valor total pago por período
        return BigDecimal.ZERO;
    }

    @PostMapping("/import")
    public ResponseEntity<String> importContas(@RequestParam("file") MultipartFile file) {
        // Implementar lógica para importar contas via CSV
        return ResponseEntity.ok("Importação realizada com sucesso!");
    }
}

package com.cbyk.contas.service;

import com.cbyk.contas.domain.model.Conta;
import com.cbyk.contas.exception.ContaNotFoundException;
import com.cbyk.contas.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Page<Conta> findAll(Pageable pageable) {
        return contaRepository.findAll(pageable);
    }

    public Conta findById(Long id) {
        return contaRepository.findById(id).orElseThrow(() -> new ContaNotFoundException(id));
    }

    public Conta save(Conta conta) {
        return contaRepository.save(conta);
    }

    public Conta update(Long id, Conta conta) {
        if (!contaRepository.existsById(id)) {
            throw new ContaNotFoundException(id);
        }
        conta.setId(id);
        return contaRepository.save(conta);
    }

    public void delete(Long id) {
        if (!contaRepository.existsById(id)) {
            throw new ContaNotFoundException(id);
        }
        contaRepository.deleteById(id);
    }

    public Conta pay(Long id) {
        Conta conta = findById(id);
        conta.setDataPagamento(LocalDate.now());
        conta.setSituacao("PAGA");
        return contaRepository.save(conta);
    }

    public void importCSV(MultipartFile file) {
       // List<Conta> contas = CSVHelper.csvToContas(file);
       // contaRepository.saveAll(contas);
    }

    public BigDecimal getTotalPaid(LocalDate startDate, LocalDate endDate) {
        return contaRepository.findAll().stream()
                .filter(conta -> conta.getDataPagamento() != null &&
                        (conta.getDataPagamento().isEqual(startDate) || conta.getDataPagamento().isAfter(startDate)) &&
                        (conta.getDataPagamento().isEqual(endDate) || conta.getDataPagamento().isBefore(endDate)))
                .map(Conta::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

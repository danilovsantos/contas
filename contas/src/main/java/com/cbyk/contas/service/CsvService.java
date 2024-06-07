package com.cbyk.contas.service;

import com.cbyk.contas.domain.model.Conta;
import com.cbyk.contas.util.CSVHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CsvService {

    public List<Conta> csvToContas(MultipartFile file) {
        if (!CSVHelper.hasCSVFormat(file)) {
            throw new RuntimeException("O arquivo não está no formato CSV.");
        }

        try {
            return CSVHelper.csvToContas(file.getInputStream());
        } catch (Exception e) {
            throw new RuntimeException("Falha ao armazenar dados CSV: " + e.getMessage());
        }
    }
}


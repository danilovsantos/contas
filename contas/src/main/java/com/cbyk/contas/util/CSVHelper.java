package com.cbyk.contas.util;

import com.cbyk.contas.domain.model.Conta;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CSVHelper {

    public static String TYPE = "text/csv";

    public static boolean hasCSVFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    public static List<Conta> csvToContas(InputStream is) throws IOException {
        return null;
    }
}

package com.nastyabelova.tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PdfFileTest {

    @Test
    public void pdfDownload() throws IOException {

        File pdfDownloadedFile = new File("./src/test/resources/pdf-test.pdf");
        PDF pdfParsed = new PDF(pdfDownloadedFile);
        assertThat(pdfParsed.creator).contains("Writer");
        assertThat(pdfParsed.title).contains("PDF Form Example");
    }
}

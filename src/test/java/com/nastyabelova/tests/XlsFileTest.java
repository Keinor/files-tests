package com.nastyabelova.tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class XlsFileTest {

    @Test
    public void xlsDownload() throws FileNotFoundException {
        File xlsDownloadedFile = new File("./src/test/resources/xlsx-test.xlsx");
        XLS xls = new XLS(xlsDownloadedFile);
        String stringCellValue = xls.excel.getSheetAt(0).getRow(0).getCell(50).getStringCellValue();
        assertThat(stringCellValue).isEqualTo("11А (каб. 213)");
    }
}

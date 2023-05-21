package com.nastyabelova.tests;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class TxtFileTest {

    @Test
    public void txtDownload() throws IOException {
        File downloadTxt = new File("./src/test/resources/txt-test.txt");
        String s = FileUtils.readFileToString(downloadTxt, "UTF-8");
        Assertions.assertTrue(s.contains("\"First, solve the problem. Then, write the code.\" – John Johnson"));
    }
}

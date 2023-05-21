package com.nastyabelova.tests;

import net.lingala.zip4j.ZipFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.apache.commons.io.FileUtils.getFile;

public class ZipFileTest {
    String resourcePath = "./src/test/resources/zip/";

    @Test
    public void zipFile() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String entryAsString = null;
        try (ZipInputStream stream = new ZipInputStream(Objects.requireNonNull(classLoader.getResourceAsStream("zip/zip-file.zip")))) {
            ZipEntry entry;
            while ((entry = stream.getNextEntry()) != null) {
                entryAsString = IOUtils.toString(stream, StandardCharsets.UTF_8);
            }
        }

        Assertions.assertTrue(entryAsString.contains("I'd love to see the end results."));
    }

    @Test
    public void zipPasswordFile() throws IOException {
        ZipFile zipFile = new ZipFile(resourcePath + "pass-test.zip");

        if (zipFile.isEncrypted()) {
            char[] password = new char[]{'0', '0', '0', '0'};
            zipFile.setPassword(password);
        }

        String unzipPath = resourcePath + "unzip";
        String unzipTxtFilePath = resourcePath + "unzip/test.txt";
        String expectedData = "Yes! You win!";

        zipFile.extractAll(unzipPath);
        String actualData = FileUtils.readFileToString(getFile(unzipTxtFilePath), StandardCharsets.UTF_8);
        Assertions.assertTrue(actualData.contains(expectedData));
    }
}

package com.ks.utils;


import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

public class PDFUtils {
    final String DIR = "C:\\workspace\\doc1";
    final String OUTPUT_FILE = DIR + "\\" + "output.pdf";

    public static void main(String[] args) throws IOException {
        PDFUtils utils = new PDFUtils();
        utils.attachPdfFiles();
    }

    private void attachPdfFiles() throws IOException {
        File dir = new File(DIR);
        File output = new File(OUTPUT_FILE);
        output.delete();

        PDFMergerUtility PDFmerger = new PDFMergerUtility();
        Collection<File> files = FileUtils.listFiles(dir, new String[]{"pdf"}, false);

        files.stream().sorted((o1, o2) ->
        {
            /* For correct sequencing use this filename Format - 1_somename.pdf / 2_somename.pdf.*/
            /*Will be sorted based on prefix integer*/

            Integer int1 = Integer.valueOf(o1.getName().split("_")[0]);
            Integer int2 = Integer.valueOf(o2.getName().split("_")[0]);
            return int1.compareTo(int2);
        }).forEach(file -> {
            try {
                PDFmerger.addSource(file);

            } catch (FileNotFoundException e) {
                System.out.println("Something went wrong while adding files to PDFmerger");
            }
        });

        PDFmerger.setDestinationFileName(OUTPUT_FILE);
        PDFmerger.mergeDocuments(MemoryUsageSetting.setupTempFileOnly());
        System.out.println("Documents merged");

    }

}

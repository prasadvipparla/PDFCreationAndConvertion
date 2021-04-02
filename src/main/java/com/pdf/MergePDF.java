package com.pdf;

import java.io.File;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

/**
 * Hello world!
 *
 */
public class MergePDF {

	public static void main(String[] args) throws Exception {

		String basePath = "C:\\Prasad\\ICIC_Bank_account\\Signed\\Convert\\Merge\\";
		File folder = new File(basePath);

		// Instantiating PDFMergerUtility class
		PDFMergerUtility PDFmerger = new PDFMergerUtility();

		// Setting the destination file
		PDFmerger.setDestinationFileName(basePath + "\\merged.pdf");

		for (File file : folder.listFiles()) {
			// adding the source files
			PDFmerger.addSource(file);
		}
		// Merging the two documents
		PDFmerger.mergeDocuments();

		System.out.println("Documents merged");
	}
}

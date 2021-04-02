package com.pdf;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

public class SplitPDF {

	public static void main(String[] args) throws IOException {

		String path = "C:\\Prasad\\ICIC_Bank_account\\Split\\New folder\\";

		PDDocument document = PDDocument.load(new File(path + "split.pdf"));

		// splitting the pages of a PDF document
		List<PDDocument> pages = new Splitter().split(document);

		// Creating an iterator
		Iterator<PDDocument> iterator = pages.listIterator();

		// Saving each page as an individual document
		int i = 1;
		while (iterator.hasNext()) {
			PDDocument pd = iterator.next();
			pd.save(path + i++ + ".pdf");
			pd.close();
		}
		System.out.println("Multiple PDF’s created");
		document.close();

	}

}

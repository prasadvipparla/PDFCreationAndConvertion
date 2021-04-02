package com.pdf;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class CreatePDF {

	public static void main(String[] args) throws IOException {

		PDDocument pddoc = new PDDocument();
		for (int i = 1; i < 5; i++) {
			// Creating a blank page
			PDPage blankPage = new PDPage();

			// Adding the blank page to the document
			pddoc.addPage(blankPage);
		}

		PDPage page = pddoc.getPage(1);
		PDPageContentStream stream = new PDPageContentStream(pddoc, page);
		stream.beginText();
		stream.setFont(PDType1Font.TIMES_ROMAN, 12);
		stream.newLineAtOffset(25, 500);
		stream.showText("Hello ... ");
		stream.endText();
		stream.close();

		pddoc.save("C:\\Prasad\\2019_EXT_STAMPING\\Sandhya\\new.pdf");
		pddoc.close();
	}
}

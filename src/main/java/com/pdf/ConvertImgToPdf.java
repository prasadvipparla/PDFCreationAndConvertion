package com.pdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class ConvertImgToPdf {

	/**
	 * This will load a PDF document and add a single image on it. <br>
	 * see usage() for commandline
	 *
	 * @param args
	 *            Command line arguments.
	 */
	public static void main(String[] args) throws IOException {

		String basePath = "C:\\Prasad\\ICIC_Bank_account\\Signed\\Convert\\Convert";
		File folder = new File(basePath);

		for (File file : folder.listFiles()) {
			PDDocument document = new PDDocument();
			InputStream in = new FileInputStream(file.getAbsolutePath());
			BufferedImage bimg = ImageIO.read(in);
			float width = bimg.getWidth();
			float height = bimg.getHeight();
			PDPage page = new PDPage(new PDRectangle(width, height));
			document.addPage(page);
			PDImageXObject img = PDImageXObject.createFromFile(file.getAbsolutePath(), document);
			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			contentStream.drawImage(img, 0, 0);
			contentStream.close();
			in.close();
			document.save(file.getParent() + "\\" + file.getName().toString().split("\\.")[0] + ".pdf");
			document.close();
		}

	}

}

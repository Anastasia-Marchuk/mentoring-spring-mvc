package com.mentoring.amarchuk.web;

import com.mentoring.amarchuk.facade.BookingFacade;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



@Controller
public class PdfController {

    @Autowired
    BookingFacade bookingFacade;
    private static final Logger LOGGER = LoggerFactory.getLogger(PdfController.class);


    @GetMapping(value = "/pdfTickets", produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public FileSystemResource getFileTickets(Model model) throws IOException, DocumentException {
        LOGGER.debug("Get pdf of tickets");
        model.addAttribute("allUser", bookingFacade.getAllUsers());
        Document document = new Document();
        FileOutputStream fileOutputStream = new FileOutputStream("html.pdf");
        PdfWriter writer = PdfWriter.getInstance(document, fileOutputStream);
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream("src/main/webapp/WEB-INF/pages/list_users(tickets).html"));
        document.close();

        return new FileSystemResource("html.pdf");
    }
}


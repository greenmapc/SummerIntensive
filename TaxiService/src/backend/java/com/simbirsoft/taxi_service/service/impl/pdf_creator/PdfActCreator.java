package com.simbirsoft.taxi_service.service.impl.pdf_creator;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.util.document.PdfActParts;
import com.simbirsoft.taxi_service.util.document.PdfReceptionTransmissionActParts;
import org.springframework.beans.factory.annotation.Value;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public abstract class PdfActCreator  {

    private final int HEADER_FONT_SIZE = 18;
    private final int BASIC_FONT_SIZE = 14;
    final String COMPANY = "Компания \"Такси-Такси\"";
    final String RENTER = "Арендатор";
    final String PASSPORT = "Паспорт";

    @Value("${pdf.basic.font}")
    private String PATH_TO_COURIER_FONT;

    @Value("${pdf.store}")
    private String PATH_TO_SAVED_FILE;

    Font basicFont;
    private BaseFont baseFont;



    public String createActPdf(ActForm actForm) throws DocumentException, IOException {
        Document document = new Document();
        String fileName = UUID.randomUUID().toString();

        PdfWriter.getInstance(document, new FileOutputStream(PATH_TO_SAVED_FILE + fileName + ".pdf"));
        document.open();

        init();
        document.add(createHeaderParagraph());
        document.add(createBodyParagraph(actForm));
        document.add(createAutoInfoParagraph(actForm));
        document.add(createRentDatesParagraph(actForm));
        document.add(createAutoDocumentsInfoParagraph());
        document.add(createDocumentsList(actForm));
        document.add(createConclusionParagraph());
        document.add(createConditionsParagraph(actForm));
        document.add(createDrafterParagraph(actForm));
        document.add(createFooter(actForm));
        document.close();

        return fileName;
    }

    private void init() throws IOException, DocumentException {
        baseFont = BaseFont.createFont(PATH_TO_COURIER_FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        this.basicFont = new Font(baseFont, BASIC_FONT_SIZE);
    }

    private Paragraph createHeaderParagraph() {
            Font headerFont = new Font(baseFont, HEADER_FONT_SIZE, Font.BOLD);
            Paragraph header = new Paragraph(
                    PdfReceptionTransmissionActParts.HEADER, headerFont);

            header.setAlignment(Element.ALIGN_CENTER);
            header.setIndentationLeft(50);
            header.setIndentationRight(50);

            return header;
    }

    private Paragraph createAutoInfoParagraph(ActForm actForm) {
        Paragraph autoInfoParagraph = new Paragraph();

        List autoInfoPhrasesList = new List(List.ORDERED);
        autoInfoPhrasesList.add(new ListItem(
                new Phrase(PdfReceptionTransmissionActParts.EQUIPPED_AUTO_INFO, basicFont)));
        autoInfoPhrasesList.add(new ListItem(
                new Phrase(String.format(PdfActParts.KILOMETRAGE_AUTO_INFO, actForm.getAuto().getKilometrage()),
                        basicFont)));

        autoInfoParagraph.add(autoInfoPhrasesList);
        autoInfoParagraph.setIndentationLeft(20);

        indent(autoInfoParagraph);

        return autoInfoParagraph;
    }

    private Paragraph createAutoDocumentsInfoParagraph() {
        Paragraph paragraph = new Paragraph(
                PdfReceptionTransmissionActParts.MAIN_AUTO_DOCUMENTS_INFO, basicFont);
        indent(paragraph);

        return paragraph;
    }

    private Paragraph createDocumentsList(ActForm actForm) {
        Auto auto = actForm.getAuto();

        Paragraph documentsParagraph = new Paragraph();
        List documentsParagraphList = new List(List.ORDERED);
        String text = String.format(PdfActParts.AUTO_PASSPORT_INFO,
                auto.getVinNumber(),
                auto.getGosNumber(),
                auto.getColor(),
                auto.getTransmission(),
                auto.getVolume(),
                auto.getDrive(),
                auto.getEnginePower());

        documentsParagraphList.add(new ListItem(
                new Phrase(text, basicFont)));
        documentsParagraph.add(documentsParagraphList);

        indent(documentsParagraph);

        return documentsParagraph;
    }

    private Paragraph createConditionsParagraph(ActForm actForm) {
        String text = String.format(PdfReceptionTransmissionActParts.CONDITIONS, actForm.getConditions());
        Paragraph paragraph = new Paragraph(text, basicFont);

        indent(paragraph);

        return paragraph;
    }

    private Paragraph createDrafterParagraph(ActForm actForm) {
        String text = String.format(PdfReceptionTransmissionActParts.DRAFTER, actForm.getDrafter());

        Paragraph paragraph = new Paragraph(text, basicFont);
        indent(paragraph);

        return paragraph;
    }

    protected abstract Paragraph createFooter(ActForm actForm);

    protected abstract Paragraph createConclusionParagraph();

    protected abstract Paragraph createBodyParagraph(ActForm actForm);

    // Приема-передачи, от него унаследуется другой приема-передачи (водитель -> водитель)
    protected abstract Paragraph createRentDatesParagraph(ActForm actForm);


    void indent(Paragraph paragraph) {
        paragraph.setFirstLineIndent(30);
        paragraph.setSpacingAfter(6);
    }
}

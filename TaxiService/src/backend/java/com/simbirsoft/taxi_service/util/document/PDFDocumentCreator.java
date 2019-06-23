package com.simbirsoft.taxi_service.util.document;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.simbirsoft.taxi_service.form.CompanyToDriverActForm;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

@Component
public class PDFDocumentCreator {
    private static String PATH_TO_COURIER_FONT = "/static/font/COURIER.TTF";
    private static String PATH_TO_SAVED_FILE = "/uploads/";

    /**
     * Function create document from template and
     * fill date from act and save done pdf file
     *
     * @return created pdf filename
     */
    public static String saveDocumentFromCompanyToDriver(CompanyToDriverActForm actForm)
            throws IOException, DocumentException {
        Document document = new Document();
        String fileName = UUID.randomUUID().toString();
        PdfWriter.getInstance(document, new FileOutputStream(PATH_TO_SAVED_FILE + fileName + ".pdf"));
        document.open();
        BaseFont bf = BaseFont.createFont(PATH_TO_COURIER_FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font headerFont = new Font(bf, 18, Font.BOLD);
        Font basicFont = new Font(bf, 14);
        Font basicItalicFont = new Font(bf, 14, Font.ITALIC);
        Paragraph header = new Paragraph("Договор аренды автомобиля физическим лицом для использования в коммерческих целях", headerFont);
        header.setAlignment(Element.ALIGN_CENTER);
        header.setIndentationLeft(50);
        header.setIndentationRight(50);

        Paragraph firstParagraph = new Paragraph();
        Phrase firstParFirstPh = new Phrase("Настоящий акт составлен в двух экземплярах, " +
                "по одному для каждой стороны, при передаче автомобиля: ", basicFont);
        Phrase firstParFirstCustomData = new Phrase(
                actForm.getAuto().getBrand() + " " +
                        actForm.getAuto().getModel() + " " +
                        actForm.getAuto().getYear() + ", " +
                        actForm.getAuto().getGosNumber(),
                basicItalicFont);
        Phrase firstParSecondPh = new Phrase(", по договору аренды между: ", basicFont);
        Phrase firstParSecondCustomData = new Phrase("Ф" + " " + "И" + " " + "О" + " " + "СП" + " " + "НП"
                + " " + "ДР" + " " + "КВ" + " " + "ЛЧ", basicItalicFont);
        Phrase firstParThirdPh = new Phrase(", далее «Арендодателем», и Компанией “Такси-Такси”, далее" +
                " «Арендатором» о том, что «Арендодатель» передает, «Арендатор» принимает автомобиль: ", basicFont);
        Phrase firstParThirdCustomData = new Phrase(
                actForm.getAuto().getBrand() + " " +
                        actForm.getAuto().getModel() + " " +
                        actForm.getAuto().getYear() + ", " +
                        actForm.getAuto().getGosNumber(),
                basicItalicFont);
        Phrase firstParFourthPh = new Phrase(", в исправном состоянии и техническом состоянии и следующей " +
                "комплектации, а именно:", basicFont);
        firstParagraph.add(firstParFirstPh);
        firstParagraph.add(firstParFirstCustomData);
        firstParagraph.add(firstParSecondPh);
        firstParagraph.add(firstParSecondCustomData);
        firstParagraph.add(firstParThirdPh);
        firstParagraph.add(firstParThirdCustomData);
        firstParagraph.add(firstParFourthPh);

        Paragraph secondParagraph = new Paragraph();
        List secondParagraphList = new List(List.ORDERED);
        secondParagraphList.add(new ListItem(new Phrase("Автомобиль укомплектован", basicFont)));
        secondParagraphList.add(new ListItem(new Phrase("На момент передачи общий пробег автомобиля составляет" +
                actForm.getAuto().getKilometrage() + " км.", basicFont)));
        secondParagraph.add(secondParagraphList);

        secondParagraph.setIndentationLeft(20);

        Paragraph thirdParagraph = new Paragraph(new Phrase(
                "Аренда будет осуществлена на срок с " + actForm.getLeaseStartDate().toString() +
                        "по " + actForm.getLeaseEndDate().toString(), basicFont));

        Paragraph fourthParagraph = new Paragraph(new Phrase("При приеме-передаче вышеуказанного автомобиля " +
                "«Арендатору» переданы следующие документы:", basicFont));

        Paragraph fifthParagraph = new Paragraph();
        List fifthParagraphList = new List(List.ORDERED);
        fifthParagraphList.add(new ListItem(new Phrase("СТС автомобиля: ВИН-номер, гос-номер, цвет, кпп, (короче " +
                "вся информация об автомобиле, которая есть в СТС)", basicFont)));
        fifthParagraph.add(fifthParagraphList);

        Paragraph sixthParagraph = new Paragraph(new Phrase("«Арендатор» лично сверил номера шасси (кузова) в " +
                "подкапотном и багажном отделении, двигателя  с номерами в документах, а также проверил комплектацию ТС " +
                "«Арендодатель» предоставил «Арендатору »   в полном объеме необходимую информацию об условиях и правилах" +
                " эксплуатации вышеуказанного автомобиля и о поведении во внештатной ситуации.\n", basicFont));


        Paragraph seventhParagraph = new Paragraph("Условия аренды: Тут указанные условия аренды.\n" +
                "Составитель договора аренды: ФИО пользователя\n", basicFont);

        Paragraph eighthParagraph = new Paragraph(new Phrase("Ключи получил. \n" +
                "Исправность дополнительного оборудования проверил.\n", basicFont));


        Paragraph ninthParagraph = new Paragraph(new Phrase("Арендатор: " +
                actForm.getDriver().getLastName() + " " +
                actForm.getDriver().getFirstName() + " " +
                actForm.getDriver().getPatronymic() + ", " +
                actForm.getDriver().getBirthDate().toString(),
                basicFont));

        Paragraph tenthParagraph = new Paragraph(new Phrase("Арендодатель: Компания “Такси-Такси”", basicFont));

        java.util.List<Paragraph> paragraphs = new java.util.ArrayList<>(10);
        paragraphs.addAll(Arrays.asList(firstParagraph, secondParagraph, thirdParagraph, fourthParagraph,
                fifthParagraph, sixthParagraph, seventhParagraph, eighthParagraph, ninthParagraph, tenthParagraph));
        paragraphs.forEach(paragraph -> {
            paragraph.setFirstLineIndent(30);
            paragraph.setSpacingAfter(6);
        });

        document.add(header);
        document.add(firstParagraph);
        document.add(secondParagraph);
        document.add(thirdParagraph);
        document.add(fourthParagraph);
        document.add(fifthParagraph);
        document.add(sixthParagraph);
        document.add(seventhParagraph);
        document.add(eighthParagraph);
        document.add(ninthParagraph);
        document.add(tenthParagraph);

        document.close();
        return fileName;
    }
}

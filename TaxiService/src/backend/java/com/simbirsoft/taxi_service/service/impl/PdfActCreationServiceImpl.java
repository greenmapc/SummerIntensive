package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.service.PdfActCreatorService;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileOutputStream;
import java.util.Arrays;

@Component
@NoArgsConstructor
public class PdfActCreationServiceImpl implements PdfActCreatorService {

    @Override
    public void createPdfActFromCompanyToDriver(ActForm form) throws IOException, DocumentException {  //todo их нужно обрабатывать
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("D:/taxiFromCompanyToDriver.pdf"));
        document.open();

        BaseFont bf = BaseFont.createFont("C:\\WINDOWS\\Fonts\\ARIAL.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED); //
        Font headerFont = new Font(bf, 18, Font.BOLD);
        Font basicFont = new Font(bf, 14);
        Font basicItalicFont = new Font(bf, 14, Font.ITALIC);
        Paragraph header = new Paragraph("Договор аренды автомобиля физическим лицом для использования в коммерческих целях", headerFont);
        header.setAlignment(Element.ALIGN_CENTER);
        header.setIndentationLeft(50);
        header.setIndentationRight(50);

        Paragraph firstParagraph = new Paragraph();
        Phrase firstParFirstPh = new Phrase
                ("Настоящий акт составлен в двух экземплярах, " +
                        "по одному для каждой стороны, при передаче автомобиля: ", basicFont);
        Phrase firstParFirstCustomData = new Phrase("model" + " " + "name" + " " + "gosNumber", basicItalicFont);
        Phrase firstParSecondPh = new Phrase(", по договору аренды между: ", basicFont);
        Phrase firstParSecondCustomData = new Phrase("Ф" + " " + "И" + " " + "О" + " " + "СП" + " " + "НП"
                + " " + "ДР" + " " + "КВ" + " " + "ЛЧ", basicItalicFont);
        Phrase firstParThirdPh = new Phrase(", далее «Арендодателем», и Компанией “Такси-Такси”, далее" +
                " «Арендатором» о том, что «Арендодатель» передает, «Арендатор» принимает автомобиль: ", basicFont);
        Phrase firstParThirtCustomData = new Phrase("model" + " " + "name" + " " + "gosNumber", basicItalicFont);
        Phrase firstParFourthPh = new Phrase(", в исправном состоянии и техническом состоянии и следующей " +
                "комплектации, а именно:", basicFont);
        firstParagraph.add(firstParFirstPh);
        firstParagraph.add(firstParFirstCustomData);
        firstParagraph.add(firstParSecondPh);
        firstParagraph.add(firstParSecondCustomData);
        firstParagraph.add(firstParThirdPh);
        firstParagraph.add(firstParThirtCustomData);
        firstParagraph.add(firstParFourthPh);

        Paragraph secondParagraph = new Paragraph();
        List secondParagraphList = new List(List.ORDERED);
        secondParagraphList.add(new ListItem(new Phrase("Автомобиль укомплектован", basicFont)));
        secondParagraphList.add(new ListItem(new Phrase("На момент передачи общий пробег автомобиля составляет" +
                " 70 км.", basicFont)));
        secondParagraph.add(secondParagraphList);

        secondParagraph.setIndentationLeft(20);

        Paragraph thirdParagraph = new Paragraph(new Phrase("Аренда будет осуществлена на срок с 22.06.2019 16:40 " +
                "по 22.06.2019 22:00", basicFont));

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


        Paragraph ninethParagraph = new Paragraph(new Phrase("Арендатор: ФИО водителя", basicFont));

        Paragraph tenthParagraph = new Paragraph(new Phrase("Арендодатель: Компания “Такси-Такси”", basicFont));

        java.util.List<Paragraph> paragraphs = new java.util.ArrayList<>(10);
        paragraphs.addAll(Arrays.asList(firstParagraph, secondParagraph, thirdParagraph, fourthParagraph,
                fifthParagraph, sixthParagraph, seventhParagraph, eighthParagraph, ninethParagraph, tenthParagraph));
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
        document.add(ninethParagraph);
        document.add(tenthParagraph);

        document.close();
    }

    @Override
    public void createPdfActFromDriverToDriver(ActForm form) {

    }

    @Override
    public void createPdfActFromDriverToCompany(ActForm form) {

    }
}

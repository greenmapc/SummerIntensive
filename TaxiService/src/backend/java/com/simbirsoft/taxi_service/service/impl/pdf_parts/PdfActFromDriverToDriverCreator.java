package com.simbirsoft.taxi_service.service.impl.pdf_parts;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.form.DriverToDriverActForm;
import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.util.pdf.PdfReceptionTransmissionActParts;
import org.springframework.stereotype.Service;


@Service("driverToDriver")
public class PdfActFromDriverToDriverCreator extends PdfActFromCompanyToDriverCreator {

    @Override
    protected Paragraph createBodyParagraph(ActForm actForm) {
        DriverToDriverActForm driverToDriverActForm = (DriverToDriverActForm)actForm;

        Auto auto = driverToDriverActForm.getAuto();
        Driver renter = driverToDriverActForm.getRenter();
        Driver recipient = driverToDriverActForm.getLessor();

        Paragraph bodyParagraph = new Paragraph();
        String bodyText = String.format(PdfReceptionTransmissionActParts.MAIN_BODY,
                auto.getBrand(),
                auto.getModel(),
                auto.getYear(),
                auto.getGosNumber(),
                this.driverInfo(renter),
                this.driverInfo(recipient));

        Phrase bodyPhrase = new Phrase(bodyText, basicFont);
        bodyParagraph.add(bodyPhrase);

        return bodyParagraph;
    }

    @Override
    protected Paragraph createFooter(ActForm actForm) {
        DriverToDriverActForm driverToDriverActForm = (DriverToDriverActForm)actForm;

        Driver renter = driverToDriverActForm.getRenter();
        Driver recipient = driverToDriverActForm.getLessor();

        String text = String.format(PdfReceptionTransmissionActParts.DOCUMENT_FOOTER,
                driverName(renter),
                driverName(recipient));

        Paragraph footerParagraph = new Paragraph(text, this.basicFont);
        this.indent(footerParagraph);

        return footerParagraph;
    }

    private String driverName(Driver driver) {
        return driver.getLastName() + " " + driver.getFirstName() + " " + driver.getPatronymic();
    }
}

package com.simbirsoft.taxi_service.service.impl.pdf_parts;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.util.pdf.PdfReceptionTransmissionActParts;
import com.simbirsoft.taxi_service.util.pdf.PdfReturnActParts;
import org.springframework.stereotype.Service;

@Service("driverToCompany")
public class PdfActFromDriverToCompanyCreator extends PdfActFromCompanyToDriverCreator {

    @Override
    protected Paragraph createBodyParagraph(ActForm actForm) {
        Auto auto = actForm.getAuto();
        Driver driver = actForm.getRenter();

        Paragraph bodyParagraph = new Paragraph();
        String bodyText = String.format(PdfReturnActParts.MAIN_BODY,
                auto.getBrand(),
                auto.getModel(),
                auto.getYear(),
                auto.getGosNumber(),
                driverInfo(driver),
                PdfReceptionTransmissionActParts.COMPANY);

        Phrase bodyPhrase = new Phrase(bodyText, basicFont);
        bodyParagraph.add(bodyPhrase);

        this.indent(bodyParagraph);

        return bodyParagraph;
    }

    @Override
    protected Paragraph createRentDatesParagraph(ActForm actForm) {
        Paragraph rentDatesParagraph = new Paragraph();
        String rentDatesText = String.format(PdfReturnActParts.RENT_DATES,
                actForm.getLeaseEndDate());

        Phrase rentDatesPhrase = new Phrase(rentDatesText, basicFont);
        rentDatesParagraph.add(rentDatesPhrase);

        indent(rentDatesParagraph);

        return rentDatesParagraph;
    }

    @Override
    protected Paragraph createConclusionParagraph() {
        Paragraph conclusionParagraph = new Paragraph(PdfReturnActParts.MAIN_CONCLUSION, basicFont);
        indent(conclusionParagraph);

        return conclusionParagraph;
    }
}

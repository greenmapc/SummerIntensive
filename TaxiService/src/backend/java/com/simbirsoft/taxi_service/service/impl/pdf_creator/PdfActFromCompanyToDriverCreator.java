package com.simbirsoft.taxi_service.service.impl.pdf_creator;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.simbirsoft.taxi_service.form.ActForm;
import com.simbirsoft.taxi_service.model.Auto;
import com.simbirsoft.taxi_service.model.Driver;
import com.simbirsoft.taxi_service.util.document.PdfReceptionTransmissionActParts;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service("companyToDriver")
public class PdfActFromCompanyToDriverCreator extends PdfActCreator {

    @Override
    protected Paragraph createFooter(ActForm actForm) {
        Driver driver = actForm.getRenter();
        String text = String.format(PdfReceptionTransmissionActParts.DOCUMENT_FOOTER,
                driver.getLastName() + " " + driver.getFirstName() + " " + driver.getPatronymic(),
                this.COMPANY);

        Paragraph footerParagraph = new Paragraph(text, this.basicFont);
        this.indent(footerParagraph);

        return footerParagraph;
    }

    @Override
    protected Paragraph createConclusionParagraph() {
        Paragraph conclusionParagraph = new Paragraph(
                String.format(PdfReceptionTransmissionActParts.MAIN_CONCLUSION, this.RENTER), basicFont);
        indent(conclusionParagraph);

        return conclusionParagraph;
    }

    @Override
    protected Paragraph createBodyParagraph(ActForm actForm) {
        Auto auto = actForm.getAuto();
        Driver driver = actForm.getRenter();

        Paragraph bodyParagraph = new Paragraph();
        String bodyText = String.format(PdfReceptionTransmissionActParts.MAIN_BODY,
                auto.getBrand(),
                auto.getModel(),
                auto.getYear(),
                auto.getGosNumber(),
                driverInfo(driver),
                this.COMPANY);

        Phrase bodyPhrase = new Phrase(bodyText, basicFont);
        bodyParagraph.add(bodyPhrase);

        this.indent(bodyParagraph);

        return bodyParagraph;
    }

    @Override
    protected Paragraph createRentDatesParagraph(ActForm actForm) {
        Paragraph rentDatesParagraph = new Paragraph();
        String rentDatesText = String.format(PdfReceptionTransmissionActParts.RENT_DATES,
                actForm.getLeaseStartDate(),
                actForm.getLeaseEndDate());

        Phrase rentDatesPhrase = new Phrase(rentDatesText, basicFont);
        rentDatesParagraph.add(rentDatesPhrase);

        indent(rentDatesParagraph);

        return rentDatesParagraph;
    }

    String driverInfo(Driver driver) {
        LocalDate birthDate = driver.getBirthDate();

        return driver.getLastName() + " " + driver.getFirstName() + " " + driver.getPatronymic() + " " +
                birthDate.getDayOfMonth() + "." + birthDate.getMonthValue() + "." + birthDate.getYear() + " " +
                this.PASSPORT + " " + driver.getPassportSeries() + " " + driver.getPassportNumber() + " " +
                driver.getDateOfPassportIssue().toString() + " " + driver.getPlaceOfPassportIssue();
    }
}

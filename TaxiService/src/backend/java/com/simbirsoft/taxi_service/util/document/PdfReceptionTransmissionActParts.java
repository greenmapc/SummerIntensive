package com.simbirsoft.taxi_service.util.document;

public class PdfReceptionTransmissionActParts extends PdfActParts {
    public static final String MAIN_BODY = "Настоящий акт составлен в двух экземплярах, по одному для " +
            "каждой стороны, при передаче автомобиля: %1$s %2$s %3$s, %4$s " +
            "по договору аренды между: %5$s, " +
            "далее Арендодатель, и %6$s, далее " +
            "Арендатор, о том, что Арендодатель передает, Арендатор " +
            "принимает автомобиль: %1$s %2$s %3$d, в " +
            "исправном техническом состоянии и следующей " +
            "комплектации, а именно:";

    public static final String RENT_DATES = "Аренда будет осуществлена на срок с " +
            "%1$te.%1$tm.%1$tY %1tI:%1$tM по %2$te.%2$tm.%2$tY %2tI:%2$tM";

    public static final String MAIN_CONCLUSION = PdfActParts.MAIN_CONCLUSION +
            " Арендодатель предоставил Арендатору в полном объеме необходимую " +
            "информацию об условиях и правилах эксплуатации вышеуказанного " +
            "автомобиля и о поведении во внештатной ситуации.";

}
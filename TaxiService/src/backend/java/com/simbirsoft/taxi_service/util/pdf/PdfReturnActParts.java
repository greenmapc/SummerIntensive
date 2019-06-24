package com.simbirsoft.taxi_service.util.pdf;

public class PdfReturnActParts extends PdfActParts {
    public static final String MAIN_BODY = "Настоящий акт составлен в двух экземплярах, по одному для " +
            "каждой стороны, при передаче автомобиля: %1$s %2$s %3$s, %4$s " +
            "по договору аренды между: %5$s, " +
            "далее Арендатор, и %6$s, далее " +
            "Арендодатель, о том, что Арендодатель получает, Арендатор " +
            "передает автомобиль: %1$s %2$s %3$d, в " +
            "исправном техническом состоянии и следующей " +
            "комплектации, а именно:";

    public static final String RENT_DATES = "Автомобиль передан организации " +
            "%1$te.%1$tm.%1$tY %1tI:%1$tM";

    public static final String MAIN_CONCLUSION = String.format(PdfActParts.MAIN_CONCLUSION, PdfActParts.LESSOR);
}

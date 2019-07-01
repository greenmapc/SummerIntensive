package com.simbirsoft.taxi_service.util.pdf;

public abstract class PdfActParts {

    public static final String COMPANY = "Компания \"Такси-Такси\"";
    public static final String RENTER = "Арендатор";
    public static final String LESSOR = "Арендодатель";
    public static final String PASSPORT = "Паспорт";

    public static final String HEADER = "Договор аренды автомобиля физическим лицом для использования в коммерческих целях";

    public static final String KILOMETRAGE_AUTO_INFO = "На момент передачи общий пробег автомобиля составляет %d км.";

    public static final String EQUIPPED_AUTO_INFO = "Автомобиль укомплектован";

    public static final String MAIN_AUTO_DOCUMENTS_INFO = "При приеме-передаче вышеуказанного автомобиля " +
            "переданы следующие документы:";

    public static final String AUTO_PASSPORT_INFO = "СТС автомобиля: ВИН-номер %1$s, Госномер %2$s, цвет %3$s, " +
            "коробка передач %4$s, объем двигателя %5$.1f, привод %6$s, " +
            "мощность %7$d (л.с.).";

    public static final String CONDITIONS = "Условия аренды: %s";

    public static final String DRAFTER = "Составитель договора аренды: %s";

    public static final String DOCUMENT_FOOTER = "Ключи получил. Исправность дополнительного оборудования проверил.\n" +
            "Арендатор: %1$s\n" +
            "Арендодатель: %2$s";

    public static final String MAIN_CONCLUSION = "%s лично сверил номера шасси (кузова) в " +
                    "подкапотном и багажном отделении, двигателя с номерами в " +
                    "документах, а также проверил комплектацию ТС.";

}

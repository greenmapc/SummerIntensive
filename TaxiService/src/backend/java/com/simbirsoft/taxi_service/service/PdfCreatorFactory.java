package com.simbirsoft.taxi_service.service;

import com.simbirsoft.taxi_service.service.impl.pdf_parts.PdfActCreator;

public interface PdfCreatorFactory {
    PdfActCreator getCompanyToDriverCreator();
    PdfActCreator getDriverToDriverCreator();
    PdfActCreator getDriverToCompanyCreator();
}

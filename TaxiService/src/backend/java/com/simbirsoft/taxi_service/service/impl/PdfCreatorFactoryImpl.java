package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.service.PdfCreatorFactory;
import com.simbirsoft.taxi_service.service.impl.pdf_parts.PdfActCreator;
import com.simbirsoft.taxi_service.service.impl.pdf_parts.PdfActFromCompanyToDriverCreator;
import com.simbirsoft.taxi_service.service.impl.pdf_parts.PdfActFromDriverToCompanyCreator;
import com.simbirsoft.taxi_service.service.impl.pdf_parts.PdfActFromDriverToDriverCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PdfCreatorFactoryImpl implements PdfCreatorFactory {

    @Qualifier("companyToDriver")
    private final PdfActFromCompanyToDriverCreator companyToDriverCreator;
    @Qualifier("driverToCompany")
    private final PdfActFromDriverToCompanyCreator driverToCompanyCreator;
    @Qualifier("driverToDriver")
    private final PdfActFromDriverToDriverCreator driverToDriverCreator;

    @Override
    public PdfActCreator getCompanyToDriverCreator() {
        return companyToDriverCreator;
    }

    @Override
    public PdfActCreator getDriverToDriverCreator() {
        return driverToDriverCreator;
    }

    @Override
    public PdfActCreator getDriverToCompanyCreator() {
        return driverToCompanyCreator;
    }
}

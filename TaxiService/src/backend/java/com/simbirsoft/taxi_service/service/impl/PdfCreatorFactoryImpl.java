package com.simbirsoft.taxi_service.service.impl;

import com.simbirsoft.taxi_service.service.PdfCreatorFactory;
import com.simbirsoft.taxi_service.service.impl.pdf_parts_creator.PdfActCreator;
import com.simbirsoft.taxi_service.service.impl.pdf_parts_creator.PdfActFromCompanyToDriverCreator;
import com.simbirsoft.taxi_service.service.impl.pdf_parts_creator.PdfActFromDriverToDriverCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PdfCreatorFactoryImpl implements PdfCreatorFactory {

    @Qualifier("companyToDriver")
    private final PdfActFromCompanyToDriverCreator companyToDriverCreator;
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
        //  ToDo: return bean
        return null;
    }
}

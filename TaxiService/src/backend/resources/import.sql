-- custom's constraints for auto entity

ALTER TABLE auto ADD CONSTRAINT CHECK_LENGTH_VIN_NUMBER CHECK (length(vin_number) = 17);
ALTER TABLE auto ADD CONSTRAINT CHECK_YEAR CHECK (year <= DATE_PART('year', current_date));
ALTER TABLE auto ADD CONSTRAINT CHECK_TRANSMISSION CHECK (transmission IN ('механика', 'автомат'));
ALTER TABLE auto ADD CONSTRAINT CHECK_BODY_TYPE CHECK (body_type IN ('седан', 'хэтчбек', 'универсал', 'лифтбэк', 'купе', 'кабриолет', 'внедорожник', 'кроссовер', 'пикап'));
ALTER TABLE auto ADD CONSTRAINT CHECK_DRIVE_TYPE CHECK (drive IN ('передний', 'задний', 'полный'));
ALTER TABLE auto ADD CONSTRAINT CHECK_POSITIVE_KILOMETRAGE CHECK (kilometrage >= 0);
ALTER TABLE auto ADD CONSTRAINT CHECK_POSITIVE_POWER CHECK (engine_power >= 0);
ALTER TABLE auto ADD CONSTRAINT CHECK_POSITIVE_VOLUME CHECK (volume >= 0);


-- custom's constraints for driver entity
ALTER TABLE driver ADD CONSTRAINT CHECK_LENGTH_SERIES_LICENCE CHECK (drivers_license_series >= 1000 AND drivers_license_series <= 9999);
ALTER TABLE driver ADD CONSTRAINT CHECK_LENGTH_NUMBER_LICENSE CHECK (drivers_license_number >= 100000 AND drivers_license_series <= 999999);
ALTER TABLE driver ADD CONSTRAINT CHECK_DATE_ISSUE_LICENSE CHECK (date_of_license_issue < current_date);
ALTER TABLE driver ADD CONSTRAINT CHECK_LENGTH_SERIES_PASSPORT CHECK (passport_series >= 1000 AND passport_series <= 9999);
ALTER TABLE driver ADD CONSTRAINT CHECK_LENGTH_NUMBER_PASSPORT CHECK (passport_number >= 100000 AND passport_number <= 999999);
ALTER TABLE driver ADD CONSTRAINT CHECK_DATE_ISSUE_PASSPORT CHECK (date_of_passport_issue < current_date);




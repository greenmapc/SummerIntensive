-- custom's constraints for auto entity

ALTER TABLE auto ADD CONSTRAINT CHECK_LENGTH_VIN_NUMBER CHECK (length(vin_number) = 17);
ALTER TABLE auto ADD CONSTRAINT CHECK_YEAR CHECK (year <= DATE_PART('year', current_date));
ALTER TABLE auto ADD CONSTRAINT CHECK_TRANSMISSION CHECK (transmission IN ('механика', 'автомат'));
ALTER TABLE auto ADD CONSTRAINT CHECK_BODY_TYPE CHECK (body_type IN ('седан', 'хэтчбек', 'универсал', 'лифтбэк', 'купе', 'кабриолет', 'внедорожник', 'кроссовер', 'пикап'));
ALTER TABLE auto ADD CONSTRAINT CHECK_DRIVE_TYPE CHECK (drive IN ('передний', 'задний', 'полный'));
ALTER TABLE auto ADD CONSTRAINT CHECK_POSITIVE_KILOMETRAGE CHECK (kilometrage >= 0);
ALTER TABLE auto ADD CONSTRAINT CHECK_POSITIVE_POWER CHECK (engine_power >= 0);
ALTER TABLE auto ADD CONSTRAINT CHECK_POSITIVE_VOLUME CHECK (volume >= 0);


--


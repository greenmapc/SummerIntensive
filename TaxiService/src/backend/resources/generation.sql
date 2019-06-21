insert into users (id, email, first_name, last_name, hash_password, patronymic, phone_number)
values (1, 'matwego@mail.ru', 'Андрей', 'Петров', '$2a$08$30N7d9UIfzkpEM3JC.3DkOhy955ZCqFKAb5C.7ATxTomgL1OW4Q.K',
        'Сергеевич', '89991231230'),
       (2, 'matw@mail.ru', 'Андрей', 'Владимиров', '$2a$08$30N7d9UIfzkpEM3JC.3DkOhy955ZCqFKAb5C.7ATxTomgL1OW4Q.K',
        'Владимирович', '89991231231'),
       (3, 'qwerty@mail.ru', 'Анна', 'Кузьмина', '$2a$08$30N7d9UIfzkpEM3JC.3DkOhy955ZCqFKAb5C.7ATxTomgL1OW4Q.K',
        'Сергеевна', '89991231232'),
       (4, 'qwerty123@mail.ru', 'Алена', 'Иванова', '$2a$08$30N7d9UIfzkpEM3JC.3DkOhy955ZCqFKAb5C.7ATxTomgL1OW4Q.K',
        'Вячеславовна', '89991231233');

insert into user_role (user_id, roles)
values (1, 'OPERATOR'),
       (2, 'OPERATOR'),
       (3, 'OPERATOR'),
       (4, 'OPERATOR');

insert into auto (body_type, brand, color, description, drive, engine_power, gos_number, kilometrage, model, state,
                  transmission, vin_number, volume, year)
values ('седан', 'Mercedes', 'черный', '', 'полный', '250', 'А777РУ112', 10000, 'AMG200', true, 'автомат',
        'AFWQWRWQW12523QFK', 3, 2017),
       ('хэтчбек', 'Bentley', 'черный', '', 'полный', '450', 'А767РУ112', 20000, 'Continental', true, 'автомат',
        'AFWQWRWQW12523QEK', 3, 2016),
       ('внедорожник', 'BMW', 'черный', '', 'полный', '350', 'А757РУ112', 30000, 'X3', true, 'автомат',
        'AFWQWRWQW12523QWK', 3, 2015),
       ('универсал', 'Lada', 'черный', '', 'передний', '100', 'А477РУ112', 40000, 'Granta', true, 'механика',
        'AFWQWRWQW12523QQK', 3, 2014),
       ('лифтбэк', 'Mercedes', 'черный', '', 'полный', '250', 'А737РУ112', 50000, 'Benz', true, 'автомат',
        'AFWQWRWQW12523QPK', 3, 2013),
       ('пикап', 'Toyota', 'черный', '', 'задний', '250', 'А771РУ112', 10200, 'Camry', true, 'механика',
        'AFWQWRWQW12523QMK', 3, 2012);

insert into driver (actual_address, black_list, date_of_passport_issue, drivers_license_number, drivers_license_series,
                    first_name, last_name, passport_number, passport_series, patronymic, phone_number,
                    place_of_passport_issue, rating, residence_address, date_of_license_expiry, date_of_license_issue)
values ('ул Ямашева д.3', false, date '2010-05-10', 1234, 123456, 'Иван', 'Иванов', 432456,
        1234, 'Иванович', '79991234567', 'МВД города Самары', 0, 'ул Ямашева д.3', date '2025-06-14',
        date '2015-06-14'),
       ('ул Лянгузова д.33', false, date '2011-06-10', 1235, 123457, 'Яков', 'Широков', 412456,
        1230, 'Сергеевич', '71991234565', 'МВД города Самары', 0, 'ул Лянгузова д.33', date '2026-06-14',
        date '2016-06-14'),
       ('ул Северная д.2', false, date '2010-05-13', 1334, 133456, 'Роман', 'Владимиров', 442456,
        1244, 'Матвеевич', '79291134564', 'МВД города Самары', 0, 'ул Северная д.2', date '2027-06-14',
        date '2017-06-14'),
       ('ул Центральная д.1', false, date '2012-07-20', 1434, 143456, 'Кирилл', 'Куров', 435456,
        1235, 'Дмитриевич', '79991224561', 'МВД города Самары', 0, 'ул Центральная д.1', date '2028-06-14',
        date '2018-06-14'),
       ('ул Ленина д.12', false, date '2016-01-15', 1534, 153456, 'Сергей', 'Сергеев', 432656,
        1236, 'Николаевич', '79991234162', 'МВД города Самары', 0, 'ул Ленина д.12', date '2029-06-14',
        date '2019-06-14');
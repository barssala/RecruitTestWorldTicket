--------------------------- This script is for H2 in-memory database ---------------------------
---------------------------------- http://localhost:8080/h2/ -----------------------------------

------------- CURRENCY TABLE
CREATE TABLE "currency"
(
    id                      BIGSERIAL PRIMARY KEY,
    currency_code           VARCHAR(3)                NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE        DEFAULT now(),
    last_updated TIMESTAMP WITH TIME ZONE        DEFAULT now(),
    UNIQUE KEY currency_code (currency_code)
);

------------- CURRENCY EXCHANGE RATE TABLE
CREATE TABLE "currency_exchange_rate"
(
    id                          BIGSERIAL PRIMARY KEY,
    source_currency             BIGINT                NOT NULL,
    target_currency             BIGINT                NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE        DEFAULT now(),
    last_updated TIMESTAMP WITH TIME ZONE        DEFAULT now(),
    UNIQUE KEY source_currency_target_currency (source_currency, target_currency)
);

ALTER TABLE "currency_exchange_rate"
    ADD FOREIGN KEY (source_currency)
    REFERENCES public."currency"(id) ;

ALTER TABLE "currency_exchange_rate"
    ADD FOREIGN KEY (target_currency)
    REFERENCES public."currency"(id) ;

------------- CURRENCY EXCHANGE SELL RATE TABLE
CREATE TABLE "currency_exchange_sell_rate"
(
    id                          BIGSERIAL PRIMARY KEY,
    currency_exchange_rate      BIGINT                NOT NULL,
    from_balance                DOUBLE                NOT NULL,
    to_balance                  DOUBLE                NOT NULL,
    rate                        DOUBLE                NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE        DEFAULT now(),
    last_updated TIMESTAMP WITH TIME ZONE        DEFAULT now()
);

ALTER TABLE "currency_exchange_sell_rate"
    ADD FOREIGN KEY (currency_exchange_rate)
    REFERENCES public."currency_exchange_rate"(id) ;

------------- CURRENCY EXCHANGE BUY RATE TABLE
CREATE TABLE "currency_exchange_buy_rate"
(
    id                          BIGSERIAL PRIMARY KEY,
    currency_exchange_rate      BIGINT                NOT NULL,
    from_balance                DOUBLE                NOT NULL,
    to_balance                  DOUBLE                NOT NULL,
    rate                        DOUBLE                NOT NULL,
    date_created TIMESTAMP WITH TIME ZONE        DEFAULT now(),
    last_updated TIMESTAMP WITH TIME ZONE        DEFAULT now()
);

ALTER TABLE "currency_exchange_buy_rate"
    ADD FOREIGN KEY (currency_exchange_rate)
    REFERENCES public."currency_exchange_rate"(id) ;

------------- EXAMPLE DATA
INSERT INTO "currency" ("CURRENCY_CODE") VALUES ('AED'), ('AFN'), ('AUD');

INSERT INTO "currency_exchange_rate" ("SOURCE_CURRENCY", "TARGET_CURRENCY")
VALUES (1, 2,), (1, 3), (2, 3);

INSERT INTO "currency_exchange_buy_rate" ("CURRENCY_EXCHANGE_RATE", "FROM_BALANCE", "TO_BALANCE", "RATE")
VALUES (1, 0, 5000, 33), (1, 5001, 10000, 32), (1, 10000, 20000, 31), (1, 20000, 9999999, 30);

INSERT INTO "currency_exchange_sell_rate" ("CURRENCY_EXCHANGE_RATE", "FROM_BALANCE", "TO_BALANCE", "RATE")
VALUES (1, 0, 3000, 29), (1, 3001, 8000, 28), (1, 8000, 14000, 27), (1, 14000, 40000, 26);

INSERT INTO "currency_exchange_buy_rate" ("CURRENCY_EXCHANGE_RATE", "FROM_BALANCE", "TO_BALANCE", "RATE")
VALUES (2, 0, 1000, 15), (2, 1001, 3000, 14), (2, 3001, 9999999, 13);

INSERT INTO "currency_exchange_sell_rate" ("CURRENCY_EXCHANGE_RATE", "FROM_BALANCE", "TO_BALANCE", "RATE")
VALUES (2, 0, 800, 10), (2, 801, 2000, 9), (2, 2001, 8000, 8);

INSERT INTO "currency_exchange_buy_rate" ("CURRENCY_EXCHANGE_RATE", "FROM_BALANCE", "TO_BALANCE", "RATE")
VALUES (3, 0, 10000, 28), (3, 10001, 30000, 27), (3, 30001, 70000, 26), (3, 70001, 100000, 25), (3, 100001, 9999999, 24);

INSERT INTO "currency_exchange_sell_rate" ("CURRENCY_EXCHANGE_RATE", "FROM_BALANCE", "TO_BALANCE", "RATE")
VALUES (3, 0, 10000, 21), (3, 10001, 30000, 24), (3, 30001, 70000, 23), (3, 70001, 100000, 22), (3, 100001, 400000, 21);


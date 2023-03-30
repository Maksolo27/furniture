CREATE SCHEMA IF NOT EXISTS orders;

CREATE TABLE IF NOT EXISTS orders.order (
                                          orderId INT,
                                          customerName TEXT NOT NULL,
                                          item_name TEXT NOT NULL,
                                          item_price DOUBLE NOT NULL,
                                          quantity DOUBLE NOT NULL,
                                          PRIMARY KEY (id)
    );
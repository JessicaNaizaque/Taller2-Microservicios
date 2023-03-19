DROP TABLE IF EXISTS operations;
CREATE TABLE operations (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    operation VARCHAR(255),
    num1 INTEGER,
    num2 INTEGER,
    answer FLOAT,
    us VARCHAR(255),
    date VARCHAR(255)
);
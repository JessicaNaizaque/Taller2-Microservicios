DROP TABLE IF EXISTS mult_info;
CREATE TABLE mult_info (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    num1 INTEGER,
    num2 INTEGER,
    answer FLOAT,
    us VARCHAR(255),
    date VARCHAR(255)
);
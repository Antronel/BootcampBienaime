CREATE TABLE dealership(
dealership_ID INT AUTO_INCREMENT PRIMARY KEY,
name varchar(50),
address varchar(50),
phone varchar(12)
);

INSERT INTO dealership(name,address,phone)
values('Bring it Around Town','1234 Elm Street','707123456');
INSERT INTO dealership(name,address,phone)
values('Ava Lxury Auto','456 Harry Potter Road','123456789');
INSERT INTO dealership(name,address,phone)
values('Black Premuim Cars','789 Virgina Road','789456123');


CREATE TABLE vehicles(
VIN varchar(20) PRIMARY KEY,
MAKE varchar(20),
MODEL varchar(20),
YEAR INT,
PRICE DECIMAL(7,2),
SOLD boolean
);

INSERT INTO vehicles(VIN, MAKE, MODEL, PRICE, SOLD)
VALUES 
('1HGCM82633A004352', 'Honda', 'Accord', 8500.00, false),
('1FAFP4041WF234567', 'Ford', 'Mustang', 12000.00, true),
('2T1BR32E54C123456', 'Toyota', 'Corolla', 6700.00, false),
('3N1BC13E69L123789', 'Nissan', 'Versa', 7200.00, false),
('1J4FA49S44P765432', 'Jeep', 'Wrangler', 15000.00, true),
('5FNYF4H92FB123456', 'Honda', 'Pilot', 19000.00, false),
('1G1BE5SM5J7102345', 'Chevrolet', 'Cruze', 9100.00, false),
('JH4KA9650MC123456', 'Acura', 'Legend', 4800.00, true),
('WBA3A5C5XDF123456', 'BMW', '328i', 21500.00, true),
('SALWR2EF1FA123456', 'Land Rover', 'Range Rover', 35000.00, false);


INSERT INTO vehicles(VIN,MAKE,MODEL,PRICE,SOLD)
VALUES
('4T1BF1FK7GU123456', 'Toyota', 'Camry', 9800.00, false),
('1GNEK13ZX3R123456', 'Chevrolet', 'Tahoe', 13450.00, true),
('3FA6P0H76HR123456', 'Ford', 'Fusion', 8900.00, false),
('5NPE24AF1FH123456', 'Hyundai', 'Sonata', 7800.00, true),
('WVWAA7AJ1DW123456', 'Volkswagen', 'Jetta', 8300.00, false);

INSERT INTO vehicles(VIN,MAKE,MODEL,PRICE,SOLD)
VALUES
('1FTFW1ET1EK123456', 'Ford', 'F-150', 22000.00, true),
('WA1LAAF78JD123456', 'Audi', 'Q5', 27500.00, false),
('5UXWX9C52H0D12345', 'BMW', 'X3', 31000.00, true),
('3GCUKREC0FG123456', 'Chevrolet', 'Silverado', 24500.00, false),
('19XFC2F59GE123456', 'Honda', 'Civic', 10200.00, false),
('1HGCR2F3XFA123456', 'Honda', 'Accord', 11800.00, true),
('JHMGE8H57DC123456', 'Honda', 'Fit', 6500.00, false),
('1N6AD0EV9KN123456', 'Nissan', 'Frontier', 19900.00, true),
('JF2SJABC2EH123456', 'Subaru', 'Forester', 14200.00, false),
('YV1CZ91H641123456', 'Volvo', 'XC90', 16200.00, true);

CREATE TABLE inventory (
    dealership_id INT,
    VIN VARCHAR(20),
    FOREIGN KEY (dealership_id) REFERENCES dealership(dealership_ID),
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

-- Regular Sedans (Bring it Around Town - dealership_id 1)
INSERT INTO inventory(dealership_id, VIN) VALUES
(1, '1HGCM82633A004352'), -- Honda Accord
(1, '2T1BR32E54C123456'), -- Toyota Corolla
(1, '3N1BC13E69L123789'), -- Nissan Versa
(1, '1G1BE5SM5J7102345'), -- Chevy Cruze
(1, '4T1BF1FK7GU123456'), -- Toyota Camry
(1, '3FA6P0H76HR123456'), -- Ford Fusion
(1, '5NPE24AF1FH123456'), -- Hyundai Sonata
(1, '19XFC2F59GE123456'), -- Honda Civic
(1, 'JHMGE8H57DC123456'); -- Honda Fit

-- Luxury Vehicles (Ava Lxury Auto - dealership_id 2)
INSERT INTO inventory(dealership_id, VIN) VALUES
(2, '1FAFP4041WF234567'), -- Ford Mustang (debatable but let's assume sport)
(2, 'JH4KA9650MC123456'), -- Acura Legend
(2, 'WBA3A5C5XDF123456'), -- BMW 328i
(2, 'SALWR2EF1FA123456'), -- Land Rover Range Rover
(2, 'WA1LAAF78JD123456'), -- Audi Q5
(2, '5UXWX9C52H0D12345'), -- BMW X3
(2, '1HGCR2F3XFA123456'), -- Honda Accord (high-end trim maybe)
(2, 'YV1CZ91H641123456'); -- Volvo XC90

-- Trucks/SUVs (Black Premium Cars - dealership_id 3)
INSERT INTO inventory(dealership_id, VIN) VALUES
(3, '1J4FA49S44P765432'), -- Jeep Wrangler
(3, '5FNYF4H92FB123456'), -- Honda Pilot
(3, '1GNEK13ZX3R123456'), -- Chevy Tahoe
(3, '1FTFW1ET1EK123456'), -- Ford F-150
(3, '3GCUKREC0FG123456'), -- Chevy Silverado
(3, '1N6AD0EV9KN123456'), -- Nissan Frontier
(3, 'JF2SJABC2EH123456'); -- Subaru Forester


CREATE TABLE sales_contracts (
    contract_id INT AUTO_INCREMENT PRIMARY KEY,
    VIN VARCHAR(20),
    customer_name VARCHAR(100),
    customer_phone VARCHAR(15),
    sale_price DECIMAL(10,2),
    sale_date DATE,
    payment_method VARCHAR(20),
    FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);


INSERT INTO vehicles (VIN, make, model, year) VALUES
('21RB32852C1432456', 'Toyota', 'Camry', 2025),
('5FNYF4H92EB043299', 'Honda', 'Pilot', 2025),
('WA1LFAFP7BA112345', 'Audi', 'Q5', 2025),
('3F2SABAC2HR123456', 'Ford', 'Escape', 2024),
('YV1CZ91H641123456', 'Volvo', 'XC60', 2025);



INSERT INTO lease_contracts (VIN, customer_name, customer_phone, lease_start_date, lease_end_date, monthly_payment, annual_mileage_limit
)
VALUES
('WA1LAAF78JD123456', 'Alicia Jones', '5551237890', '2025-05-15', '2028-05-15', 280.00, 12000),
('5UXWX9C52H0D12345', 'Jordan Myers', '5552345678', '2025-06-01', '2027-06-01', 420.00, 15000),
('SALWR2EF1FA123456', 'Erica Daniels', '5553456789', '2025-06-05', '2028-06-05', 550.00, 10000),
('1J4FA49S44P765432', 'Brian Kim', '5558765432', '2025-04-10', '2028-04-10', 360.00, 12000),
('19XFC2F59GE123456', 'Tina Holloway', '5554321876', '2025-03-20', '2027-03-20', 480.00, 15000);


SELECT * FROM dealership;


SELECT v.*
FROM vehicles v
JOIN inventory i ON v.VIN = i.VIN
WHERE i.dealership_id = ?;

SELECT * FROM vehicles
WHERE VIN = '1HGCM82633A004352';


SELECT d.*
FROM dealership d
JOIN inventory i ON d.dealership_ID = i.dealership_id
WHERE i.VIN = '1HGCM82633A004352';


SELECT DISTINCT d.*
FROM dealership d
JOIN inventory i ON d.dealership_ID = i.dealership_id
JOIN vehicles v ON i.VIN = v.VIN
WHERE v.make = 'Ford' AND v.model = 'Mustang';

SELECT d.name AS dealership_name, s.*
FROM sales_contracts s
JOIN inventory i ON s.VIN = i.VIN
JOIN dealership d ON i.dealership_id = d.dealership_ID
WHERE d.dealership_ID = ?
  AND s.sale_date BETWEEN '2025-06-01' AND '2025-06-30';

-- Get all dealerships
SELECT *
FROM dealership;

-- Find all vehicles for a specific dealership (but ask Jon)
SELECT v.*
FROM vehicles v
JOIN inventory i ON v.VIN = i.VIN
WHERE i.dealership_id = 1;


-- Find a car by VIN
SELECT *
FROM vehicles
WHERE VIN = '1HGCM82633A004352';

-- Find the dealership where a certain car is located, by VIN
SELECT d.*
FROM dealership d
JOIN inventory i ON d.dealership_ID = i.dealership_id
WHERE i.VIN = '1HGCM82633A004352';


-- Find all dealerships that have a specific car type (e.g., Red Ford Mustang)
-- Assuming we are only matching MAKE and MODEL
SELECT DISTINCT d.*
FROM dealership d
JOIN inventory i ON d.dealership_ID = i.dealership_id
JOIN vehicles v ON v.VIN = i.VIN
WHERE v.MAKE = 'Ford' AND v.MODEL = 'Mustang';

-- Get all sales information for a specific dealer within a specific date range
-- Assumes a `sales_contracts` table with dealership_id and sale_date fields
SELECT s.*
FROM sales_contracts s
JOIN inventory i ON s.VIN = i.VIN
WHERE i.dealership_id = 1
  AND s.sale_date BETWEEN '2025-01-01' AND '2025-12-31';

-- Find the most expensive unsold vehicle per dealership
SELECT d.name AS dealership_name, MAX(v.PRICE) AS max_unsold_price
FROM dealership d
JOIN inventory i ON d.dealership_ID = i.dealership_id
JOIN vehicles v ON v.VIN = i.VIN
WHERE v.SOLD = FALSE
GROUP BY d.name;
PRIMARYdealership
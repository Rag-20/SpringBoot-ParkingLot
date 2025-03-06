CREATE TABLE floor (
    id SERIAL PRIMARY KEY,
    FOREIGN KEY lot_id REFERENCES parking_lot(id)
);
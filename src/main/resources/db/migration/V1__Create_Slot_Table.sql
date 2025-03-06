CREATE TABLE slot (
    id SERIAL PRIMARY KEY,
    status BOOLEAN NOT NULL,
    FOREIGN KEY floor_id REFERENCES floor(id),
    FOREIGN KEY vehicle_id REFERENCES vehicle(id)
);

CREATE TABLE ticket (
    id SERIAL PRIMARY KEY,
    entry_time CURRENT_TIMESTAMP,
    exit_time TIMESTAMP,
    FOREIGN KEY vehicle_id REFERENCES vehicle(id)
    FOREIGN KEY slot_id REFERENCES slot(id)
);
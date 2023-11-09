CREATE TABLE item_bucket (
    id SERIAL PRIMARY KEY,
    item_category VARCHAR(255),
    item_name VARCHAR(255),
    description VARCHAR(1024),
    media_url VARCHAR(255),
    auction_slot VARCHAR(255),
    base_price INT,
    condition VARCHAR(255),
    buying_year VARCHAR(255)
);
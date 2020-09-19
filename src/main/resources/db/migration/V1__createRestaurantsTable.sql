CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS Restaurants (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    slug varchar,
    name varchar
);
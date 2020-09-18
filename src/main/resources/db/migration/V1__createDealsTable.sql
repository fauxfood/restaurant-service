CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS deals (
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    description varchar,
    promo_code varchar
);
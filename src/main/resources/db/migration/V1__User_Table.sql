CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users (
    user_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    phone VARCHAR(30) UNIQUE,
    email VARCHAR(255) UNIQUE,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE', -- ACTIVE | BLOCKED | DELETED
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE INDEX idx_users_phone ON users(phone);


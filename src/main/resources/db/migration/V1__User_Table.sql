        CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

        CREATE TYPE user_status AS ENUM ('ACTIVE','BLOCKED','DELETED');
        CREATE TYPE user_type AS ENUM ('CUSTOMER','ADMIN','VENDOR');

        CREATE TABLE users (
        user_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
        phone VARCHAR(30) UNIQUE,
        email VARCHAR(255) UNIQUE,
        status user_status NOT NULL DEFAULT 'ACTIVE',
        user_type user_type NOT NULL DEFAULT 'CUSTOMER',
        created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
        );

        CREATE TABLE user_profiles (
        profile_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
        user_id UUID UNIQUE NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
        first_name VARCHAR(100) NOT NULL,
        last_name VARCHAR(100),
        date_of_birth DATE,
        created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
        );

        CREATE TABLE addresses (
        address_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
        user_id UUID NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
        street VARCHAR(255),
        city VARCHAR(100),
        state VARCHAR(100),
        zip_code VARCHAR(20),
        country VARCHAR(100),
        is_default BOOLEAN DEFAULT FALSE,
        created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
        );

        CREATE INDEX idx_users_phone ON users(phone);
        CREATE INDEX idx_addresses_user ON addresses(user_id);

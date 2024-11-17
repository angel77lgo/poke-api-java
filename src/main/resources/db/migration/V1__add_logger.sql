CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS "request_logger" (
    "id" UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    "ip_origin" VARCHAR(255) NOT NULL,
    "request_time" TIMESTAMP NOT NULL,
    "method" VARCHAR(255) NOT NULL,
    "request_payload" TEXT NULL,
    "response_payload" TEXT NULL,
    "created_at" TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    "updated_at" TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    "deleted_at" TIMESTAMP NULL
);
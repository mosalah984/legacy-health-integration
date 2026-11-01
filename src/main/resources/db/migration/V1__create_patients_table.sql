CREATE TABLE patients
(
    id            UUID PRIMARY KEY,
    national_id   VARCHAR(30)              NOT NULL UNIQUE,
    first_name    VARCHAR(100)             NOT NULL,
    last_name     VARCHAR(100)             NOT NULL,
    date_of_birth DATE                     NOT NULL,
    blood_type    VARCHAR(20),
    created_at    TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at    TIMESTAMP WITH TIME ZONE NOT NULL
);
CREATE TABLE audit_logs (
    id SERIAL NOT NULL,
    "timestamp" TIMESTAMP NOT NULL DEFAULT NOW(),
    server_host_name VARCHAR(75) NOT NULL,
    server_host_address VARCHAR(75) NOT NULL,
    application_name VARCHAR(25) NOT NULL,
    remote_address VARCHAR(75) NOT NULL,
    request_method TEXT NOT NULL,
    request_uri TEXT NOT NULL,
    response_status INTEGER NOT NULL,
    request_body TEXT,
    response_body TEXT
);

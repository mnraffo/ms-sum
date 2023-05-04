CREATE TABLE audit_logs (
    id SERIAL NOT NULL,
    "timestamp" TIMESTAMP NOT NULL DEFAULT NOW(),
    request_method TEXT NOT NULL,
    request_uri TEXT NOT NULL,
    response_status INTEGER NOT NULL,
    request_body TEXT,
    response_body TEXT
);

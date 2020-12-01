CREATE TABLE user_info (
            id UUID NOT NULL,
            first_name TEXT NOT NULL,
            last_name TEXT NOT NULL,
            email TEXT NOT NULL,
            street TEXT NOT NULL,
            city TEXT NOT NULL,
            country TEXT NOT NULL,
            zip_code TEXT,
            PRIMARY KEY (id)
        );
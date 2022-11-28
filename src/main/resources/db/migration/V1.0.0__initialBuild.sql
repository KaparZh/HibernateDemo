CREATE TABLE IF NOT EXISTS label
(
    id   int          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS post
(
    id      int       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    content text      NOT NULL,
    created timestamp NOT NULL,
    updated timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS post_label
(
    post_id  int NOT NULL,
    label_id int NOT NULL,
    FOREIGN KEY (post_id) REFERENCES post (id) ON DELETE CASCADE,
    FOREIGN KEY (label_id) REFERENCES label (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS writer
(
    id         int          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name varchar(128) NOT NULL,
    last_name  varchar(128) NOT NULL
);

CREATE TABLE IF NOT EXISTS writer_post
(
    writer_id int NOT NULL,
    post_id   int NOT NULL,
    FOREIGN KEY (writer_id) REFERENCES writer (id) ON DELETE CASCADE,
    FOREIGN KEY (post_id) REFERENCES post (id) ON DELETE CASCADE
);


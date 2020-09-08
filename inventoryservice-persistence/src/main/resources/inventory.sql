CREATE TABLE IF NOT EXISTS `ITEMS`(

    `title`       VARCHAR PRIMARY KEY,
    `price`       DOUBLE NOT NULL,
    `image`      BLOB NOT NULL,
    `quantity`    INTEGER NOT NULL,
    `description` VARCHAR NOT NULL
);



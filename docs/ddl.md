## Data Definition Language (DDL) for data model

```sql 
CREATE TABLE IF NOT EXISTS `SkiResort`
(
    `ski_resort_id`      INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `user_id`            INTEGER                           NOT NULL,
    `ski_resort_name`    TEXT,
    `favorite`           INTEGER                           NOT NULL,
    `seven_day_forecast` TEXT,
    `temp`               REAL                              NOT NULL,
    `wind_dir`           INTEGER                           NOT NULL,
    `wind_spd`           INTEGER                           NOT NULL,
    `cloud_cover`        INTEGER                           NOT NULL,
    `vis`                INTEGER                           NOT NULL,
    `rel_humid`          INTEGER                           NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE
)

CREATE INDEX `index_SkiResort_user_id` ON `SkiResort` (`user_id`);

CREATE INDEX `index_SkiResort_ski_resort_name` ON `SkiResort` (`ski_resort_name`);

CREATE INDEX `index_SkiResort_seven_day_forecast` ON `SkiResort` (`seven_day_forecast`);

CREATE INDEX `index_SkiResort_temp` ON `SkiResort` (`temp`);

CREATE INDEX `index_SkiResort_wind_dir` ON `SkiResort` (`wind_dir`);

CREATE INDEX `index_SkiResort_wind_spd` ON `SkiResort` (`wind_spd`);

CREATE INDEX `index_SkiResort_cloud_cover` ON `SkiResort` (`cloud_cover`);

CREATE INDEX `index_SkiResort_vis` ON `SkiResort` (`vis`);

CREATE INDEX `index_SkiResort_rel_humid` ON `SkiResort` (`rel_humid`);

CREATE TABLE IF NOT EXISTS `User`
(
    `user_id`     INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `username`    TEXT,
    `ski_resort`  INTEGER                           NOT NULL,
    `postal_code` INTEGER                           NOT NULL
);

CREATE INDEX `index_User_username` ON `User` (`username`);

CREATE INDEX `index_User_ski_resort` ON `User` (`ski_resort`);

CREATE INDEX `index_User_postal_code` ON `User` (`postal_code`);
```

[`ddl.sql`](ddl.sql)
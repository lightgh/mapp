CREATE TABLE IF NOT EXISTS playlist
(
    id BIGINT auto_increment PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    created_on DATE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS song
(
    id BIGINT auto_increment PRIMARY KEY,
    playlist_id BIGINT NOT NULL,
    name VARCHAR(250) NOT NULL,
    cover_url VARCHAR(250) NOT NULL,
    created_on DATE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(playlist_id) REFERENCES playlist(id) ON UPDATE CASCADE
);

insert into playlist(id, name, created_on) values(1, 'guitar', CURRENT_TIMESTAMP );
insert into song(id, name, playlist_id, cover_url, created_on) values(2, 'guitar song', 1, 'https://www.dumies.com/wp-content/uploads/open-guitar-chords-chart.jpg', CURRENT_TIMESTAMP );
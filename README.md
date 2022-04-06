# NoiseWater
NoiseWater is a tool to create playlists from songs. It allows users to create accounts, search for music by track name or artist name, preview the songs, view the album covers and see the artist name. Songs can be added to playlists that display all relevant information available when logging on. Songs can also be removed from playlists and User accounts can be removed.

## Technologies Used
1. Spring Boot
2. Spring Data JPA
3. Spring Web
4. Lombok
5. Spring Boot DevTools
6. Postgres Drivers Included

## Usage Notes
The backend will persist User and Song information to the Database. A joins table will be used to associate songs with Users

### Models
#### User
Attributes include a generated pk as 'id', 'username', 'password', 'songs' (set).
#### Songs
Attributes include a generated pk as 'id', 'songId', 'artistName', 'songName'.
### Web Layer
All endpoints are directed at '/user'.

Posts can be made to:
1. '/register' sending new user information for registration
2. '/addsong' sending user information with a song to add it to a playlist
3. '/find' send username and password to validate and retrieve user information
4. '/deletesong' send song information with user to delete sone
5. '/removeuser' send user information to delete playlist and user

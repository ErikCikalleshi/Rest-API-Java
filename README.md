# Rest-API-Java
Cinema Example  

## API-Functions
1. /movies shows all movies
1. /rooms shows all rooms
1. /movies/{name} shows all details about the movie
1. /rooms/{name} shows all details about the room
1. /create adds a new movie

## Curl-Commands
Create a movie
```
  curl -i -H "Content-Type: application/json" -X POST -d '{"name": "Avatar"}' localhost:8080/create
```
Show movies
```
  curl -i -H "Content-Type: application/json" -X GET localhost:8080/movies
```
Show details about a movie
```
  curl -i -H "Content-Type: application/json" -X GET localhost:8080/movies/Avatar
```
## Credits
Tutorial form [Brian Fraser](https://www.youtube.com/watch?v=rXBsnNCH59o&t=1247s&ab_channel=BrianFraser) on YouTube.

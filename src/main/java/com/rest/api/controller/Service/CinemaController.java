package com.rest.api.controller.Service;

import com.rest.api.model.Cinema;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CinemaController {
    //List for all Movies and Rooms
    private final List<Cinema> cinemas = new ArrayList<>();
    private final AtomicLong nextId = new AtomicLong();
    JSONObject main = new JSONObject();
    JSONObject temp = new JSONObject();

    //create a Movie
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema createNewRoom(@RequestBody Cinema cinema){
        cinema.setId(nextId.incrementAndGet());
        cinemas.add(cinema);
        return cinema;
    }

    //list all Movies
    @GetMapping(path = "/movies", consumes = "application/json", produces = "application/json")
    public JSONObject getAllMovies(){
        ArrayList<String> s = new ArrayList<>();
        for (Cinema cinema : cinemas) {
            s.add(cinema.getName());
        }
        main.clear();
        main.put("movies", s.toArray());
        return main;
    }

    //list all rooms
    @GetMapping(path = "/rooms", consumes = "application/json", produces = "application/json")
    public JSONObject getAllRooms(){
        ArrayList<String> s = new ArrayList<>();
        for (Cinema cinema : cinemas) {
            s.add(String.valueOf(cinema.getRoom()));
        }
        main.clear();
        main.put("rooms", s.toArray());
        return main;
    }
    //list Details of a specific movie
    @GetMapping(path = "/movies/{name}", consumes = "application/json", produces = "application/json")
    public JSONObject getDetailsMovie(@PathVariable("name") String name){
        for (Cinema m: cinemas) {
            if(m.getName().equals(name)){
                main.clear();
                main.put("movie", getMovieDetails(m));
                return main;
            }
        }
        throw new IllegalArgumentException();
    }
    //list Details of a specific room
    @GetMapping(path = "/rooms/{room}", consumes = "application/json", produces = "application/json")
    public JSONObject getDetailsRoom(@PathVariable("room") int room){
        for (Cinema m: cinemas) {
            if(m.getRoom() == room){
                main.clear();
                System.out.println("Test");
                main.put("room", getRoomDetails(m));
                return main;
            }
        }
        throw new IllegalArgumentException();
    }

    public JSONObject getMovieDetails(Cinema m){
        temp.put("name", m.getName());
        temp.put("room", m.getRoom());
        temp.put("id", m.getId());
        temp.put("duration", m.getDuration());
        return temp;
    }

    public JSONObject getRoomDetails(Cinema m) {
        temp.put("id", m.getId());
        temp.put("places", m.getPlaces());
        temp.put("exits", m.getExit());
        temp.put("screensize", m.getScreensize());
        return temp;

    }
}

package com.couchbase.learn.controller;

import com.couchbase.learn.model.Sport;
import com.couchbase.learn.model.User;
import com.couchbase.learn.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public record UserController(UsersService usersService) {

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return usersService.saveUser(user)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        return usersService.getUser(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email) {
        return usersService.getUserByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}/sport")
    public ResponseEntity<User> addSportToUser(@PathVariable Integer id, @RequestBody Sport sport) {
        return usersService.addSport(id, sport)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }


    @GetMapping("/sport/{sportName}")
    public ResponseEntity<List<User>> findBySportName(@PathVariable String sportName) {
        return usersService.getBySportname(sportName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
}

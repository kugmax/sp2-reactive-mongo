package com.kugmax.learn.sp2.reactivemongo.controller;

import com.kugmax.learn.sp2.reactivemongo.dao.GameDao;
import com.kugmax.learn.sp2.reactivemongo.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class GameController {

    private GameDao gameDao;

    @Autowired
    public GameController(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    public Mono<Game> getGame(@PathVariable("id") long id ) {
        return gameDao.get(id);
    }

    @RequestMapping(value = "/game/", method = RequestMethod.PUT)
    public Mono<Void> save(@RequestBody Game game) {
        return gameDao.put(game);
    }
}

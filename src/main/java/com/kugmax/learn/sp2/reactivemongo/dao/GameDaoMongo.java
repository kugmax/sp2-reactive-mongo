package com.kugmax.learn.sp2.reactivemongo.dao;

import com.kugmax.learn.sp2.reactivemongo.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class GameDaoMongo implements GameDao {
    private ReactiveMongoTemplate mongoOperations;

    @Autowired
    public GameDaoMongo(ReactiveMongoTemplate mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public Mono<Void> put(Game game) {
        return mongoOperations.insert(game).then();
    }

    @Override
    public Mono<Game> get(long id) {
        return mongoOperations.findById(id, Game.class);
    }
}

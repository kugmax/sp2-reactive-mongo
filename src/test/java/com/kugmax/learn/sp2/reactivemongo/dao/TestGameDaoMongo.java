package com.kugmax.learn.sp2.reactivemongo.dao;

import com.kugmax.learn.sp2.reactivemongo.MongoDbConfig;
import com.kugmax.learn.sp2.reactivemongo.model.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MongoDbConfig.class, loader = AnnotationConfigContextLoader.class)
public class TestGameDaoMongo {

    @Autowired
    public GameDao gameDao;

    @Test
    public void pug_get() throws Exception {
        Game game = new Game(1, "Nice", "Game");
        gameDao.put(game).block();

        assertEquals(game, gameDao.get(1).block());
    }
}

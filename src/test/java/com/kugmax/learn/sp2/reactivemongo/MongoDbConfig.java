package com.kugmax.learn.sp2.reactivemongo;

import de.flapdoodle.embed.mongo.config.*;
import de.flapdoodle.embed.mongo.distribution.Version;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.kugmax.learn.sp2.reactivemongo.dao"})
@EnableAutoConfiguration
@AutoConfigureDataMongo
public class MongoDbConfig {
    @Bean
    public IMongodConfig mongoProperties() throws Exception {
        return new MongodConfigBuilder()
                .version(Version.V3_3_1)
                .net(new Net(27017, false))
                .build();
    }
}

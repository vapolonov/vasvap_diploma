package ru.apolonov.config.huddleteam;

import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/huddleteam/huddle.properties"
})

public interface HuddleAppConfig extends Config {

    String webUrl();
    String apiUrl();
    String userLogin();
    String userPassword();

}


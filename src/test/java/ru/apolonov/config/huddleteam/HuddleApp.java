package ru.apolonov.config.huddleteam;

import org.aeonbits.owner.ConfigFactory;

public class HuddleApp {
    public static ru.apolonov.config.huddleteam.HuddleAppConfig config = ConfigFactory.create(HuddleAppConfig.class, System.getProperties());
}

package io.demo.realworld.helper;

import io.demo.realworld.config.AppConfig;
import io.demo.realworld.config.LaunchConfig;
import org.aeonbits.owner.ConfigFactory;

public final class ConfigHelper {

    public static final AppConfig APP_CONFIG = ConfigFactory.create(AppConfig.class, System.getProperties());
    public static final LaunchConfig LAUNCH_CONFIG = ConfigFactory.create(LaunchConfig.class, System.getProperties());

    private ConfigHelper() {
    }
}

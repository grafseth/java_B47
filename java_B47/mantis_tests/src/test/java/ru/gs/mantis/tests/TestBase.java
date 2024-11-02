package ru.gs.mantis.tests;

import org.junit.jupiter.api.BeforeEach;
import ru.gs.mantis.manager.ApplicationManager;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Random;

public class TestBase {
    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() throws IOException {
        if (app == null) {
            var properties = new Properties();
            properties.load(new FileReader(System.getProperty("target", "local.properties")));
            app = new ApplicationManager();
            app.init(System.getProperty("Browser", "chrome"), properties);
        }
    }
}

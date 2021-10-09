package net.volodin.steps;

import io.cucumber.java.Scenario;
import net.volodin.testbase.BaseClass;
import net.volodin.utils.CommonMethods;
import net.volodin.utils.ConfigsReader;
import org.junit.After;
import org.junit.Before;

public class Hooks {
    @Before
    public void start() {
        BaseClass.setUp();
    }

    @After
    public void end(Scenario scenario) {
        byte[] picture;
        if (scenario.isFailed()) {
            picture = CommonMethods.takeScreenshot("failed/" + scenario.getName());
        } else {
            picture = CommonMethods.takeScreenshot("passed/" + scenario.getName());
        }
        scenario.attach(
                picture,
                "image/" + ConfigsReader.getProperty("screenshotFormat"),
                scenario.getName());
        BaseClass.tearDown();
    }
}
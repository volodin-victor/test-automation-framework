package net.volodin.testbase;

import net.volodin.utils.CommonMethods;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

abstract class AbstractBrowserInit {
    public static WebDriver getDriver() {
        return null;
    }

    public static Dimension getSize() {
        return new Dimension(CommonMethods.scrWidth(), CommonMethods.scrHeight());
    }

    public static Point getPosition() {
        return new Point(0, 0);
    }

}

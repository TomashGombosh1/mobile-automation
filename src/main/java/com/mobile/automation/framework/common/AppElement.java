package com.mobile.automation.framework.common;

import java.util.function.Consumer;

import com.mobile.automation.framework.config.drivers.DeviceOs;
import com.mobile.automation.framework.exception.NoSuchOsException;
import io.appium.java_client.MobileBy;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.By;

import static java.util.Objects.requireNonNull;

/**
 * @author Tomash Gombosh
 */
@Data
@AllArgsConstructor
public class AppElement {
    private String name;
    private By androidLoc;
    private By iosLoc;
    private ScrollTo scrollTo;
    private boolean required;

    public AppElement(final String name, final MobileBy androidLoc, final MobileBy iosLoc, final ScrollTo scrollTo, final boolean required) {
        this.name = name;
        this.androidLoc = androidLoc;
        this.iosLoc = iosLoc;
        this.scrollTo = scrollTo;
        this.required = required;
    }

    public AppElement(final Consumer<AppElement> builder) {
        requireNonNull(builder).accept(this);
    }

    public AppElement(final String name, final By androidLoc, final By iosLoc, final boolean required) {
        this(name, androidLoc, iosLoc, ScrollTo.NO, required);
    }

    public AppElement(final String name, final MobileBy androidLoc, final MobileBy iosLoc, final boolean required) {
        this(name, androidLoc, iosLoc, ScrollTo.NO, required);
    }

    public AppElement(final String name, final By androidLoc, final By iosLoc, final ScrollTo scrollTo) {
        this(name, androidLoc, iosLoc, scrollTo, false);
    }

    public AppElement(final String name, final MobileBy androidLoc, final MobileBy iosLoc, final ScrollTo scrollTo) {
        this(name, androidLoc, iosLoc, scrollTo, false);
    }

    public AppElement(final String name, final By androidLoc, final By iosLoc) {
        this(name, androidLoc, iosLoc, ScrollTo.NO);
    }

    public AppElement(final String name, final MobileBy androidLoc, final MobileBy iosLoc) {
        this(name, androidLoc, iosLoc, ScrollTo.NO);
    }

    /**
     * Gets the appropriate locator.
     *
     * @param deviceType the type of device, ANDROID or IOS.
     * @return the appropriate By locator of this element.
     */
    public By get(final DeviceOs deviceType) {
        By loc;
        if (deviceType.equals(DeviceOs.ANDROID)) {
            loc = this.androidLoc;
        } else if (deviceType.equals(DeviceOs.IOS)) {
            loc = this.iosLoc;
        } else {
            throw new NoSuchOsException("OS of the device should be Android or iOS, you use another one");
        }
        return loc;
    }
}

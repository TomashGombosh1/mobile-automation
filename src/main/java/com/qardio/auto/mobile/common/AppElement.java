package com.qardio.auto.mobile.common;

import java.util.function.Consumer;

import com.qardio.auto.mobile.exception.NoSuchOsException;
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
    private By androidLocator;
    private By iosLocator;
    private ScrollTo scrollTo;
    private boolean required;

    public AppElement(final Consumer<AppElement> builder) {
        requireNonNull(builder).accept(this);
    }

    /**
     * App element only for the android
     *
     * @param name           element name
     * @param androidLocator element android locator
     * @param scrollTo       scroll to element
     * @param required       is element required
     */
    public AppElement(final String name, final By androidLocator, final ScrollTo scrollTo, final boolean required) {
        this(name, androidLocator, null, scrollTo, required);
    }

    public AppElement(final String name, final By androidLocator, final By iosLocator, final boolean required) {
        this(name, androidLocator, iosLocator, ScrollTo.NO, required);
    }

    public AppElement(final String name, final MobileBy androidLocator, final MobileBy iosLocator, final boolean required) {
        this(name, androidLocator, iosLocator, ScrollTo.NO, required);
    }

    public AppElement(final String name, final By androidLocator, final By iosLocator, final ScrollTo scrollTo) {
        this(name, androidLocator, iosLocator, scrollTo, false);
    }

    public AppElement(final String name, final MobileBy androidLocator, final MobileBy iosLocator, final ScrollTo scrollTo) {
        this(name, androidLocator, iosLocator, scrollTo, false);
    }

    public AppElement(final String name, final By androidLocator, final By iosLocator) {
        this(name, androidLocator, iosLocator, ScrollTo.NO);
    }

    public AppElement(final String name, final MobileBy androidLocator, final MobileBy iosLocator) {
        this(name, androidLocator, iosLocator, ScrollTo.NO);
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
            loc = this.androidLocator;
        } else if (deviceType.equals(DeviceOs.IOS)) {
            loc = this.iosLocator;
        } else {
            throw new NoSuchOsException("OS of the device should be Android or iOS, you use another one");
        }
        return loc;
    }
}

package com.qardio.auto.mobile.service;

import javax.inject.Inject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

/**
 * @author Tomash Gombosh
 */
public class Swipe implements SwipeService {

    private final AppiumDriver<MobileElement> driver;
    private final Dimension winSize;
    private final TouchAction touch;

    @Inject
    public Swipe(final AppiumDriver<MobileElement> driver, final Dimension winSize, final TouchAction touchAction) {
        this.driver = driver;
        this.winSize = winSize;
        this.touch = touchAction;
    }

    @Override
    public void swipeLeftToRight() {
        this.swipeHorizontallyByPercent(10, 90);
    }

    @Override
    public void swipeRightToLeft() {
        this.swipeHorizontallyByPercent(90, 10);

    }

    @Override
    public void swipeVerticallyByPercent(final int startPercent, final int endPercent) {
        final int startY = (winSize.height * startPercent) / 100;
        final int endY = (winSize.height * endPercent) / 100;
        final int stepX = (winSize.width * 20) / 100;

        final Point startPoint = new Point(stepX, startY);
        final Point endPoint = new Point(stepX, endY);
        this.swipe(startPoint, endPoint);
    }

    @Override
    public void swipeVerticallyByInt(final int startPercent, final int endPercent) {
        final int startY = winSize.height * startPercent;
        final int endY = winSize.height * endPercent;
        final int stepX = winSize.width * 20;

        final Point startPoint = new Point(stepX, startY);
        final Point endPoint = new Point(stepX, endY);
        this.swipe(startPoint, endPoint);
    }

    @Override
    public void swipeHorizontallyByPercent(final int startPercent, final int endPercent) {
        final int startX = (winSize.width * startPercent) / 100;
        final int endX = (winSize.width * endPercent) / 100;
        final int stepY = (winSize.height * 50) / 100;

        final Point startPoint = new Point(startX, stepY);
        final Point endPoint = new Point(endX, stepY);
        this.swipe(startPoint, endPoint);
    }

    @Override
    public void swipeByPercent(final int startXPercent, final int endXPercent, final int startYPercent, final int endYPercent) {
        final int startX = (winSize.width * startXPercent) / 100;
        final int endX = (winSize.width * endXPercent) / 100;
        final int startY = (winSize.height * startYPercent) / 100;
        final int endY = (winSize.height * endYPercent) / 100;

        final Point startPoint = new Point(startX, startY);
        final Point endPoint = new Point(endX, endY);
        this.swipe(startPoint, endPoint);
    }

    @Override
    public void swipeByInt(final int startXPercent, final int endXPercent, final int startYPercent, final int endYPercent) {
        final int startX = winSize.width * startXPercent;
        final int endX = winSize.width * endXPercent;
        final int startY = winSize.height * startYPercent;
        final int endY = winSize.height * endYPercent;

        final Point startPoint = new Point(startX, startY);
        final Point endPoint = new Point(endX, endY);
        this.swipe(startPoint, endPoint);
    }

    @Override
    public void swipe(final Point start, final Point end) {
        touch.press(PointOption.point(start.getX(), start.getY())).moveTo(PointOption.point(end.getX(), end.getY())).release();
        this.driver.performTouchAction(touch);
    }
}

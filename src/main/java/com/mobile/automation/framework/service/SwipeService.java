package com.mobile.automation.framework.service;

import org.openqa.selenium.Point;

/**
 * @author Tomash Gombosh
 */
public interface SwipeService {

    void swipeLeftToRight();

    void swipeRightToLeft();

    void swipeVerticallyByPercent(int startPercent, int endPercent);

    void swipeVerticallyByInt(int startPercent, int endPercent);

    void swipeHorizontallyByPercent(int startPercent, int endPercent);

    void swipeByPercent(int startXPercent, int endXPercent, int startYPercent, int endYPercent);

    void swipeByInt(int startXPercent, int endXPercent, int startYPercent, int endYPercent);

    void swipe(Point start, Point end);
}

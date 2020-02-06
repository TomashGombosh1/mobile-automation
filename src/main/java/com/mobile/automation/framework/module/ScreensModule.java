package com.mobile.automation.framework.module;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.mobile.automation.framework.screens.DashboardScreeen;
import com.mobile.automation.framework.screens.LoginScreen;

public class ScreensModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DashboardScreeen.class).in(Scopes.SINGLETON);
        bind(LoginScreen.class).in(Scopes.SINGLETON);
    }

}

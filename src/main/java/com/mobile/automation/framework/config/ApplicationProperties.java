package com.mobile.automation.framework.config;

/**
 * @author Tomash Gombosh
 */
public final class ApplicationProperties {
    public static final String ANDROID_APP_PACKAGE = new ProjectConfig().getPackageName();
    public static final String BASE_USERNAME = new ProjectConfig().getBaseUser();
    public static final String BASE_PASSWORD = new ProjectConfig().getBaseUserPassword();

    private ApplicationProperties() {
        throw new UnsupportedOperationException("Suppress default constructor for noninstantiability");
    }


}

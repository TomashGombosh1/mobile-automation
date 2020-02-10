package com.qardio.auto.mobile.config;

/**
 * @author Tomash Gombosh
 */
public final class ApplicationProperties {
    public static final String ANDROID_APP_PACKAGE = new ApplicationConfig().getPackageName();
    public static final String BASE_USERNAME = new ApplicationConfig().getBaseUser();
    public static final String BASE_PASSWORD = new ApplicationConfig().getBaseUserPassword();

    private ApplicationProperties() {
        throw new UnsupportedOperationException("Suppress default constructor for noninstantiability");
    }


}

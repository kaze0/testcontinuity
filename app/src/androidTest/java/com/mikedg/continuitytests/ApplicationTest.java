package com.mikedg.continuitytests;

import android.Manifest;
import android.app.Application;
import android.test.ApplicationTestCase;

import org.junit.Test;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Test
    public void testHasInternetPermission() {
        assertTrue("Someone must have deleted the internet permission. Do you really not need this anymore?", TestingUtil.doesPackageHavePermission(Manifest.permission.INTERNET, BuildConfig.APPLICATION_ID));
    }
}
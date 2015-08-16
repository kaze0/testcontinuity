package com.mikedg.continuitytests;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.test.InstrumentationRegistry;

/**
 * Created by vinbl on 8/16/2015.
 */
public class TestingUtil {
    public static final boolean doesPackageHavePermission(String permission, String packageName) {
        Context context = InstrumentationRegistry.getTargetContext();
        PackageManager packageManager = context.getPackageManager();

        int hasPermission = packageManager.checkPermission(permission, packageName);

        return hasPermission == PackageManager.PERMISSION_GRANTED;
    }
}

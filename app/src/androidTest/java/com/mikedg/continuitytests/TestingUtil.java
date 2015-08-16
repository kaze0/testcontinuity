package com.mikedg.continuitytests;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.support.test.InstrumentationRegistry;

/**
 * Created by vinbl on 8/16/2015.
 */
public class TestingUtil {
    private static final PackageManager getPackageManager() {
        Context context = InstrumentationRegistry.getTargetContext();
        PackageManager packageManager = context.getPackageManager();

        return packageManager;
    }

    public static final boolean doesPackageHavePermission(String permission, String packageName) {
        int hasPermission = getPackageManager().checkPermission(permission, packageName);

        return hasPermission == PackageManager.PERMISSION_GRANTED;
    }

    public static final boolean doesSignatureMatch(String characterSignature) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = getPackageManager();
        Signature[] signatures = packageManager.getPackageInfo(packageManager.getNameForUid(Binder.getCallingUid()), PackageManager.GET_SIGNATURES).signatures;

        if (signatures.length != 1) {
            return false; //Right now we only check a single signature
        }

        return characterSignature.equals( signatures[0].toCharsString());
    }
}

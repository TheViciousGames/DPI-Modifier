package com.theviciousgames.dpimodifier;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class Tools {
    public static int getDPI(Activity activity)
    {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.densityDpi;
    }
    public static void setDPI(int value)
    {
        Superuser.executeCommandSU(Resources.SET_DENSITY+value);
    }
}

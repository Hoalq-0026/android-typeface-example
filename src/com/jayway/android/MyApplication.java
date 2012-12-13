package com.jayway.android;

import android.app.Application;
import android.graphics.Typeface;

public class MyApplication extends Application {
    public static final String PATH_TYPEFACE_FOLDER = "typefaces/";
    public static final String PATH_TYPEFACE_CUSTOM = PATH_TYPEFACE_FOLDER + "JandaQuirkygirl.ttf";
    
    private static Typeface customTypeface;
    
    public Typeface getCustomTypeface() {
        if (customTypeface == null) {
            customTypeface = Typeface.createFromAsset(getAssets(), PATH_TYPEFACE_CUSTOM);
        }

        return customTypeface;
    }
}

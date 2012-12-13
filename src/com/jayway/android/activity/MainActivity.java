package com.jayway.android.activity;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.jayway.android.MyApplication;
import com.jayway.android.R;

public class MainActivity extends Activity {

    private static final boolean USE_CUSTOM_TYPEFACE    = true;
    private static final boolean USE_SUBPIXEL_TEXT_FLAG = true;

    @Override
    public void onCreate(final Bundle savedState) {
        super.onCreate(savedState);
        setContentView(R.layout.activity_main);
        
        MyApplication app = (MyApplication) getApplication();
        
        final Typeface typeface = app.getCustomTypeface(); 
        
        TextView exampleTextViewA = (TextView) findViewById(R.id.example_textview_a);
        
        final int originalPaintFlags = exampleTextViewA.getPaintFlags(); 

        if(USE_CUSTOM_TYPEFACE){
            exampleTextViewA.setTypeface(typeface);
        }
        if(USE_SUBPIXEL_TEXT_FLAG){
            exampleTextViewA.setPaintFlags(originalPaintFlags | Paint.SUBPIXEL_TEXT_FLAG);
        }
    }
}

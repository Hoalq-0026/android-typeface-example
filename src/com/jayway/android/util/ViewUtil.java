package com.jayway.android.util;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A Utility class which provides functionality for doing common operations on one or more
 * {@link View} or {@link ViewGroup} e.g. setting the {@link Typeface}.
 * 
 * @author Andreas Nilsson 
 * 
 */
public class ViewUtil {
    private static boolean DO_SUBPIXEL_RENDERING = true;
    
    /**
     * Sets the {@link TypeFace} <code>typeFace</code> for all {@link TextView}'s in the view-hierarchy of {@link ViewGroup} <code>parent</code>.
     * 
     * @param typeFace
     * @param parent
     */
    public static void setTypeFace(Typeface typeFace, ViewGroup parent){
        for (int i = 0; i < parent.getChildCount(); i++) {
            View v = parent.getChildAt(i);
            if (v instanceof ViewGroup) {
                setTypeFace(typeFace, (ViewGroup) v);
            } else if (v instanceof TextView) {
                TextView tv = (TextView) v;
                if(DO_SUBPIXEL_RENDERING){
                    tv.setPaintFlags(tv.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
                }
                tv.setTypeface(typeFace);
            }
        }
    }
    
    /**
     * @see ViewUtil#setTypeFace(Typeface, ViewGroup)
     * 
     *  Sets the type face for n-views, but NOT for their children.
     * 
     * @param typeFace
     * @param views
     */
    public static void setTypeFace(Typeface typeFace, TextView ... views){
        for(TextView view: views){
            view.setTypeface(typeFace);
            if(DO_SUBPIXEL_RENDERING){
                System.out.println("do subpixel rendering");
                view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
            }
        }
    }
    
    /**
     * Sets visibility of n {@link View} <code>views</code> to {@link View#INVISIBLE}
     * 
     * @param views
     */
    public static void setViewsInvisible(View ... views){
        setViewVisibility(View.INVISIBLE, views);
    }

    /**
     * Sets visibility of n {@link View} <code>views</code> to {@link View#VISIBLE}
     * 
     * @param views
     */
    public static void showViews(View ... views){
        setViewVisibility(View.VISIBLE, views);
    }
    
    /**
     * Sets visibility of n {@link View} <code>views</code> to {@link View#GONE}
     * 
     * @param views
     */
    public static void hideViews(View ... views){
        setViewVisibility(View.GONE, views);
    }
    
    /**
     * @param visibility {@link View#GONE}, {@link View#VISIBLE} or {@link View#INVISIBLE}
     * @param views
     */
    public static void setViewVisibility(int visibility, View ... views){
        for(View v : views){
            v.setVisibility(visibility);
        }
    }

    public static void setOnClickListenerForViews(OnClickListener onClickListener, View ... views) {
        for(View v : views){
            v.setOnClickListener(onClickListener);
        }
    }
    
    public static void setSubpixelRendering(boolean enabled){
        DO_SUBPIXEL_RENDERING = enabled;
    }
}

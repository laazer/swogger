package com.laazer.swogger.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Laazer on 11/9/2016.
 */
public class FontManager {

    public static final String ROOT = "fonts/",
            FONTAWESOME = ROOT + "fontawesome-webfont.ttf";

    private LruCache<String, Typeface> cache;
    private Context context;
    public FontManager(Context context) {
        this(context, 4);
    }
    public FontManager(Context context, int cacheSize) {
        this.context = context;
        this.cache = new LruCache<>(cacheSize);
    }

    public Typeface getTypeface(String font) {
        if(cache.get(font) == null) {
            Typeface t = Typeface.createFromAsset(context.getAssets(), font);
            cache.put(font, t);
        }
        return cache.get(font);
    }

    public void markAsIconContainer(View v, String font) {
        markAsIconContainer(v, getTypeface(font));
    }

    private void markAsIconContainer(View v, Typeface typeface) {
        if (v instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) v;
            for (int i = 0; i < vg.getChildCount(); i++) {
                View child = vg.getChildAt(i);
                markAsIconContainer(child, typeface);
            }
        } else if (v instanceof TextView) {
            ((TextView) v).setTypeface(typeface);
        }
    }

    public void destroy() {
        this.cache.evictAll();
    }
}

package com.xinshiyun.focusdemo.adapter;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.core.view.ViewCompat;
import androidx.databinding.BindingAdapter;

/**
 * View 适配器
 *
 * @author Chris
 */
public class ViewBindingAdapter {

    private static final String TAG = "ViewBindingAdapter";

    /**
     * 根据是否获取焦点更改背景
     *
     * @param view
     * @param focusResId
     * @param unFocusResId
     */
    @BindingAdapter(value = {"focusedBackDrawable", "unfocusedBackDrawable"})
    public static void changeViewBackground(View view, final Drawable focusResId, final Drawable unFocusResId) {
        view.setOnFocusChangeListener((view1, isFocus) -> {
            if (isFocus) {
                view1.setBackground(focusResId);
                scaleAnimation(view, 200, 1.1f, 1.1f);
            } else {
                view1.setBackground(unFocusResId);
                scaleAnimation(view, 200, 1.0f, 1.0f);
            }
        });
    }


    @BindingAdapter(value = {"focusedBackDrawable", "unfocusedBackDrawable", "focusedTextColor", "unfocusedTextColor"})
    public static void changeViewStyle(TextView textView, final Drawable focusResId, final Drawable unFocusResId, final int focusedColor, final int unfocusedColor) {
        textView.setOnFocusChangeListener((view, b) -> {
            if (b) {
                Log.i(TAG, "focusedColor: " + focusedColor);
                view.setBackground(focusResId);
                textView.setTextColor(focusedColor);
                textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            } else {
                view.setBackground(unFocusResId);
                textView.setTextColor(unfocusedColor);
                textView.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                Log.i(TAG, "unfocusedColor: " + unfocusedColor);

            }
        });
    }

    @BindingAdapter(value = {"focusedTextColor", "unfocusedTextColor"})
    public static void changeTextView(TextView textView, final int focusedColor, final int unfocusedColor) {
        textView.setOnFocusChangeListener((view, b) -> {
            if (b) {
                Log.i(TAG, "focusedColor: " + focusedColor);
                textView.setTextColor(focusedColor);
                textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            } else {
                textView.setTextColor(unfocusedColor);
                textView.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                Log.i(TAG, "unfocusedColor: " + unfocusedColor);

            }
        });
    }

    @BindingAdapter(value = {"focusedBackDrawable", "unfocusedBackDrawable", "focusedTextColor", "unfocusedTextColor", "focusedTextDrawable", "unfocusedTextDrawable"})
    public static void changeTextViewStyle(TextView textView, final Drawable focusResId, final Drawable unFocusResId, final int focusedColor, final int unfocusedColor, final Drawable focusTextResId, final Drawable unFocusTextResId) {
        textView.setOnFocusChangeListener((view, b) -> {
            if (b) {
                Log.i(TAG, "focusedColor: " + focusedColor);
                view.setBackground(focusResId);
                textView.setTextColor(focusedColor);
                textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                focusTextResId.setBounds(0, 0, focusTextResId.getMinimumWidth(), focusTextResId.getMinimumHeight());
                textView.setCompoundDrawables(focusTextResId, null, null, null);
            } else {
                view.setBackground(unFocusResId);
                textView.setTextColor(unfocusedColor);
                textView.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                Log.i(TAG, "unfocusedColor: " + unfocusedColor);
                unFocusTextResId.setBounds(0, 0, unFocusTextResId.getMinimumWidth(), unFocusTextResId.getMinimumHeight());
                textView.setCompoundDrawables(unFocusTextResId, null, null, null);

            }
        });
    }

    private static void scaleAnimation(View view, int duration, float scaleX, float scaleY) {
        ViewCompat.animate(view)
                .setDuration(duration)
                .scaleX(scaleX)
                .scaleY(scaleY)
                .start();
    }
}

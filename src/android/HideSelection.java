package com.wstorm.selectionplugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

public class HideSelection extends CordovaPlugin implements OnTouchListener {

    private CordovaWebView webView;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
      super.initialize(cordova, webView);
      this.webView = webView;
      mTextSelectionSupport = TextSelectionSupport.support(this, mWebView);
      mTextSelectionSupport.setSelectionListener(new TextSelectionSupport.SelectionListener() {
          @Override
          public void startSelection() {
          }
          @Override
          public void selectionChanged(String text) {
              Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
          }
          @Override
          public void endSelection() {
          }
      });
      mWebView.setWebViewClient(new WebViewClient() {
          public void onScaleChanged(WebView view, float oldScale, float newScale) {
              mTextSelectionSupport.onScaleChanged(oldScale, newScale);
          }
      });
    }

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        this.

        if (action.equals("hideMenu")) {

            String name = data.getString(0);
            String message = "Hello, " + name;
            callbackContext.success(message);

            return true;

        } else {

            return false;

        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final Context ctx = mActivity;
        float xPoint = getDensityIndependentValue(event.getX(), ctx) / getDensityIndependentValue(mScale, ctx);
        float yPoint = getDensityIndependentValue(event.getY(), ctx) / getDensityIndependentValue(mScale, ctx);

        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            // Essential to add Locale.US parameter to String.format, else does not work on systems
            // with default locale different, with other floating point notations, e.g. comma instead
            // of decimal point.
            final String startTouchUrl = String.format(Locale.US, "javascript:android.selection.startTouch(%f, %f);", xPoint, yPoint);
            mLastTouchX = xPoint;
            mLastTouchY = yPoint;
            mWebView.loadUrl(startTouchUrl);
            break;
        case MotionEvent.ACTION_UP:
            if (!mScrolling) {
                endSelectionMode();
                //
                // Fixes 4.4 double selection
                // See: http://stackoverflow.com/questions/20391783/how-to-avoid-default-selection-on-long-press-in-android-kitkat-4-4
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    return false;
                }
            }
            mScrollDiffX = 0;
            mScrollDiffY = 0;
            mScrolling = false;
            //
            // Fixes 4.4 double selection
            // See: http://stackoverflow.com/questions/20391783/how-to-avoid-default-selection-on-long-press-in-android-kitkat-4-4
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && isInSelectionMode()) {
            	return true;
            }
            break;
        case MotionEvent.ACTION_MOVE:
            mScrollDiffX += (xPoint - mLastTouchX);
            mScrollDiffY += (yPoint - mLastTouchY);
            mLastTouchX = xPoint;
            mLastTouchY = yPoint;
            if (Math.abs(mScrollDiffX) > SCROLLING_THRESHOLD || Math.abs(mScrollDiffY) > SCROLLING_THRESHOLD) {
                mScrolling = true;
            }
            break;
        }
        return false;
    }


}

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
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;


public class HideSelection extends CordovaPlugin {

    private CordovaWebView webView;
    private ActionMode mActionMode = null;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
      super.initialize(cordova, webView);
      this.webView = webView;
    }

    @Override
    public void onActionModeStarted(ActionMode mode) {
        if (mActionMode == null) {
            mActionMode = mode;
            Menu menu = mode.getMenu();
            menu.clear();
            // getMenuInflater().inflate(R.menu.YOUR_MENU, menu);
            // List<MenuItem> menuItems = new ArrayList<>();
            // // get custom menu item
            // for (int i = 0; i < menu.size(); i++) {
            //     menuItems.add(menu.getItem(i));
            // }
            // menu.clear();
            // // reset menu item order
            // int size = menuItems.size();
            // for (int i = 0; i < size; i++) {
            //     addMenuItem(menu, menuItems.get(i), i, true);
            // }
            super.onActionModeStarted(mode);
        }
    }


    /**
     * add custom item to menu
     * @param menu
     * @param item
     * @param order
     * @param isClick
     */
    private void addMenuItem(Menu menu, MenuItem item, int order, boolean isClick){
        MenuItem menuItem = menu.add(item.getGroupId(),
                item.getItemId(),
                order,
                item.getTitle());
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        if (isClick)
            // set custom menu item click
            menuItem.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("hideMenu")) {

            String name = data.getString(0);
            String message = "Hello, " + name;
            callbackContext.success(message);

            return true;

        } else {

            return false;

        }
    }

}

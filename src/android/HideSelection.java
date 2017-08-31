package com.wstorm.selectionplugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import android.webkit.WebSettings;
import android.webkit.WebView;


public class HideSelection extends CordovaPlugin {

    private CordovaWebView webView;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
      this.webView = webView;
      this.webView.getView().setOnCreateContextMenuListener(null);
      super.initialize(cordova, this.webView);      
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

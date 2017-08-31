package com.wstorm.selectionplugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;
import android.app.Activity;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class HideSelection extends CordovaPlugin {

    private CordovaWebView webView;
    private Activity activity;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
      Log.i("Teste", "Passou initialize");
      this.webView = webView;
      this.activity = cordova.getActivity();
      cordova.getActivity().unregisterForContextMenu(this.webView);
      super.initialize(cordova, this.webView);
    }

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("hideMenu")) {

            Log.i("Teste", "Passou execute");
            this.webView.getView().setOnCreateContextMenuListener(null);

            String name = data.getString(0);
            String message = "Hello, " + name;
            callbackContext.success(message);

            return true;

        } else {

            return false;

        }
    }

}

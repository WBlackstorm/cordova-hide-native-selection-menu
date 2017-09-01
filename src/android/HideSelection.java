package com.wstorm.selectionplugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;
import android.app.Activity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.view.View;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

public class HideSelection extends CordovaPlugin {

    private CordovaWebView webViewObject;
    private Activity activity;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
      Log.i("Teste", "Passou initialize");
      this.webViewObject = webView;
      this.activity = cordova.getActivity();

      this.activity.runOnUiThread(new Runnable() {
          @Override
          public void run() {

            activity.unregisterForContextMenu(webViewObject.getView());
            activity.closeContextMenu();

          }
      });

      super.initialize(cordova, this.webViewObject);
    }

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("hideMenu")) {

            Log.i("Teste", "Passou execute");

            String name = data.getString(0);
            String message = "Hello, " + name;
            callbackContext.success("Sucesso");

            return true;

        } else {
            callbackContext.error("Erro");
            return false;

        }
    }

}

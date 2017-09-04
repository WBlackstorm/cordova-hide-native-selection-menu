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

      super.initialize(cordova, webView);

      this.webViewObject = webView;
      this.activity = cordova.getActivity();

    }

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("hideMenu")) {

            this.activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                  webViewObject.getView().setLongClickable(false);
                  activity.unregisterForContextMenu(webViewObject.getView());


                }
            });

            callbackContext.success("Sucesso");

            return false;

        } else {
            callbackContext.error("Erro");
            return false;

        }
    }

}

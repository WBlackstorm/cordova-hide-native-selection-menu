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

public class HideSelection extends CordovaPlugin {

    private CordovaWebView webView;
    private Activity activity;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
      Log.i("Teste", "Passou initialize");
      this.webView = webView;
      this.activity = cordova.getActivity();

      this.activity.startActionMode(new ActionMode.Callback() {

          @Override
          public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
              return false;
          }

          @Override
          public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
              return false;
          }

          @Override
          public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
              return false;
          }

          @Override
          public void onDestroyActionMode(ActionMode actionMode) {

          }

      });

      super.initialize(cordova, this.webView);
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

package com.BitWyze.polarionlive2014;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class PartnerActivity extends Activity {
	 private WebView webView;
	 
	 
	@Override
      protected void onCreate(Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);
              setContentView(R.layout.partners_view);
              
              this.webView = (WebView)findViewById(R.id.webview);

              WebSettings settings = webView.getSettings();
              settings.setJavaScriptEnabled(true);
              webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
              
//              final AlertDialog alertDialog = new AlertDialog.Builder(this).create();

 //             ProgressDialog.show(this, "WebView Example", "Loading...");
              
              webView.loadUrl("http://54.183.27.217/partners.php");

      }

}

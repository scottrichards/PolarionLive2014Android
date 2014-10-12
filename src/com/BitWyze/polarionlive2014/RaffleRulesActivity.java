package com.BitWyze.polarionlive2014;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class RaffleRulesActivity extends Activity {
	private WebView webView;
	 
	 
	@Override
      protected void onCreate(Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);
              setContentView(R.layout.partners_view);
              
              this.webView = (WebView)findViewById(R.id.webview);

              WebSettings settings = webView.getSettings();
              settings.setJavaScriptEnabled(true);
              webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
              
              webView.loadUrl("http://54.183.27.217/rules.html");
      }
}

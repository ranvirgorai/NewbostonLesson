package com.taple.tstapp;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ourViewClient extends WebViewClient {
	
public boolean  shouldOver(WebView v,String url){
	v.loadUrl(url);
	return true;
}
}

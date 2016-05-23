package com.taple.tstapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class GFX extends Activity {
    MyClass ourView;
    WakeLock wL;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		//wake Lock 
		PowerManager pM=(PowerManager)getSystemService(Context.POWER_SERVICE);
		wL=pM.newWakeLock(PowerManager.FULL_WAKE_LOCK, "Game");
		super.onCreate(savedInstanceState);
		wL.acquire();
		ourView = new MyClass(this);
		setContentView(ourView);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		wL.release();
	}

}

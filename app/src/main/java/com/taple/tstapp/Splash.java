package com.taple.tstapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity {
  MediaPlayer song;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		song=MediaPlayer.create(Splash.this,R.raw.splashsound);
		SharedPreferences getPrefs=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music=getPrefs.getBoolean("checkbox",true) ;
		if(music)
		song.start();
		
		Thread timer= new Thread(){ 
		
			public void run(){
				try{
					sleep(1000);
					
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				finally{
					Intent openintent=new Intent("com.taple.tstapp.Menu");
					startActivity(openintent);
				} 
			}
			
		};
		timer.start();
		}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		song.release();
		finish();
	}
	
	} 



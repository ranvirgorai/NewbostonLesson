package com.taple.tstapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener,
		android.widget.RadioGroup.OnCheckedChangeListener {
	TextView question, test;
	Button returnData;
	RadioGroup seledtionList;
	String gotBread,setData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		initiliase();
		SharedPreferences getData=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		String et=getData.getString("name", "Ranvir");
		String values=getData.getString("list", "4");
		if(values.contentEquals("1")){
			question.setText(et);
		}
		//Bundle getBasket = getIntent().getExtras();
		//gotBread = getBasket.getString("key");
		//question.setText(gotBread);

	}

	private void initiliase() {
		question = (TextView) findViewById(R.id.tvQuestion);
		test = (TextView) findViewById(R.id.tvText);
		returnData = (Button) findViewById(R.id.bReturn);
      
        returnData.setOnClickListener(this);
        seledtionList=(RadioGroup)findViewById(R.id.rgAnswer);
		seledtionList.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		switch (arg1) {
		case R.id.rCrazy:
			setData="Pobably Right";
			break;
			
		case R.id.rHot:
			setData="Definatly Right";
			break;

		case R.id.rBoth:setData="Spot On !";
			break; 
		}
		test.setText(setData);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent person = new Intent();
		Bundle backpack=new Bundle();
		backpack.putString("answer", setData);
		person.putExtras(backpack);
		setResult(RESULT_OK,person);
		finish();
		
	}

}

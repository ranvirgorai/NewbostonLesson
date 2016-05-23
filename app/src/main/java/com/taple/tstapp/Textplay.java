package com.taple.tstapp;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Textplay extends Activity implements View.OnClickListener {
	Button chkcmd;
	ToggleButton tbtn;
	EditText input;
	TextView display;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		bake();
		tbtn.setOnClickListener(this);
		chkcmd.setOnClickListener(this);
	}

	private void bake() {
		// TODO Auto-generated method stub
		chkcmd = (Button) findViewById(R.id.bResult);
		tbtn = (ToggleButton) findViewById(R.id.tbPassword);
		display = (TextView) findViewById(R.id.tvResult);
		input = (EditText) findViewById(R.id.etcommand);
	}

	@Override
	public void onClick(View vw) {
		// TODO Auto-generated method stub
		switch (vw.getId()) {
		case R.id.bResult:
			String check = input.getText().toString();
			if (check.contentEquals("left")) {
				display.setText(check);
				display.setGravity(Gravity.LEFT);
			} else if (check.contentEquals("center")) {
				display.setText(check);
				display.setGravity(Gravity.CENTER);
			} else if (check.contentEquals("right")) {
				display.setText(check);
				display.setGravity(Gravity.RIGHT);
			} else if (check.contentEquals("blue")) {
				display.setText(check);
				display.setTextColor(Color.BLUE);
			} else if (check.contains("ran")) {
				Random crazy = new Random();
				display.setText("Ranvir !!!");
				display.setTextSize(crazy.nextInt(75));
				display.setTextColor(Color.rgb(crazy.nextInt(255),
						crazy.nextInt(255), crazy.nextInt(255)));
				switch (crazy.nextInt(3)) {
				case 0:
					display.setGravity(Gravity.LEFT);
					break;
				case 1:
					display.setGravity(Gravity.CENTER);
					break;
				case 2:
					display.setGravity(Gravity.RIGHT);
					break;
				}
			} else {
				display.setText("Invalid");
				display.setGravity(Gravity.CENTER);
				display.setTextColor(Color.RED);
			}

			break;
		case R.id.tbPassword:
			if (tbtn.isChecked()) {
				input.setInputType(InputType.TYPE_CLASS_TEXT
						| InputType.TYPE_TEXT_VARIATION_PASSWORD);
			} else {
				input.setInputType(InputType.TYPE_CLASS_TEXT);
			}
		}

	}
}

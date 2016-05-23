package com.taple.tstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tabs extends Activity implements OnClickListener {
	TabHost th;
	TextView showResult;
	long start = 0, stop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs);
		th = (TabHost) findViewById(R.id.tabhost);
		Button newTab = (Button) findViewById(R.id.bAddTab);
		Button bStart = (Button) findViewById(R.id.bStartWatch);
		Button bStop = (Button) findViewById(R.id.bStopWatch);
		showResult = (TextView) findViewById(R.id.tvShowResult);
		bStart.setOnClickListener(this);
		bStop.setOnClickListener(this);

		newTab.setOnClickListener(this);

		th.setup();
		TabSpec spec = th.newTabSpec("tag1");
		spec.setContent(R.id.tab1);
		spec.setIndicator("StopWatch");
		th.addTab(spec);
		spec = th.newTabSpec("tag2");
		spec.setContent(R.id.tab2);
		spec.setIndicator("Tab 2");
		th.addTab(spec);
		spec = th.newTabSpec("tag3");
		spec.setContent(R.id.tab3);
		spec.setIndicator("Add A Tab");
		th.addTab(spec);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.bAddTab:
			TabSpec ourSpec = th.newTabSpec("tag1");
			ourSpec.setContent(new TabHost.TabContentFactory() {
				@Override
				public View createTabContent(String tag) {
					// TODO Auto-generated method stub
					TextView text = new TextView(Tabs.this);
					text.setText("You have created a new tab");
					return (text);
				}
			});
			ourSpec.setIndicator("new");
			th.addTab(ourSpec);
			break;
		case R.id.bStartWatch:
			start = System.currentTimeMillis();
			break;
		case R.id.bStopWatch:
			stop = System.currentTimeMillis();
			if (start != 0) {
				long result = stop - start;
				int milis=(int)result;
				int second=(int)result/1000;
				int minutes=second/60;
				milis=milis%100;
				second=second%60;
				
				showResult.setText(String.format("%d:%02d:%02d", minutes,second,milis));
			}
			break;

		}
	}

}

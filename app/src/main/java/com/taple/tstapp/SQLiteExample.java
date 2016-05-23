package com.taple.tstapp;

import android.R.string;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLiteExample extends Activity implements OnClickListener {
	Button sqlUpdate, sqlView, sqlModify, sqlGetInfo, sqlDelete;
	EditText sqlName, sqlHotness, sqlRow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlliteexample);
		sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
		sqlView = (Button) findViewById(R.id.bSQLopenView);
		sqlName = (EditText) findViewById(R.id.etSQLName);
		sqlHotness = (EditText) findViewById(R.id.etSQLHotness);
		sqlView.setOnClickListener(this);
		sqlUpdate.setOnClickListener(this);

		sqlRow = (EditText) findViewById(R.id.etRowId);
		sqlModify = (Button) findViewById(R.id.bSQLmodify);
		sqlGetInfo = (Button) findViewById(R.id.bgetInfo);
		sqlDelete = (Button) findViewById(R.id.bSQLdelete);
		sqlModify.setOnClickListener(this);
		sqlGetInfo.setOnClickListener(this);
		sqlDelete.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bSQLUpdate:
			boolean didIiWork = true;
			try {
				String name = sqlName.getText().toString();
				String hotness = sqlHotness.getText().toString();

				CoolOrNot entry = new CoolOrNot(SQLiteExample.this);
				entry.open();
				entry.creatEntry(name, hotness);
				entry.close();
			} catch (Exception e) {
				didIiWork = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Heck Yeah !");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();

			} finally {
				if (didIiWork) {
					Dialog d = new Dialog(this);
					d.setTitle("Heck Yeah !");
					TextView tv = new TextView(this);
					tv.setText("Sucess");
					d.setContentView(tv);
					d.show();
				}
			}
			break;

		case R.id.bSQLopenView:
			Intent i = new Intent("com.taple.tstapp.SQLVIEW");
			startActivity(i);
			break;
		case R.id.bgetInfo:try{
				String s=sqlRow.getText().toString();
				long l=Long.parseLong(s);
				CoolOrNot hon=new CoolOrNot(this);
				hon.open();
				String returnName=hon.getName(l);
				String returnHotness=hon.getHotness(l);
				hon.close(); 
				sqlName.setText(returnName);
				sqlHotness.setText(returnHotness);
		}catch (Exception e) {
					String error = e.toString();
					Dialog d = new Dialog(this);
					d.setTitle("Heck Yeah !");
					TextView tv = new TextView(this);
					tv.setText(error);
					d.setContentView(tv);
					d.show();

				}
				
			break;
		case R.id.bSQLdelete:try{
			
			String sRow1=sqlRow.getText().toString();
			long lRow1=Long.parseLong(sRow1);
			CoolOrNot ex1=new CoolOrNot(this);
			ex1.open();
			ex1.deleteRow(lRow1);
			ex1.close();
		}catch (Exception e) {
			String error = e.toString();
			Dialog d = new Dialog(this);
			d.setTitle("Heck Yeah !");
			TextView tv = new TextView(this);
			tv.setText(error);
			d.setContentView(tv);
			d.show();

		}
			
			break;
		case R.id.bSQLmodify:try{
			String mName = sqlName.getText().toString();
			String mHotness = sqlHotness.getText().toString();
			String sRow=sqlRow.getText().toString();
			long lRow=Long.parseLong(sRow);
			CoolOrNot ex=new CoolOrNot(this);
			ex.open();
				ex.updateEntry(lRow, mName, mHotness);
				ex.close();
		}catch (Exception e) {
			String error = e.toString();
			Dialog d = new Dialog(this);
			d.setTitle("Heck Yeah !");
			TextView tv = new TextView(this);
			tv.setText(error);
			d.setContentView(tv);
			d.show();

		}
			break;
		}
	}
}

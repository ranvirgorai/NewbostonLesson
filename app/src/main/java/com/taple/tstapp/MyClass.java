package com.taple.tstapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

@SuppressLint("DrawAllocation") public class MyClass extends View{
	Bitmap gBall;
	float changingY;
	Typeface font;
	

	public MyClass(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		gBall=BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
		changingY=0;
		font =Typeface.createFromAsset(context.getAssets(),"G-Unit.ttf");
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);
		
		Paint textPaint=new Paint();
		textPaint.setARGB(50, 254, 10, 50);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(50);
		textPaint.setTypeface(font);
		canvas.drawText("RANVIR", canvas.getWidth()/2, 200,textPaint);
		
		
		canvas.drawBitmap(gBall, (canvas.getWidth()/2-80),changingY, null);
		if(changingY<canvas.getHeight()){
			changingY+=10;
		}else{
			changingY=0; 
		}
		Rect middleRect=new Rect();
		middleRect.set(0, 400,canvas.getHeight(),500);
		Paint ourBlue=new Paint();
		ourBlue.setColor(Color.BLUE);
		canvas.drawRect(middleRect, ourBlue);
		invalidate();
	}
   
	
	
}

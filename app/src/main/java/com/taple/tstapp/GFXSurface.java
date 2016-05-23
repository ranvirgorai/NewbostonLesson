package com.taple.tstapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

@SuppressLint("ClickableViewAccessibility")
public class GFXSurface extends Activity implements OnTouchListener {

	MyClassSurface mySurfaceView;
	float x, y, sX, sY, fX, fY, dX, dY, aniX, aniY, scaledX, scaledY;
	Bitmap test, plus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mySurfaceView = new MyClassSurface(this);
		mySurfaceView.setOnTouchListener(this);
		x = y = sX = sY = fX = fY = dX = dY = aniX = aniY = scaledX = scaledY = 0;
		test = BitmapFactory.decodeResource(getResources(),
				R.drawable.greenball);
		plus = BitmapFactory.decodeResource(getResources(), R.drawable.plus);
		setContentView(mySurfaceView);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mySurfaceView.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mySurfaceView.resume();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		x = event.getX();
		y = event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			sX = event.getX();
			sX = event.getY();
			dX = dY = aniX = aniY = scaledX = scaledY =fX=fY=0;
			break;

		case MotionEvent.ACTION_UP:
			fX = event.getX();
			fY = event.getY();
			dX=fX-sX;
			dY=fY-sY;
			scaledX=dX/30;
			scaledY=dY/30;
			x=y=0;
			break;
		}
		return true;
	}

	public class MyClassSurface extends SurfaceView implements Runnable {

		SurfaceHolder myHolder;
		Thread myThread = null;
		boolean isRunning = false;

		public MyClassSurface(Context context) {
			super(context);
			myHolder = getHolder();

		}

		public void pause() {
			isRunning = false;
			while (true) {
				try {
					myThread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
			myThread = null;
		}

		public void resume() {
			isRunning = true;
			myThread = new Thread(this);
			myThread.start();
		}

		public void run() {
			while (isRunning) {
				if (!myHolder.getSurface().isValid())
					continue;
				Canvas canvas = myHolder.lockCanvas();
				canvas.drawRGB(02, 02, 150);
				if (x != 0 && y != 0) {

					canvas.drawBitmap(test, x - (test.getWidth() / 2), y
							- (test.getWidth() / 2), null);
				}
				if (sX != 0 && sY != 0) {

					canvas.drawBitmap(plus, sX - (plus.getWidth() / 2), sY
							- (plus.getWidth() / 2), null);
				}
				if (fX != 0 && fY != 0) {
					canvas.drawBitmap(test, fX - (test.getWidth() / 2)-aniX, fY
							- (test.getWidth() / 2)-aniY, null);
					canvas.drawBitmap(plus, fX - (plus.getWidth() / 2), fY
							- (plus.getWidth() / 2), null);
				}
				aniX=aniX+scaledX;
				aniY=aniY+scaledY;
				myHolder.unlockCanvasAndPost(canvas);
			}
		}

	}

}

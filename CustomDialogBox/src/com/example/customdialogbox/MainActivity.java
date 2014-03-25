package com.example.customdialogbox;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener {

	MyDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.button1).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		Log.e("1", "ok");

		dialog = new MyDialog(MainActivity.this);

		dialog.show();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				dialog.dismiss();

			}
		}, 6000);

		Log.e("6", "ok");
	}

	class MyDialog extends Dialog {

		ImageView imageView;

		public MyDialog(Context context) {
			super(context, R.style.MyDialog);

			WindowManager.LayoutParams windParam = getWindow().getAttributes();
			windParam.gravity = Gravity.CENTER;
			getWindow().setAttributes(windParam);
			setTitle(null);
			setCancelable(false);

			LinearLayout layout = new LinearLayout(context);
			layout.setOrientation(LinearLayout.VERTICAL);
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

			imageView = new ImageView(context);
			// imageView.setImageResource(R.drawable.spinner);
			imageView.setBackgroundResource(R.drawable.for_dialog);

			layout.addView(imageView, params);
			addContentView(layout, params);

		}

		@Override
		public void show() {
			// TODO Auto-generated method stub
			super.show();

			/*
			 * Animation animation = AnimationUtils.loadAnimation(
			 * MainActivity.this, R.anim.rotate);
			 * imageView.startAnimation(animation);
			 */

			AnimationDrawable animation = (AnimationDrawable) imageView
					.getBackground();
			animation.start();

			/*
			 * RotateAnimation rotateAnimation = new RotateAnimation(0.0f,
			 * 360.0f, Animation.RELATIVE_TO_SELF, 0.5f,
			 * Animation.RELATIVE_TO_SELF, .5f);
			 * 
			 * rotateAnimation.setDuration(6000);
			 * imageView.startAnimation(rotateAnimation);
			 */

		}
	}

}

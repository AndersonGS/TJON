package com.ads.proplan;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

//@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

	//@ViewById(R.id.splash_image_icone)
	public ImageView iconeImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iconeImageView = (ImageView) findViewById(R.id.splash_image_icone);
	}

	@Override
	protected void onResume() {
		super.onResume();
		timeSplash(2000);
	}

	/**
	 * O metodo Time splash da classe MainActivity, é uma metodo void que tem o
	 * objetivo de criar um processo paralelo para contar um tempo que acionara
	 * uma noma activity e executara o finish nesta.
	 * 
	 * @param time
	 *            - O parametro time é do tipo int. Ele determina o tempo em
	 *            milesegundos
	 */
	private void timeSplash(int time) {
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, QuestionActivity.class);
				startActivity(intent);
				finish();
			}
		}, time);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

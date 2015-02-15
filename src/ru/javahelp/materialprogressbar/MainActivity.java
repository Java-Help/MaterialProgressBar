package ru.javahelp.materialprogressbar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.pnikosis.materialishprogress.ProgressWheel;

public class MainActivity extends Activity{
	
		private ProgressWheel progressBar;
		private Spinner spinner1;
		private Spinner spinner2;
		private Spinner spinner3;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.main);

			spinner1 = (Spinner) findViewById(R.id.spinner_1);
			spinner2 = (Spinner) findViewById(R.id.spinner_2);
			spinner3 = (Spinner) findViewById(R.id.spinner_3);

			spinner1.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, getResources().getStringArray(R.array.progress_value_options)));
			spinner2.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, getResources().getStringArray(R.array.progress_color_options)));
			spinner3.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, getResources().getStringArray(R.array.wheel_color_options)));
			progressBar = (ProgressWheel) findViewById(R.id.progressBar);
			
			progressBar.setLinearProgress(true);
			progressBar.spin();
			
			final int defaultBarColor = progressBar.getBarColor();
			final int defaultWheelColor = progressBar.getRimColor();
			
			spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					@Override
					public void onNothingSelected(AdapterView<?> p1){
					}
					
					@Override
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						switch(position) {
							case 0:
								progressBar.setProgress(0.0f);
							break;
							
							case 1:
								progressBar.setProgress(0.25f);
							break;
							
							case 2:
								progressBar.setProgress(0.5f);
							break;
							
							case 3:
								progressBar.setProgress(0.75f);
							break;
							
							case 4:
								progressBar.setProgress(1f);
							break;
							
							case 5:
								progressBar.spin();
							break;
							
							}
					}
					}
				);
				
			spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					@Override
					public void onNothingSelected(AdapterView<?> p1){
					}

					@Override
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						switch(position) {
							case 0:
								progressBar.setBarColor(defaultBarColor);
								break;

							case 1:
								progressBar.setBarColor(Color.RED);
								break;

							case 2:
								progressBar.setBarColor(Color.MAGENTA);
								break;

						}
					}
				}
			);
			
			
			spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					@Override
					public void onNothingSelected(AdapterView<?> p1){
					}

					@Override
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						switch(position) {
							case 0:
								progressBar.setRimColor(defaultWheelColor);
								break;

							case 1:
								progressBar.setRimColor(Color.LTGRAY);
								break;

							case 2:
								progressBar.setRimColor(Color.GRAY);
								break;

						}
					}
				}
			);
		
			}
}


/*
 * Spencer Davis
 * cpsc 390
 * */
package com.spencerdavis.gpa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class main extends Activity{
	
	Button start;
	Button setGradeMapping;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		start = (Button)findViewById(R.id.bStart);
		setGradeMapping = (Button)findViewById(R.id.bsetGradeMapping);
		
		start.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
			
				Intent startfresh = new Intent("com.spencerdavis.gpa.START");
				startActivity(startfresh);
			}
		});
		setGradeMapping.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent setGradeMapping = new Intent("com.spencerdavis.gpa.GRADE_MAPPING");
				startActivity(setGradeMapping);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		//make sure item is aboutUs, then startActivity within this context
		
		switch(item.getItemId()){
		case R.id.aboutUs:
			
			Intent aboutUs = new Intent("com.spencerdavis.gpa.ABOUT_US");
			startActivity(aboutUs);
			
		}
		
		return false;
	}
	
	
	
	
	
}

/*
 * Spencer Davis
 * cpsc 390
 * */
package com.spencerdavis.gpa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class start extends Activity{
	
	Button startFresh;
	Button enterGPA;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
		
		startFresh = (Button)findViewById(R.id.bStartFresh);
		enterGPA = (Button)findViewById(R.id.bEnterGPA);
		
		startFresh.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//since it starts FRESH, everything is set to 0.0 just in case
				((variables)getApplication()).setTotalCredits(0.0);
				((variables)getApplication()).setTotalGPA(0.0);
				((variables)getApplication()).setTotalGradePoints(0.0);
				
				Intent calculate = new Intent("com.spencerdavis.gpa.CALCULATE");
				startActivity(calculate);
			}
		});
		enterGPA.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent enterGPA = new Intent("com.spencerdavis.gpa.ENTER_GPA");
				startActivity(enterGPA);
			}
		});
		
	}
	
}

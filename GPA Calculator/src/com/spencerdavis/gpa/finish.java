package com.spencerdavis.gpa;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class finish extends Activity{
	
	TextView totalCredits;
	TextView totalGradePoints;
	TextView totalGPA;
	Button startOver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.finish);
		
		//wire everything up
		totalCredits = (TextView)findViewById(R.id.tvTotalCredits);
		totalGradePoints = (TextView)findViewById(R.id.tvTotalGradePoints);
		totalGPA = (TextView)findViewById(R.id.tvCurrentGPA);
		startOver = (Button)findViewById(R.id.bStartOver);
		
		DecimalFormat df = new DecimalFormat("#.##");
		double finalGPA = ((variables)getApplication()).getTotalGPA();
		double finalCredits = ((variables)getApplication()).getTotalCredits();
		double finalGradePoints = ((variables)getApplication()).getTotalGradePoints();
		totalCredits.setText("Total Credits: " + df.format(finalCredits));
		totalGradePoints.setText("Total Grade Points: " + df.format(finalGradePoints));
		totalGPA.setText("Your Current GPA is: " + df.format(finalGPA));
		
		startOver.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent startOver = new Intent("com.spencerdavis.gpa.MAIN");
				startActivity(startOver);
			}
		});
		
		
	}



	




	
}

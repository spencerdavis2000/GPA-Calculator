/*
 * Spencer Davis
 * 
 * cpsc 390
 * */
package com.spencerdavis.gpa;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class enterGPA extends Activity {
	
	EditText currentGPA;
	EditText currentCredits;
	Button calculate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enter_gpa);
		
		currentGPA = (EditText)findViewById(R.id.etEnterGPA);
		currentCredits = (EditText)findViewById(R.id.etEnterTotalCredits);
		calculate = (Button)findViewById(R.id.bCalculate);
		
		//hide keyboard onLoad
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		
		//reset everything just in case it remembers anything
		((variables)getApplication()).setTotalGradePoints(0.0);
		((variables)getApplication()).setTotalCredits(0.0);
		((variables)getApplication()).setTotalGPA(0.0);
		
		calculate.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//first check for nulls.  This is needed, otherwise they will
				//just hit back button and start Fresh
				if(currentGPA.getText().toString().equals("") || currentCredits.getText().equals("")){
					alert(getBaseContext(), "Please enter GPA and total Credit hours");
				}
				else{
					
					//parse EditText into local
					double totalGPA = Double.parseDouble(currentGPA.getText().toString());
					double totalCredits = Double.parseDouble(currentCredits.getText().toString());
					//grab the highest grade and use that for upper bound
					double highGrade = ((variables)getApplication()).getAplus();
					if(totalGPA > highGrade){
						alert(getBaseContext(), "Please enter GPA: 0.0 to "+highGrade);
					}
					
					else{
						//initialize object and set GPA via Application session state
						((variables)getApplication()).setTotalGPA(totalGPA);
						((variables)getApplication()).setTotalCredits(totalCredits);
						
	
						Intent calculate = new Intent("com.spencerdavis.gpa.CALCULATE");
						//move to the calculate screen
						startActivity(calculate);
					}
				}
			}
		});
		
	}
	
	public static void alert(Context context, String message){
    	//make new Toast object with short duration
    	Toast msg = Toast.makeText(context, message, Toast.LENGTH_SHORT);
    	
    	//make it center
    	msg.setGravity(Gravity.CENTER, msg.getXOffset()/2, msg.getYOffset()/2);
    	
    	//Display the alert
    	msg.show();
    }

}

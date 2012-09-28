/*
 * Spencer Davis
 * cpsc 390
 * */
package com.spencerdavis.gpa;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
//import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class calculate extends Activity implements View.OnClickListener {
	
	Spinner class1;
	Spinner class2;
	Spinner class3;
	Spinner class4;
	Spinner class5;
	
	EditText class01;
	EditText class02;
	EditText class03;
	EditText class04;
	EditText class05;
	
	TextView displayGPA;
	
	Button next;
	Button finish;
	
	//use these to replace longer code with shorter by a few methods---so they are global
	String spinn1;
	String spinn2;
	String spinn3;
	String spinn4;
	String spinn5;
	String text1;
	String text2;
	String text3;
	String text4;
	String text5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculate);
		//wire up Spinner (drop down menu)
		class1 = (Spinner)findViewById(R.id.spinClass1);
		class2 = (Spinner)findViewById(R.id.spinClass2);
		class3 = (Spinner)findViewById(R.id.spinClass3);
		class4 = (Spinner)findViewById(R.id.spinClass4);
		class5 = (Spinner)findViewById(R.id.spinClass5);
		//wire up EditText
		class01 = (EditText)findViewById(R.id.etClass1);
		class02 = (EditText)findViewById(R.id.etClass2);
		class03 = (EditText)findViewById(R.id.etClass3);
		class04 = (EditText)findViewById(R.id.etClass4);
		class05 = (EditText)findViewById(R.id.etClass5);
		//wire up TextView
		displayGPA = (TextView)findViewById(R.id.tvDisplayGPA);
		//wire up Buttons
		next = (Button)findViewById(R.id.bNext);
		finish = (Button)findViewById(R.id.bFinish);
		
		
		
		//wire up Spinner Items
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.grades_array , android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		class1.setAdapter(adapter);
		class2.setAdapter(adapter);
		class3.setAdapter(adapter);
		class4.setAdapter(adapter);
		class5.setAdapter(adapter);
		next.setOnClickListener(this);
		finish.setOnClickListener(this);
		
		//A global object is created via Application session and
		//we can access every public method from the variables class
		//where all the global variables are kept
		DecimalFormat df = new DecimalFormat("#.##");
		double vari = ((variables)getApplication()).getTotalGPA();
		displayGPA.setText("Current GPA: " + df.format(vari));
		
		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(class01.getWindowToken(), 0);
		
	}

	public void onClick(View v) {
		
		switch(v.getId()){
		
		case R.id.bNext:
			//first, check for Null EditText and selected spinner:
			//if true, then give a toast message
			//else, perform the calculations and fire the Intent
			if(isSpinnerSelectedAndEditTextNull())
			{
				alert(getBaseContext(), "Please enter credits for one of the classes");
			}
			else
			{
				this.calculateGPA();
				//start activity again which is a NEW semester
				Intent next = new Intent("com.spencerdavis.gpa.CALCULATE");
				startActivity(next);
			}
			
			break;
		case R.id.bFinish:
			//first, check for Null EditText and selected spinner:
			//if true, then give a toast message
			//else, perform the calculations and fire the Intent
			if(isSpinnerSelectedAndEditTextNull())
			{
				alert(getBaseContext(), "Please enter credits for one of the classes");
			}
			else
			{
				this.calculateGPA();
				//start activity again which is a NEW semester
				Intent finish = new Intent("com.spencerdavis.gpa.FINISH");
				startActivity(finish);
			}
			break;
		}	
	}
	//This is for popups that give alert messages
	public static void alert(Context context, String message){
    	//make new Toast object with short duration
    	Toast msg = Toast.makeText(context, message, Toast.LENGTH_SHORT);
    	
    	//make it center
    	msg.setGravity(Gravity.CENTER, msg.getXOffset()/2, msg.getYOffset()/2);
    	
    	//Display the alert
    	msg.show();
    }
	private boolean isSpinnerSelectedAndEditTextNull(){
		//this method checks for a selected Spinner and a Null EditText
		spinn1 = (String)class1.getSelectedItem();
		spinn2 = (String)class2.getSelectedItem();
		spinn3 = (String)class3.getSelectedItem();
		spinn4 = (String)class4.getSelectedItem();
		spinn5 = (String)class5.getSelectedItem();
		
		text1 = class01.getText().toString();
		text2 = class02.getText().toString();
		text3 = class03.getText().toString();
		text4 = class04.getText().toString();
		text5 = class05.getText().toString();
		
		if(((text1.equals(""))&& (spinn1.equals("A+"))) 
				|| ((text1.equals(""))&& (spinn1.equals("A")))
				|| ((text1.equals(""))&& (spinn1.equals("A-")))
				|| ((text1.equals(""))&& (spinn1.equals("B+")))
				|| ((text1.equals(""))&& (spinn1.equals("B")))
				|| ((text1.equals(""))&& (spinn1.equals("B-")))
				|| ((text1.equals(""))&& (spinn1.equals("C+")))
				|| ((text1.equals(""))&& (spinn1.equals("C")))
				|| ((text1.equals(""))&& (spinn1.equals("C-")))
				|| ((text1.equals(""))&& (spinn1.equals("D+")))
				|| ((text1.equals(""))&& (spinn1.equals("D")))
				|| ((text1.equals(""))&& (spinn1.equals("D-")))
				|| ((text1.equals(""))&& (spinn1.equals("F")))
				//check for null class 2
				|| ((text2.equals(""))&& (spinn2.equals("A+"))) 
				|| ((text2.equals(""))&& (spinn2.equals("A")))
				|| ((text2.equals(""))&& (spinn2.equals("A-")))
				|| ((text2.equals(""))&& (spinn2.equals("B+")))
				|| ((text2.equals(""))&& (spinn2.equals("B")))
				|| ((text2.equals(""))&& (spinn2.equals("B-")))
				|| ((text2.equals(""))&& (spinn2.equals("C+")))
				|| ((text2.equals(""))&& (spinn2.equals("C")))
				|| ((text2.equals(""))&& (spinn2.equals("C-")))
				|| ((text2.equals(""))&& (spinn2.equals("D+")))
				|| ((text2.equals(""))&& (spinn2.equals("D")))
				|| ((text2.equals(""))&& (spinn2.equals("D-")))
				|| ((text2.equals(""))&& (spinn2.equals("F")))
				//check for null class 3
				|| ((text3.equals(""))&& (spinn3.equals("A+"))) 
				|| ((text3.equals(""))&& (spinn3.equals("A")))
				|| ((text3.equals(""))&& (spinn3.equals("A-")))
				|| ((text3.equals(""))&& (spinn3.equals("B+")))
				|| ((text3.equals(""))&& (spinn3.equals("B")))
				|| ((text3.equals(""))&& (spinn3.equals("B-")))
				|| ((text3.equals(""))&& (spinn3.equals("C+")))
				|| ((text3.equals(""))&& (spinn3.equals("C")))
				|| ((text3.equals(""))&& (spinn3.equals("C-")))
				|| ((text3.equals(""))&& (spinn3.equals("D+")))
				|| ((text3.equals(""))&& (spinn3.equals("D")))
				|| ((text3.equals(""))&& (spinn3.equals("D-")))
				|| ((text3.equals(""))&& (spinn3.equals("F")))
				//check for null class 4
				|| ((text4.equals(""))&& (spinn4.equals("A+"))) 
				|| ((text4.equals(""))&& (spinn4.equals("A")))
				|| ((text4.equals(""))&& (spinn4.equals("A-")))
				|| ((text4.equals(""))&& (spinn4.equals("B+")))
				|| ((text4.equals(""))&& (spinn4.equals("B")))
				|| ((text4.equals(""))&& (spinn4.equals("B-")))
				|| ((text4.equals(""))&& (spinn4.equals("C+")))
				|| ((text4.equals(""))&& (spinn4.equals("C")))
				|| ((text4.equals(""))&& (spinn4.equals("C-")))
				|| ((text4.equals(""))&& (spinn4.equals("D+")))
				|| ((text4.equals(""))&& (spinn4.equals("D")))
				|| ((text4.equals(""))&& (spinn4.equals("D-")))
				|| ((text4.equals(""))&& (spinn4.equals("F")))
				//check for null class 5
				|| ((text5.equals(""))&& (spinn5.equals("A+"))) 
				|| ((text5.equals(""))&& (spinn5.equals("A")))
				|| ((text5.equals(""))&& (spinn5.equals("A-")))
				|| ((text5.equals(""))&& (spinn5.equals("B+")))
				|| ((text5.equals(""))&& (spinn5.equals("B")))
				|| ((text5.equals(""))&& (spinn5.equals("B-")))
				|| ((text5.equals(""))&& (spinn5.equals("C+")))
				|| ((text5.equals(""))&& (spinn5.equals("C")))
				|| ((text5.equals(""))&& (spinn5.equals("C-")))
				|| ((text5.equals(""))&& (spinn5.equals("D+")))
				|| ((text5.equals(""))&& (spinn5.equals("D")))
				|| ((text5.equals(""))&& (spinn5.equals("D-")))
				|| ((text5.equals(""))&& (spinn5.equals("F"))))
		{
			return true;
		}
		else
		{
			
			return false;
		}
	}
	private void calculateGPA(){
		//this method handles the GPA calculations
		spinn1 = (String)class1.getSelectedItem();
		spinn2 = (String)class2.getSelectedItem();
		spinn3 = (String)class3.getSelectedItem();
		spinn4 = (String)class4.getSelectedItem();
		spinn5 = (String)class5.getSelectedItem();
		
		text1 = class01.getText().toString();
		text2 = class02.getText().toString();
		text3 = class03.getText().toString();
		text4 = class04.getText().toString();
		text5 = class05.getText().toString();
		//========================First Class==================================================================			
					//calculate GPA for class 1 for A+
					if(spinn1.equals("A+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text1);
						double gradeValue = ((variables)getApplication()).getAplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);
					}
					//calculate GPA for class 1 for A
					else if(spinn1.equals("A")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text1);
						double gradeValue = ((variables)getApplication()).getA();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for A-
					else if(spinn1.equals("A-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text1);
						double gradeValue = ((variables)getApplication()).getAminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for B+
					else if(spinn1.equals("B+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text1);
						double gradeValue = ((variables)getApplication()).getBplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for B
					else if(spinn1.equals("B")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text1);
						double gradeValue = ((variables)getApplication()).getB();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for B-
					else if(spinn1.equals("B-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text1);
						double gradeValue = ((variables)getApplication()).getBminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for C+
					else if(spinn1.equals("C+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text1);
						double gradeValue = ((variables)getApplication()).getCplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for C
					else if(spinn1.equals("C")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text1);
						double gradeValue = ((variables)getApplication()).getC();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for C-
					else if(spinn1.equals("C-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text1);
						double gradeValue = ((variables)getApplication()).getCminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for D+
					else if(spinn1.equals("D+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text1);
						double gradeValue = ((variables)getApplication()).getDplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for D
					else if(spinn1.equals("D")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text1);
						double gradeValue = ((variables)getApplication()).getD();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for D-
					else if(spinn1.equals("D-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text1);
						double gradeValue = ((variables)getApplication()).getDminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for F
					else if(spinn1.equals("F")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text1);
						double gradeValue = ((variables)getApplication()).getF();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
//=============================Second Class======================================================================
					//calculate GPA for class 2 for A+
					if(spinn2.equals("A+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text2);
						double gradeValue = ((variables)getApplication()).getAplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);
					}
					//calculate GPA for class 1 for A
					else if(spinn2.equals("A")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text2);
						double gradeValue = ((variables)getApplication()).getA();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for A-
					else if(spinn2.equals("A-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text2);
						double gradeValue = ((variables)getApplication()).getAminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for B+
					else if(spinn2.equals("B+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text2);
						double gradeValue = ((variables)getApplication()).getBplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for B
					else if(spinn2.equals("B")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text2);
						double gradeValue = ((variables)getApplication()).getB();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for B-
					else if(spinn2.equals("B-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text2);
						double gradeValue = ((variables)getApplication()).getBminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for C+
					else if(spinn2.equals("C+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text2);
						double gradeValue = ((variables)getApplication()).getCplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for C
					else if(spinn2.equals("C")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text2);
						double gradeValue = ((variables)getApplication()).getC();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for C-
					else if(spinn2.equals("C-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text2);
						double gradeValue = ((variables)getApplication()).getCminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for D+
					else if(spinn2.equals("D+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text2);
						double gradeValue = ((variables)getApplication()).getDplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for D
					else if(spinn2.equals("D")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text2);
						double gradeValue = ((variables)getApplication()).getD();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for D-
					else if(spinn2.equals("D-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text2);
						double gradeValue = ((variables)getApplication()).getDminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for F
					else if(spinn2.equals("F")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text2);
						double gradeValue = ((variables)getApplication()).getF();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
//===============================Third Class===============================================================
					//calculate GPA for class 3 for A+
					if(spinn3.equals("A+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text3);
						double gradeValue = ((variables)getApplication()).getAplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);
					}
					//calculate GPA for class 1 for A
					else if(spinn3.equals("A")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text3);
						double gradeValue = ((variables)getApplication()).getA();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for A-
					else if(spinn3.equals("A-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text3);
						double gradeValue = ((variables)getApplication()).getAminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for B+
					else if(spinn3.equals("B+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text3);
						double gradeValue = ((variables)getApplication()).getBplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for B
					else if(spinn3.equals("B")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text3);
						double gradeValue = ((variables)getApplication()).getB();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for B-
					else if(spinn3.equals("B-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text3);
						double gradeValue = ((variables)getApplication()).getBminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for C+
					else if(spinn3.equals("C+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text3);
						double gradeValue = ((variables)getApplication()).getCplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for C
					else if(spinn3.equals("C")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text3);
						double gradeValue = ((variables)getApplication()).getC();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for C-
					else if(spinn3.equals("C-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text3);
						double gradeValue = ((variables)getApplication()).getCminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for D+
					else if(spinn3.equals("D+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text3);
						double gradeValue = ((variables)getApplication()).getDplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for D
					else if(spinn3.equals("D")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text3);
						double gradeValue = ((variables)getApplication()).getD();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for D-
					else if(spinn3.equals("D-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text3);
						double gradeValue = ((variables)getApplication()).getDminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for F
					else if(spinn3.equals("F")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text3);
						double gradeValue = ((variables)getApplication()).getF();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
				
//========================Fourth Class===========================================================
					//calculate GPA for class 4 for A+
					if(spinn4.equals("A+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text4);
						double gradeValue = ((variables)getApplication()).getAplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);
					}
					//calculate GPA for class 1 for A
					else if(spinn4.equals("A")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text4);
						double gradeValue = ((variables)getApplication()).getA();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for A-
					else if(spinn4.equals("A-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text4);
						double gradeValue = ((variables)getApplication()).getAminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for B+
					else if(spinn4.equals("B+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text4);
						double gradeValue = ((variables)getApplication()).getBplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for B
					else if(spinn4.equals("B")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text4);
						double gradeValue = ((variables)getApplication()).getB();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for B-
					else if(spinn4.equals("B-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text4);
						double gradeValue = ((variables)getApplication()).getBminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for C+
					else if(spinn4.equals("C+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text4);
						double gradeValue = ((variables)getApplication()).getCplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for C
					else if(spinn4.equals("C")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text4);
						double gradeValue = ((variables)getApplication()).getC();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for C-
					else if(spinn4.equals("C-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text4);
						double gradeValue = ((variables)getApplication()).getCminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for D+
					else if(spinn4.equals("D+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text4);
						double gradeValue = ((variables)getApplication()).getDplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for D
					else if(spinn4.equals("D")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text4);
						double gradeValue = ((variables)getApplication()).getD();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for D-
					else if(spinn4.equals("D-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text4);
						double gradeValue = ((variables)getApplication()).getDminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for F
					else if(spinn4.equals("F")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text4);
						double gradeValue = ((variables)getApplication()).getF();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
				
//============================Fifth Class===============================================================
					//calculate GPA for class 5 for A+
					if(spinn5.equals("A+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text5);
						double gradeValue = ((variables)getApplication()).getAplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);
					}
					//calculate GPA for class 1 for A
					else if(spinn5.equals("A")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text5);
						double gradeValue = ((variables)getApplication()).getA();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for A-
					else if(spinn5.equals("A-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text5);
						double gradeValue = ((variables)getApplication()).getAminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for B+
					else if(spinn5.equals("B+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text5);
						double gradeValue = ((variables)getApplication()).getBplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for B
					else if(spinn5.equals("B")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text5);
						double gradeValue = ((variables)getApplication()).getB();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for B-
					else if(spinn5.equals("B-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text5);
						double gradeValue = ((variables)getApplication()).getBminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for C+
					else if(spinn5.equals("C+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text5);
						double gradeValue = ((variables)getApplication()).getCplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for C
					else if(spinn5.equals("C")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text5);
						double gradeValue = ((variables)getApplication()).getC();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for C-
					else if(spinn5.equals("C-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text5);
						double gradeValue = ((variables)getApplication()).getCminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for D+
					else if(spinn5.equals("D+")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text5);
						double gradeValue = ((variables)getApplication()).getDplus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for D
					else if(spinn5.equals("D")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text5);
						double gradeValue = ((variables)getApplication()).getD();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for D-
					else if(spinn5.equals("D-")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text5);
						double gradeValue = ((variables)getApplication()).getDminus();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
					//calculate GPA for class 1 for F
					else if(spinn5.equals("F")){
						//current semester
						//gradePoint = classCredit * gradeValue
						double classCredit = Double.parseDouble(text5);
						double gradeValue = ((variables)getApplication()).getF();
						double gradePoint = gradeValue * classCredit; //example: 4.00 * 3 credits = 12 grade points
						
						//get Global variables
						double totalCredit = ((variables)getApplication()).getTotalCredits();
						double totalGradePoint =((variables)getApplication()).getTotalGradePoints();
						//add the new ones to the Globals
						totalCredit = totalCredit + classCredit;
						totalGradePoint = totalGradePoint + gradePoint;
						double totalGPA = totalGradePoint / totalCredit;
						//now set the Globals with new values
						((variables)getApplication()).setTotalCredits(totalCredit);
						((variables)getApplication()).setTotalGPA(totalGPA);	
					}
				
		//===================================End Classes=============================================================
					
		
	}
}

package com.spencerdavis.gpa;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class test extends Activity {

	TextView display;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);
		
		display = (TextView)findViewById(R.id.tvTest);
		
		double aplus = ((variables)getApplication()).getAplus();
		double a = ((variables)getApplication()).getA();
		double aminus = ((variables)getApplication()).getAminus();
		
		double bplus = ((variables)getApplication()).getBplus();
		double b = ((variables)getApplication()).getB();
		double bminus = ((variables)getApplication()).getBminus();
		
		double cplus = ((variables)getApplication()).getCplus();
		double c = ((variables)getApplication()).getC();
		double cminus = ((variables)getApplication()).getCminus();
		
		double dplus = ((variables)getApplication()).getDplus();
		double d = ((variables)getApplication()).getD();
		double dminus = ((variables)getApplication()).getDminus();
		
		double f = ((variables)getApplication()).getF();
		
		display.setText("A+: "+ aplus +
				"\nA: "+ a +
				"\nA-: "+aminus +
				"\nB+: "+bplus +
				"\nB: "+ b +
				"\nB-: "+bminus +
				"\nC+: "+cplus +
				"\nC: "+ c +
				"\nC-: "+cminus +
				"\nD+: "+dplus +
				"\nD: "+ d +
				"\nD-: "+dminus +
				"\nF: "+ f );
	}

	
}

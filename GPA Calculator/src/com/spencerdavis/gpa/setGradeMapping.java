package com.spencerdavis.gpa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;


public class setGradeMapping extends Activity{

	Button saveGradeMapping;
	EditText Aplus, A, Aminus;
	EditText Bplus, B, Bminus;
	EditText Cplus, C, Cminus;
	EditText Dplus, D, Dminus;
	EditText F;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grade_mapping);
		
		//wire everthing up
		saveGradeMapping = (Button)findViewById(R.id.bsaveGradeMapping);
		Aplus = (EditText)findViewById(R.id.etAplus);
		A = (EditText)findViewById(R.id.etA);
		Aminus = (EditText)findViewById(R.id.etAminus);
		Bplus = (EditText)findViewById(R.id.etBplus);
		B = (EditText)findViewById(R.id.etB);
		Bminus = (EditText)findViewById(R.id.etBminus);
		Cplus = (EditText)findViewById(R.id.etCplus);
		C = (EditText)findViewById(R.id.etC);
		Cminus = (EditText)findViewById(R.id.etCminus);
		Dplus = (EditText)findViewById(R.id.etDplus);
		D = (EditText)findViewById(R.id.etD);
		Dminus = (EditText)findViewById(R.id.etDminus);
		F = (EditText)findViewById(R.id.etF);
		
		//hide keyboard onLoad
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		
	
		
		saveGradeMapping.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				//this section allows the user to set a different grade map
				//if the user does not enter anything, get the values already
				//set through default constructor and reset.
				//else, parse the value and set it.
				
				if((Aplus.getText().toString().equals(""))){
					((variables)getApplication()).setAplus(4.00);
				}
				else{
					double _Aplus = Double.parseDouble(Aplus.getText().toString());
					((variables)getApplication()).setAplus(_Aplus);
				}
				if((A.getText().toString().equals(""))){
					((variables)getApplication()).setA(4.00);
				}
				else{
					double _A = Double.parseDouble(A.getText().toString());
					((variables)getApplication()).setA(_A);
				}
				if((Aminus.getText().toString().equals(""))){
					((variables)getApplication()).setAminus(3.70);
				}
				else{
					double _Aminus = Double.parseDouble(Aminus.getText().toString());
					((variables)getApplication()).setAminus(_Aminus);
				}
				if((Bplus.getText().toString().equals(""))){
					((variables)getApplication()).setBplus(3.30);
				}
				else{
					double _Bplus = Double.parseDouble(Bplus.getText().toString());
					((variables)getApplication()).setBplus(_Bplus);
				}
				if((B.getText().toString().equals(""))){
					((variables)getApplication()).setB(3.00);
				}
				else{
					double _B = Double.parseDouble(B.getText().toString());
					((variables)getApplication()).setB(_B);
				}
				if((Bminus.getText().toString().equals(""))){
					((variables)getApplication()).setBminus(2.70);
				}
				else{
					double _Bminus = Double.parseDouble(Bminus.getText().toString());
					((variables)getApplication()).setBminus(_Bminus);
				}
				if((Cplus.getText().toString().equals(""))){
					((variables)getApplication()).setCplus(2.30);
				}
				else{
					double _Cplus = Double.parseDouble(Cplus.getText().toString());
					((variables)getApplication()).setCplus(_Cplus);
				}
				if((C.getText().toString().equals(""))){
					((variables)getApplication()).setC(2.00);
				}
				else{
					double _C = Double.parseDouble(C.getText().toString());
					((variables)getApplication()).setC(_C);
				}
				if((Cminus.getText().toString().equals(""))){
					((variables)getApplication()).setCminus(1.70);
				}
				else{
					double _Cminus = Double.parseDouble(Cminus.getText().toString());
					((variables)getApplication()).setCminus(_Cminus);
				}
				if((Dplus.getText().toString().equals(""))){
					((variables)getApplication()).setDplus(1.30);
				}
				else{
					double _Dplus = Double.parseDouble(Dplus.getText().toString());
					((variables)getApplication()).setDplus(_Dplus);
				}
				if((D.getText().toString().equals(""))){
					((variables)getApplication()).setD(1.00);
				}
				else{
					double _D = Double.parseDouble(D.getText().toString());
					((variables)getApplication()).setD(_D);
				}
				if((Dminus.getText().toString().equals(""))){
					((variables)getApplication()).setDminus(0.70);
				}
				else{
					double _Dminus = Double.parseDouble(Dminus.getText().toString());
					((variables)getApplication()).setDminus(_Dminus);
				}
				if((F.getText().toString().equals(""))){
					((variables)getApplication()).setF(0.00);
				}
				else{
					double _F = Double.parseDouble(F.getText().toString());
					((variables)getApplication()).setF(_F);
				}
				
				
				Intent start = new Intent("com.spencerdavis.gpa.START");
				startActivity(start);
			}
		});
		
	}

	
}

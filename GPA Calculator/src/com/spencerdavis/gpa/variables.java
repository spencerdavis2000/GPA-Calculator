/*
 * Spencer Davis
 * cpsc 390
 * */

package com.spencerdavis.gpa;

import android.app.Application;

/*
 * This is where all the Global Variables are kept.  
 * They are needed on most Activity pages 
 * */

public class variables extends Application{			
	
	private double totalGradePoints;
	private double totalCredits;
	private double totalGPA;
	
	private double Aplus;
	private double A;
	private double Aminus;
	private double Bplus;
	private double B;
	private double Bminus;
	private double Cplus;
	private double C;
	private double Cminus;
	private double Dplus;
	private double D;
	private double Dminus;
	private double F;
	
	public variables(){ //default constructor
		this.totalGradePoints = 0.0;
		this.totalCredits = 0.0;
		this.totalGPA = 0.0;
		this.Aplus = 4.00;
		this.A = 4.00;
		this.Aminus = 3.70;
		this.Bplus = 3.30;
		this.B = 3.00;
		this.Bminus = 2.70;
		this.Cplus = 2.30;
		this.C = 2.00;
		this.Cminus = 1.70;
		this.Dplus = 1.30;
		this.D = 1.00;
		this.Dminus = 0.70;
		this.F = 0.00;
	}
	
	//get-------------------------------------------------
	public double getTotalGradePoints(){
		//since the students wont know their grade points, they need to
		//have us set it for them.  However, if they are starting fresh, then 
		//totalGPA * totalCredits will always equal 0 and give problems.
		//so we create this if/else situation for starting fresh or from an entered value
		if(!(totalGPA == 0)){
			return totalCredits * totalGPA;
		}
		else
			return totalGradePoints;
	}
	public double getTotalCredits(){
		return totalCredits;
	}
	public double getTotalGPA(){
		return totalGPA;
	}
	//set--------------------------------------------------
	public void setTotalCredits(double totalCredits){
		this.totalCredits = totalCredits;
	}
	public void setTotalGPA(double totalGPA){
		this.totalGPA = totalGPA;
	}
	//this setTotalGradePoints is used just before each method starts
	//to clear everything to 0 just in case.  It is not used any other time
	public void setTotalGradePoints(double totalGradePoints){
		this.totalGradePoints = totalGradePoints;
	}
//============================================================================
	//Get 
	public double getAplus(){return Aplus;}
	public double getA(){return A;}
	public double getAminus(){return Aminus;}
	public double getBplus(){return Bplus;}
	public double getB(){return B;}
	public double getBminus(){return Bminus;}
	public double getCplus(){return Cplus;}
	public double getC(){return C;}
	public double getCminus(){return Cminus;}
	public double getDplus(){return Dplus;}
	public double getD(){return D;}
	public double getDminus(){return Dminus;}
	public double getF(){return F;}
//================================================================================
	//Set
	public void setAplus(double Aplus){this.Aplus = Aplus;}
	public void setA(double A){this.A = A;}
	public void setAminus(double Aminus){this.Aminus = Aminus;}
	public void setBplus(double Bplus){this.Bplus = Bplus;}
	public void setB(double B){this.B = B;}
	public void setBminus(double Bminus){this.Bminus = Bminus;}
	public void setCplus(double Cplus){this.Cplus = Cplus;}
	public void setC(double C){this.C = C;}
	public void setCminus(double Cminus){this.Cminus = Cminus;}
	public void setDplus(double Dplus){this.Dplus = Dplus;}
	public void setD(double D){this.D = D;}
	public void setDminus(double Dminus){this.Dminus = Dminus;}
	public void setF(double F){this.F = F;}	

}

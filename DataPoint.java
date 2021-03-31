package project1;

public class DataPoint {
	Double f1;
	Double f2;
	String label;
	boolean isTest;
	public DataPoint() {
		this(0, 0, "", true);
		
	}
	//TODO:Create the no-argument constructor and 4 arg constructors, accessors and mutators for the
	//DataPoint class.
	
	public DataPoint(double f1, double f2, String label, boolean isTest) {
		this.f1=f1;
		this.f2=f2;
		this.label = label;
		this.isTest=isTest;
		
	}
	public double getf1Double() {
		return f1;
	}
	public double getf2Double() {
		return f2;
		
	}
	public String getflabel() {
		return label;
	}
	public boolean getisTest() {
		return isTest;
	}
	public void setf1(double val) {
		f1 = val;
	}
	public void setf2(double val) {
		f2=val;
	}
	public void setisTest(boolean val) {
		isTest= val;
	}
	

}

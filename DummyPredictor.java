package project1;

import java.util.ArrayList;

public class DummyPredictor extends Predictor {
	@Override
	ArrayList<DataPoint> readData(String filename) {
		ArrayList<DataPoint> dP = new ArrayList();
		dP.add(new DataPoint(0.5, 0.9, "dataset", false));
		return dP;
	}
		
	@Override
	String test(DataPoint data) {
		return "dataset";
	}
	@Override
	Double getAccuracy(ArrayList<DataPoint> data) {
		return Math.random();
	}
	@Override
	Double getPrecision(ArrayList<DataPoint> data) {
		return Math.random();
	}

}

package project1;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class KNNPredictor1 extends Predictor {
	int l1 = 0;
	int l2 = 0;
	int k;
	ArrayList<DataPoint> dp = new ArrayList();

	public KNNPredictor1(int k) {
		this.k = k;
	}

	@Override
	ArrayList<DataPoint> readData(String filename) throws FileNotFoundException {
		Scanner dataPointS = new Scanner(new File(filename));
		dataPointS.nextLine();
		while (dataPointS.hasNext()) {
			String l = dataPointS.nextLine();
			String[] v = l.split(","); //v represents the value

			boolean numSurvived = Integer.parseInt(v[1]) > 0;
			boolean isT = Math.random() > 0.1;
			if (!isT) {
				if (numSurvived) {
					l1++;
				} else {
					l2++;
				}

			}
			double f1 = !v[5].equals("") ? Double.parseDouble(v[5]) : 0.0;

		    double f2 = v.length > 6 && !v[6].equals("") ? Double.parseDouble(v[6]) : 0.0;

		    DataPoint dataPoint1 = new DataPoint(f1, f2,numSurvived ? "1" : "0", isT);

			
			dp.add(dataPoint1);
		}
		System.out.println("" + l2 + " people didn't survive");
		System.out.println("" + l1 + " people survived");
		return dp;
	}
	@Override
	Double getPrecision(ArrayList<DataPoint> data) {
		double truePositive = 0;
		double falsePositive = 0;
		double falseNegative = 0;
		double trueNegative = 0;
		for(DataPoint p: data) {
			String label = test(p);
			if(label.equals("1")&& p.label.equals("1")) {
				truePositive++;
			} else if(label.equals("1") && p.label.equals("0")) {
				falsePositive++;	
			} else if(label.equals("0") && p.label.equals("1")) {
				falseNegative++;	
			} else if(label.equals("0") && p.label.equals("0")) {
				trueNegative++;
			}
		}
		return truePositive  / (truePositive + falseNegative);
	}
	private double getDistance(DataPoint d1, DataPoint d2) {
		return Math.sqrt(Math.pow(d2.f1 - d1.f1, 2) + Math.pow(d2.f2 - d1.f2, 2));
	}
	@Override
	Double getAccuracy(ArrayList<DataPoint> data) {
		double truePositive = 0;
		double falsePositive = 0;
		double falseNegative = 0;
		double trueNegative = 0;
		for(DataPoint p: data) {
			String label = test(p);
			if(label.equals("1")&& p.label.equals("1")) {
				truePositive++;		
			} else if(label.equals("1")&& p.label.equals("0")) {
				falsePositive++;			
			} else if(label.equals("0")&& p.label.equals("1")) {
				falseNegative++;			
			} else if(label.equals("0")&& p.label.equals("0")) {
				trueNegative++;			
			}
		}
		return (truePositive + trueNegative) / (truePositive + trueNegative + falsePositive + falseNegative);
	}

	@Override
	String test(DataPoint dataP) {
	    Double[][] distance = new Double[l1+l2][2];
	    int training = 0;
		for(DataPoint d: dp) {
			if(!d.isTest) {
				distance [training][0] = getDistance(dataP, d);
				distance [training][1] = d.label.equals("1")? 1.0 : 0.0;
				training++;
			}
		}
		java.util.Arrays.sort(distance, new java.util.Comparator<Double[]>() {
		      public int compare(Double[] a, Double[] b) {
		        return a[0].compareTo(b[0]);
		      }
		    });
		int countForSurviver = 0;
		int countForNonSurvivers = 0;
		for(int i = 0; i < k; i++) {
			if(distance[i][1] == 1.0) countForSurviver++; else countForNonSurvivers++;
		}
		return countForSurviver > countForNonSurvivers ? "1" : "0";
	}

}


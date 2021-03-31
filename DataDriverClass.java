package project1;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JFrame;
import java.io.BufferedWriter;
import javax.swing.JPanel;
import java.io.FileWriter;
import javax.swing.JLabel;


public class DataDriverClass {
	public static void main(String[] args) throws IOException {
		int data1Count = 10;
		int data2Count = 10;
		ArrayList<DataPoint> data1 = generateRandomDataPoints(data1Count);
		ArrayList<DataPoint> data2 = generateRandomDataPoints(data2Count);
		writeDataPointsToFile(data1, "data1.csv");
		//stores the generated data points in a csv file
		writeDataPointsToFile(data2, "data2.csv");
		Predictor r = new DummyPredictor();
		//read data
		r.readData("data2.csv");
		
		double acc = r.getAccuracy(data2);
		double prec = r.getPrecision(data2);
		//TODO:  Display the precision and accuracy in a JFrame. Be creative here with your labels and
		//format for printing them. We will use this JFrame again and again for next set of
		//milestones.
		
		JFrame frm = new JFrame("Project Part 1");
		frm.setResizable(true);
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS));
		JLabel accLl = new JLabel("The accuracy is: "+ acc);
        p1.add(accLl);
        p1.add(Box.createGlue());
        JLabel pLabe = new JLabel("The precision is: "+ prec);
        p1.add(pLabe);
        frm.add(p1);
		
	}
	public static void writeDataPointsToFile(ArrayList<DataPoint> dataPoints, String fileName)
			throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		for(DataPoint point: dataPoints) {
		    writer.append(""+ point.f1+","+point.f2+","+point.label+","+point.isTest+"\n");
		    
		}
		writer.close();
	}
	static ArrayList<DataPoint> generateRandomDataPoints(int dataC){
		ArrayList<DataPoint> dP = new ArrayList();
		for(int i = 0; i < dataC;  i++) {
			String label;
			if(Math.random()>0.8) {
				label = "This works";
			} else {
				label= "This also works";
			}
			dP.add(new DataPoint(
					Math.random(),
					Math.random(),
					label,
					Math.random()>0.8
					));
		}
		return dP;
		
	}

	
}
	
		

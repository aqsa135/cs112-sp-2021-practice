package project1;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProjectPart2Driver {

	
	public static void main(String[] args) throws FileNotFoundException {
		KNNPredictor numPeople = new KNNPredictor(3);
		ArrayList<DataPoint> data = numPeople.readData("C:\\Users\\noree\\eclipse-workspace\\Cs112Lectures\\Project1\\titanic.csv");
		double numPrecision = numPeople.getPrecision(data);
		System.out.println(numPrecision);
		double levelOfAccuracy = numPeople.getAccuracy(data);
		System.out.println(levelOfAccuracy);
		Graph1 gra = new Graph1(3, "C:\\Users\\noree\\eclipse-workspace\\Cs112Lectures\\Project1\\titanic.csv");

		
		JFrame frame = new JFrame("Titanic Predictor");
		
	    frame.setResizable(true);
	    frame.setVisible(true);
	    frame.setLocationRelativeTo(null);
	    
	    JPanel p1 = new JPanel();
	    p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS));
	    
	    JLabel aLabel = new JLabel("The accuracy is: "+ levelOfAccuracy);
        p1.add(aLabel);
        p1.add(Box.createGlue());
        
        JLabel pLabel = new JLabel("The precisionis: "+ numPrecision);
        p1.add(pLabel);
	    frame.add(p1);
	    frame.add(gra);

	}

}

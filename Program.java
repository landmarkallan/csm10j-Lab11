import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

public class Program extends JFrame
{	
	private JLabel gradeL, weightL;
	private JTextField gradeTF1, gradeTF2, gradeTF3, gradeTF4, weightTF1, weightTF2, weightTF3, weightTF4, calculateTF;
	private JButton calculateB;
	
	private CalculateButtonListener cbListener;
	
	public Program()
	{
		this.setTitle("Grade Ap");
		this.setSize(400,600);
		this.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void setup()
	{		
		gradeL = new JLabel("Grade %", SwingConstants.CENTER);
		weightL = new JLabel("Weight", SwingConstants.CENTER);
		
		gradeTF1 = new JTextField(10);
		weightTF1 = new JTextField(10);
		gradeTF2 = new JTextField(10);
		weightTF2 = new JTextField(10);
		gradeTF3 = new JTextField(10);
		weightTF3 = new JTextField(10);
		gradeTF4 = new JTextField(10);
		weightTF4 = new JTextField(10);
		calculateTF = new JTextField(10);
		
		this.gradeTF1.setEditable(true);
		this.weightTF1.setEditable(true);
		this.gradeTF2.setEditable(true);
		this.weightTF2.setEditable(true);
		this.gradeTF3.setEditable(true);
		this.weightTF3.setEditable(true);
		this.gradeTF4.setEditable(true);
		this.weightTF4.setEditable(true);
		this.calculateTF.setEditable(false);
		
		calculateB = new JButton("Calculate");
		
		this.cbListener = new CalculateButtonListener();
		this.calculateB.addActionListener(cbListener);
	
		Container pane = this.getContentPane();
		
		pane.setLayout(new GridLayout(6,2));
		
		pane.add(gradeL);
		pane.add(weightL);
		pane.add(gradeTF1);
		pane.add(weightTF1);
		pane.add(gradeTF2);
		pane.add(weightTF2);
		pane.add(gradeTF3);
		pane.add(weightTF3);
		pane.add(gradeTF4);
		pane.add(weightTF4);
		pane.add(calculateB);
		pane.add(calculateTF);
	}
	
	private class CalculateButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				double grade1, grade2, grade3, grade4, weight1, weight2, weight3, weight4, weightedAverage;
			
				grade1 = Double.parseDouble(gradeTF1.getText());
				grade2 = Double.parseDouble(gradeTF2.getText());
				grade3 = Double.parseDouble(gradeTF3.getText());
				grade4 = Double.parseDouble(gradeTF4.getText());
			
				weight1 = Double.parseDouble(weightTF1.getText());
				weight2 = Double.parseDouble(weightTF2.getText());
				weight3 = Double.parseDouble(weightTF3.getText());
				weight4 = Double.parseDouble(weightTF4.getText());
			
				weightedAverage = grade1 * weight1 + grade2 * weight2 + grade3 * weight3 + grade4 * weight4;
				
				calculateTF.setText(String.format("%.2f", weightedAverage));
			}
			catch(Exception ex)
			{
				calculateTF.setText("N/A");
			}
		}
	}
	
	public static void main(String[] args)
	{
		Program p = new Program();
		p.setup();
		p.setSize(200,300);
		p.setVisible(true);
	}
}

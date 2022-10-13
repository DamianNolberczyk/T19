package ej2;

import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Calcuradora extends JFrame {

	private JPanel contentPane;
	private JTextField num1;
	private JTextField num2;
	private JTextField result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calcuradora frame = new Calcuradora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calcuradora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		num1 = new JTextField();
		num1.setBounds(112, 41, 86, 20);
		contentPane.add(num1);
		num1.setColumns(10);

		num2 = new JTextField();
		num2.setBounds(211, 41, 86, 20);
		contentPane.add(num2);
		num2.setColumns(10);

		result = new JTextField();
		result.setBounds(158, 85, 86, 20);
		contentPane.add(result);
		result.setColumns(10);

		JButton btnAddition = new JButton("Addition");
		btnAddition.setBounds(10, 158, 89, 23);
		contentPane.add(btnAddition);

		JButton btnSubtraction  = new JButton("Subtraction ");
		btnSubtraction.setBounds(109, 158, 89, 23);
		contentPane.add(btnSubtraction);

		JButton btnDivision  = new JButton("Division ");
		btnDivision.setBounds(208, 158, 89, 23);
		contentPane.add(btnDivision);

		JButton btnMultiplication  = new JButton("Multiplication ");
		btnMultiplication.setBounds(307, 158, 89, 23);
		contentPane.add(btnMultiplication);


		btnAddition.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double number1 = Double.parseDouble(num1.getText());
				double number2 = Double.parseDouble(num2.getText());
				
				double addition = number1 + number2;
				String text = Double.toString(addition);
				result.setText(text);
			}
		});
		
		btnSubtraction.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double number1 = Double.parseDouble(num1.getText());
				double number2 = Double.parseDouble(num2.getText());
				
				double subtraction = number1 - number2;
				String text = Double.toString(subtraction);
				result.setText(text);
			}
		});
		
		btnMultiplication.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double number1 = Double.parseDouble(num1.getText());
				double number2 = Double.parseDouble(num2.getText());
				
				double multiplication = number1 * number2;
				String text = Double.toString(multiplication);
				result.setText(text);
			}
		});
		
		btnDivision.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				double number1 = Double.parseDouble(num1.getText());
				double number2 = Double.parseDouble(num2.getText());
				
				double division = number1 / number2;
				String text = Double.toString(division);
				result.setText(text);
			}
		});
	}
}

 package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class VistaCrud extends VistaMenu {
	public static int optionCrud;
	static JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCrud frame = new VistaCrud();
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
	public VistaCrud() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("Add Part");
		btnAdd.setBounds(162, 34, 110, 23);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optionCrud = 1;
				
			}
		});
		
		JButton btnSearchBy = new JButton("Search by id");
		btnSearchBy.setBounds(162, 68, 110, 23);
		contentPane.add(btnSearchBy);
		btnSearchBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optionCrud = 2;
				
			}
		});
		
		JButton btnList = new JButton("Llist Table");
		btnList.setBounds(162, 102, 110, 23);
		contentPane.add(btnList);
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optionCrud = 3;
				
			}
		});
		
		JButton btnModify = new JButton("Modify Part");
		btnModify.setBounds(162, 136, 110, 23);
		contentPane.add(btnModify);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optionCrud = 4;
				
			}
		});
		
		JButton btnDeletePart = new JButton("Delete Part");
		btnDeletePart.setBounds(162, 170, 110, 23);
		contentPane.add(btnDeletePart);
		btnDeletePart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optionCrud = 5;
				
			}
		});
		
	}
		public static int menuCrud() {
			return optionCrud;
		}
}

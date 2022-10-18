package vista;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JButton;


public class VistaMenu extends JFrame {
	public static int option;
	JPanel contentPane;
	private static Component add;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaMenu frame = new VistaMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaMenu() {
		/**
		 * Create the frame.
		 */

		JButton btnInicialize = new JButton("Inicialize DB");
		JButton btnInsert = new JButton("Insert date automatic");
		JButton btnDelete = new JButton("Delete Table");
		JButton btnCrud = new JButton("CRUD");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);


		btnInicialize.setBounds(148, 22, 137, 23);
		contentPane.add(btnInicialize);
		btnInicialize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				option = 1;
				JOptionPane.showMessageDialog(null, option);
			}
		});

		btnInsert.setBounds(148, 56, 137, 23);
		contentPane.add(btnInsert);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				option = 2;

			}
		});


		btnDelete.setBounds(148, 90, 137, 23);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				option = 3;

			}
		});

		btnCrud.setBounds(148, 126, 137, 23);
		contentPane.add(btnCrud);
		btnCrud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaCrud.main(null);

			}
		});

	}
	
	// Methode to show message
	public static void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	// Method to delete table 
	public static boolean askToDelete(String messege) {
		String ask = JOptionPane.showInputDialog(messege);
		if (ask.equalsIgnoreCase("YES") || ask.equalsIgnoreCase("Y")) {
			return true;
		} else {
			return false;
		}
	}

	
	// Asking number
	public static String askNum() {
		String num = JOptionPane.showInputDialog(null);

		return num;
	}
	// Asking String 
	public static String askString() {
		String string = JOptionPane.showInputDialog("Insert name");

		return string;
	}

	// Show menu
	public static int menuPrincipal() {		
		return option;
	}

	// Method that print table
	public static void printTabla(TableModel table) {
		JTable jtable = new JTable(table);
		jtable.add(new JScrollPane(jtable));
	}
}

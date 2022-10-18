package controlador;

import vista.VistaCrud;
import vista.VistaMenu;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.modelo;
public class controlador {

	// instantiate our view interface
	VistaMenu vista;
	
	// instantiate our model
	modelo modelo = new modelo();


	/** Constrcutor de clase
	 * @param vistaMenu Instancia de clase interfaz
	 */
	public controlador(VistaMenu vistaMenu )
	{
		this.vista = vistaMenu;
	}

	public void iniciar() throws SQLException {
		// Function to get connection
		modelo.getConexion();
		VistaMenu.main(null);;
		int option = VistaMenu.option;
		int optionCrud = VistaCrud.optionCrud;
		do {
			// Function that ask user about what option he select
			switch (option) {
			case 1: // Initialize table
				// Call for interfaze functin to print table 
				// We will pass it model function to read table from db
				modelo.deleteTable();
				if (modelo.deleteTable() == true) {
					VistaMenu.showMessage("Table has been deleted");
				} else {
					VistaMenu.showMessage("Table has not been deleted");
				}
				modelo.createTable();
				if (modelo.createTable() == true) {
					VistaMenu.showMessage("Table has been created");
				} else {
					VistaMenu.showMessage("Table has not been created");
				}
				break;
			case 2: // Insert Data
				modelo.insertDataAuto();
				if (modelo.insertDataAuto() == true) {
					VistaMenu.showMessage("Data has been inserted correctly");
				} else {
					VistaMenu.showMessage("Data has not been inserted correctly");
				}
				break;
			case 3: // Delete Table
				if (VistaMenu.askToDelete("Are you sure you want to delete this table?") == true) {
					modelo.deleteTable();
					VistaMenu.showMessage("Table has been deleted");
				} else {
					VistaMenu.showMessage("Table has not been deleted");
				}
				break;
			case 4: // Crud menu
				do {
					switch (optionCrud) {
					case 1: // Insert data in table piezas
						VistaMenu.showMessage("Insert code and name of part that you want to create");
						if(modelo.insertData(VistaMenu.askNum(), VistaMenu.askString()) == true ) {
							VistaMenu.showMessage("Part has been inserted correctly");
						} else {
							VistaMenu.showMessage("Part has not been inserted");
						}
						break;
					case 2: // Search data by id
						VistaMenu.showMessage("Insert code to search part by code id:");
						//VistaMenu.printTabla(modelo.searchById(VistaMenu.askNum()));
					
						break;
					case 3: // Llist al table piezas data
						VistaMenu.printTabla(modelo.getTablaPiezas());
						JOptionPane.showMessageDialog(null, "HAs entrado");
						
						break;
					case 4: // Modify part
						VistaMenu.showMessage("To modified part insert code and name that you want to put:");
						if(modelo.modifyPart(VistaMenu.askNum(), VistaMenu.askString()) == true) {
							VistaMenu.showMessage("Part has been modified correctly");
						} else {
							VistaMenu.showMessage("Part has not been modified");
						}
					;
						break;
					case 5: // Delete part
						VistaMenu.showMessage("Insert code to delte part with that code:");
						if(modelo.deletePart(VistaMenu.askNum()) == true) {
							VistaMenu.showMessage("Part has been deleted"); 
						} else {
							VistaMenu.showMessage("Part has been not deleted");
						}
						break;
					default:
						break;
					}
				} while (VistaCrud.optionCrud != 6);
			default:
				break;
			}
		} while (VistaMenu.option != 5);
		VistaMenu.showMessage("Good Bye :)");


	}


}

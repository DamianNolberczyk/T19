package controlador;

import java.sql.SQLException;

import vista.VistaMenu;


public class Main {

	public static void main(String[] args) throws SQLException {
		
		// Start the program
		 new controlador( new VistaMenu() ).iniciar() ;
	}

}

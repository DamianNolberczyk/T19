package modelo;

import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class modelo extends database {

	// Method to show the table 
	public static DefaultTableModel getTablaPiezas()
	{
		DefaultTableModel tablemodel = new DefaultTableModel();
		int registros = 0;
		String[] columns = {"Codigo","Nombre"};
		// We obtain the amount of data stored in db so then we can creat array and store all data from db
		try{
			PreparedStatement pstm = database.getConexion().prepareStatement( "SELECT count(*) as total FROM piezas");
			ResultSet res = pstm.executeQuery();
			res.next();
			registros = res.getInt("total");
			res.close();
		}catch(SQLException e){

		}
		//We create array with fil amount of all data and col with columns that we have in db
		Object[][] data = new String[registros][2];
		try{
			//Realize the sql consult to save all data in Array Data
			PreparedStatement pstm = database.getConexion().prepareStatement("SELECT * FROM piezas");
			ResultSet res = pstm.executeQuery();
			int i=0;
			while(res.next()){
				data[i][0] = res.getString("codigo");
				data[i][1] = res.getString("nombre");
				i++;
			}
			res.close();  
			tablemodel.setDataVector(data, columns);
		}catch(SQLException e){

		}
		return tablemodel;
	}

	// Method to create table
	public boolean createTable() throws SQLException {

		// Table does not exists
		try {
			Statement st = database.getConexion().createStatement();// It allows SQL comands
			st.executeUpdate(
					"CREATE TABLE Suministra (\r\n"
							+ "    CodigoPieza INT,\r\n"
							+ "    idProveedor CHAR(4),\r\n"
							+ "    Precio INT,\r\n"
							+ "    PRIMARY KEY(CodigoPieza,idProveedor),\r\n"
							+ "    FOREIGN KEY (CodigoPieza) REFERENCES Piezas(Codigo),\r\n"
							+ "    FOREIGN KEY (idProveedor) REFERENCES Proveedores(id)\r\n"
							+ ")");
			return false;
		} catch (SQLException e) {
			return true;
		}
	}

	// Method that delete table Suministra
	public boolean deleteTable() throws SQLException  {
		try {
			Statement st = getConexion().createStatement();
			st.executeUpdate("DROP TABLE Suministra");
			return false;
		} catch (SQLException e) {
			return true;
		}
	}

	// Instert information inside table
	public boolean insertData(String codigoPieza, String nombre) {
		//Se arma la consulta
		String q=" INSERT INTO Piezas ( Codigo , Nombre) "
				+ "VALUES ( '" + codigoPieza + "','" + nombre + "')";
		//se ejecuta la consulta
		try {
			PreparedStatement pstm = database.getConexion().prepareStatement(q);
			pstm.execute();
			pstm.close();
			return true;
		}catch(SQLException e){
			System.err.println( e.getMessage() );
		}
		return false;
	}

	// Search by id 
	public String[][] searchById(String codigo)
	{
		int registros = 0;
		String[] columNames = {"Codigo","Nombre"};
		// We obtain the amount of data stored in db so then we can creat array and store all data from db
		try{
			PreparedStatement pstm = database.getConexion().prepareStatement("SELECT count(*) as total FROM piezas WHERE Codigo="+ codigo + ";");
			ResultSet res = pstm.executeQuery();
			res.next();
			registros = res.getInt("total");
			res.close();
		}catch(SQLException e){

		}
		//We create array with fil amount of all data and col with columns that we have in db
		String[][] data = new String[registros][2];
		try{
			//Realize the sql consult to save all data in Array Data
			PreparedStatement pstm = database.getConexion().prepareStatement("SELECT * FROM piezas WHERE Codigo="+ codigo + ";");
			ResultSet res = pstm.executeQuery();
			int i=0;
			while(res.next()){
				data[i][0] = res.getString("codigo");
				data[i][1] = res.getString("nombre");
				i++;
			}
			res.close();  
		}catch(SQLException e){

		}
		return data;

	}
	// Method to insert data into table suministra
	public boolean insertDataAuto() throws SQLException {

		int codigoPieza[] = {1,2,3,4,5};
		char idProveedor[] = {'1','2','3','4','5'};
		int precio[] = {200, 2222, 3333, 4444, 8782};
		try {
			Statement st = database.getConexion().createStatement();
			for (int i = 0; i < codigoPieza.length; i++) {
				String q = "INSERT INTO suministra (CodigoPieza, idProveedor, Precio) VALUES (" + codigoPieza[i] + ",'" + idProveedor[i] + "'," + precio[i] + ");";
				st.executeUpdate(q);
			}
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	// Method to delete part 
	public boolean deletePart(String id) {

		String q="DELETE FROM piezas WHERE Codigo="+id;
		try {
			PreparedStatement pstm=database.getConexion().prepareStatement(q);
			pstm.execute();
			pstm.close();
			return true;
		} catch (SQLException e) {

			return false;
		}


	}
	// Method to Modify part
	public boolean modifyPart(String id, String nombre) {
	
		String q="UPDATE piezas SET Nombre='"+nombre+"' WHERE Codigo="+id;
		try {
			PreparedStatement pstm = database.getConexion().prepareStatement(q);
			pstm.execute();
			pstm.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
}











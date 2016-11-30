package com.dao.inventory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.inventory.data.MySqlHelper;
import com.inventory.dto.Inventory;
import com.mysql.jdbc.CallableStatement;

public class InventoryData 
{
	public List<Inventory> GetInventory() throws SQLException, ParseException
	{
		List<Inventory> lista = new ArrayList<Inventory>();
		MySqlHelper db = new MySqlHelper();
		String query = "{CALL sp_get_inventory_active}";
		CallableStatement stmt = null;
		try {
			stmt = (CallableStatement) db.connect().prepareCall(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		ResultSet rs = stmt.executeQuery();
        while (rs.next()) 
        {
        	Inventory inventory = new Inventory();
        	inventory.setInventario(rs.getString(2).toString()); 
        	inventory.setIdInventario(Integer.parseInt(rs.getString(1).toString()));
        	inventory.setEstado(Integer.parseInt(rs.getString(4).toString()));
        	inventory.setFecha(rs.getString(3).toString());
        	inventory.setUsuario(rs.getString(5).toString());
			lista.add(inventory);
        }
		
		return lista;
	}

}

package com.dao.inventory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inventory.data.MySqlHelper;
import com.inventory.dto.Usuario;
import com.mysql.jdbc.CallableStatement;


public class UserData 
{
	public List<Usuario> Login(String rut,String clave) throws SQLException
	{
		List<Usuario> lista = new ArrayList<Usuario>();
		MySqlHelper db = new MySqlHelper();
		String query = "{CALL sp_get_UserValid(?,?)}";
		CallableStatement stmt = (CallableStatement) db.connect().prepareCall(query);
		stmt.setString(1, rut);
		stmt.setString(2, clave);
		ResultSet rs = stmt.executeQuery();
        while (rs.next()) 
        {
			 Usuario usuario = new Usuario();
			 usuario.setRut(rs.getString(1).toString()); 
			 usuario.setNombre(rs.getString(2).toString());
			 usuario.setApellidos(rs.getString(3).toString());
			 usuario.setClave(rs.getString(4).toString());
			 lista.add(usuario);
        }
		return lista;
	}
}

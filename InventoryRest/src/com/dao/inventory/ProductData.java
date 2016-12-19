package com.dao.inventory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import com.inventory.data.MySqlHelper;
import com.inventory.dto.Product;
import com.mysql.jdbc.CallableStatement;

public class ProductData 
{
	public List<Product> GetAllProduct() throws SQLException
	{
		List<Product> lista = new ArrayList<Product>();
		MySqlHelper db = new MySqlHelper();
		String query = "{CALL SP_GET_ALL_PRODUCT()}";
		CallableStatement stmt = (CallableStatement) db.connect().prepareCall(query);
		ResultSet rs = stmt.executeQuery();
        while (rs.next()) 
        {
        	Product producto = new Product();
			 producto.setCod_produto(rs.getString(1).toString()); 
			 //producto.setStock(rs.getString(2).toString());
			 producto.setNombre(rs.getString(2).toString());
			 lista.add(producto);
        }
		return lista;
	}
	
	public int CreateProduct(Product product)throws SQLException
	{
		int status = 0;
		MySqlHelper db = new MySqlHelper();
		String query = "{CALL SP_ADD_PRODUCT(?,?,?,?,?,?,?,?,?)}";
		CallableStatement stmt = (CallableStatement) db.connect().prepareCall(query);
		stmt.setString(1, product.getCod_produto());
		stmt.setString(2, product.getNombre());
		stmt.setInt(3, product.getProveedor_id());
		stmt.setInt(4, product.getEstado());
		stmt.setString(5, product.getFecha_creacion());
		stmt.setString(6, product.getUsu_creacion());
		stmt.setString(7, product.getQr_cod());
		stmt.setDouble(8, product.getPrecio());
		stmt.registerOutParameter(9, Types.INTEGER);
		try
		{
			stmt.executeUpdate();
			status =  stmt.getInt(9);
		}catch(SQLException e) {
		    e.printStackTrace();
		}
		return status;
	}
}

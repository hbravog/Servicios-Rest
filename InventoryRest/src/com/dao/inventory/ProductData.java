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
		stmt.setString(4, product.getFecha_creacion());
		stmt.setString(5, product.getUsu_creacion());
		stmt.setString(6, product.getQr_cod());
		stmt.setDouble(7, product.getPrecio());
		stmt.setInt(8, product.getCategoria_id());
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
	

	
	public List<Product> GetProductByCode(String item) throws SQLException
	{
		List<Product> lista = new ArrayList<Product>();
		Product prod = new Product();
		MySqlHelper db = new MySqlHelper();
		String query = "CALL SP_GET_PRODUCT_BY_CODE(?)";
		CallableStatement stmt = (CallableStatement) db.connect().prepareCall(query);
		stmt.setString(1, item);
		ResultSet rs = stmt.executeQuery();
        while (rs.next()) 
        {
        	prod.setCod_produto(rs.getString(1).toString()); 
			prod.setNombre(rs.getString(2).toString());
			prod.setProveedor_id(rs.getInt(3));
			prod.setFecha_creacion(rs.getString(4));
			lista.add(prod);
        }
		return lista;
	}
}

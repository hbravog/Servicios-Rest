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
	
	public int AdjustItemQty(Product product)
	{
		MySqlHelper db = new MySqlHelper();
		String query = "{CALL SP_UPD_PRODUCTQTY(?,?)}";
		CallableStatement stmt;
		try {
			stmt = (CallableStatement) db.connect().prepareCall(query);
			stmt.setString(1, product.getCod_produto());
			stmt.setString(2, product.getLocation());
			stmt.setString(3,product.getWarehouse());
			stmt.setInt(4,product.getQty());
			stmt.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 1;
	}
}

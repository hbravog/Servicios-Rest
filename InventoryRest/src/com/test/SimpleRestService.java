package com.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dao.inventory.AvailablePhysicalData;
import com.dao.inventory.CategoryData;
import com.dao.inventory.LocationData;
import com.dao.inventory.ProductData;
import com.dao.inventory.ProviderData;
import com.dao.inventory.UserData;
import com.dao.inventory.WareHouseData;
import com.inventory.dto.Product;
import com.inventory.dto.Location;


@Path("/service")
public class SimpleRestService {

	@GET
	@Path("/getValidaUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getValidaUsuario(@QueryParam("p1") String p1,@QueryParam("p2") String p2 ) throws SQLException 
	{
		String rut = p1.replace("\"", "");
		String pass = p2.replace("\"", "");
		UserData user = new UserData();
		return Response.ok(user.Login(rut,pass)).build();
	}
	
	@GET
	@Path("/getAllProduct")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProduct() throws SQLException, ParseException 
	{
		ProductData product = new ProductData();
		return Response.ok(product.GetAllProduct()).build();
	}

	@GET
	@Path("/getProductByCode")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductByCode(@QueryParam("p1") String item) throws SQLException, ParseException
	
	{
		//String cod = item.replace("\"", "");
		ProductData product = new ProductData();
		return Response.ok(product.GetProductByCode(item)).build();
	}
	
	@GET
	@Path("/getAllCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCatetory() throws SQLException ,ParseException
	{
		CategoryData category = new CategoryData();
		return Response.ok(category.GetAllCategory()).build();
	}
	
	@GET
	@Path("/getAllProvider")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProvider() throws SQLException, ParseException
	{
		ProviderData provider = new ProviderData();
		return Response.ok(provider.GetAllProviders()).build();
	}
	
	@GET
	@Path("/AddProduct")
	@Produces(MediaType.TEXT_PLAIN)
	public String AddProduct(@QueryParam("p1") String cod,@QueryParam("p2") String item,@QueryParam("p3") int prov,@QueryParam("p4") String usuario,@QueryParam("p5") String qrcode,@QueryParam("p6") String precio,@QueryParam("p7") int id_categoria) throws SQLException, ParseException 
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		int response = 0;
		Product dto = new Product();
		ProductData product = new ProductData();
		dto.setCod_produto(cod);
		dto.setNombre(item);
		dto.setProveedor_id(prov);
		dto.setFecha_creacion(dateFormat.format(date).toString());
		dto.setUsu_creacion(usuario);
		dto.setQr_cod(qrcode);
		dto.setPrecio(Double.parseDouble(precio));
		dto.setCategoria_id(id_categoria);
		response = product.CreateProduct(dto);
		return String.valueOf(response);
	}
	
	@GET
	@Path("/AdjustItemQty")
	@Produces(MediaType.TEXT_PLAIN)
	public String AdjustItemQty(@QueryParam("p1") String item,@QueryParam("p2") String qty,@QueryParam("p3") String warehouse,@QueryParam("p4") String location )
	{
		int response = 0;
		Product dto = new Product();
		AvailablePhysicalData data = new AvailablePhysicalData();
		dto.setCod_produto(item);
		dto.setQty(Integer.parseInt(qty));
		dto.setLocation(location);
		dto.setWarehouse(warehouse);
		response = data.AdjustItemQty(dto);
		return String.valueOf(response); 
	}
	
	
	@GET
	@Path("/getAllLocation")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllLocation() throws SQLException, ParseException
	{
		LocationData data = new LocationData();
		return Response.ok(data.GetAllLocation()).build();
	}
	
	@GET
	@Path("/getAllWarehouse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllWarehouse() throws SQLException, ParseException
	{
		WareHouseData data = new WareHouseData();
		return Response.ok(data.GetAllWareHouse()).build();
	}
	
	@GET
	@Path("/AddLocation")
	@Produces(MediaType.TEXT_PLAIN)
	public String AddLocation(@QueryParam("p1") String location,@QueryParam("p2") String warehouse)
	{
		int response = 0;
		Location dto = new Location();
		LocationData data = new LocationData();
		dto.setLocation(location);
		dto.setWarehouse(Integer.parseInt(warehouse));
		response = data.AddLocation(dto);
		return String.valueOf(response); 
	}
}


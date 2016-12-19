package com.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.sql.SQLException;
import java.text.ParseException;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.dao.inventory.ProductData;
import com.dao.inventory.UserData;
import com.inventory.dto.Product;


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
	@Path("/AddProduct")
	@Produces(MediaType.TEXT_PLAIN)
	public String AddProduct(@QueryParam("p1") String cod,@QueryParam("p2") String item,@QueryParam("p3") int prov,@QueryParam("p4") int estado,@QueryParam("p5") String fecha_crea,@QueryParam("p6") String usuario,@QueryParam("p7") String qrcode,@QueryParam("p8") String precio) throws SQLException, ParseException 
	{
		int response = 0;
		
		Product dto = new Product();
		ProductData product = new ProductData();
		dto.setCod_produto(cod);
		dto.setNombre(item);
		dto.setProveedor_id(prov);
		dto.setEstado(estado);
		dto.setFecha_creacion(fecha_crea);
		dto.setUsu_creacion(usuario);
		dto.setQr_cod(qrcode);
		dto.setPrecio(Double.parseDouble(precio));
		
		//return Response.ok(product.CreateProduct(dto)).build();
		//return product.CreateProduct(dto);
		 response = product.CreateProduct(dto);
		 return String.valueOf(response);
	}
}


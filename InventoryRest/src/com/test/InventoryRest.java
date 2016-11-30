package com.test;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import java.sql.SQLException;
import java.text.ParseException;

import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dao.inventory.InventoryData;

@Path("/service2")
public class InventoryRest {
	
	@GET
	@Path("/getInventoryActive")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getInventoryActive() throws SQLException, ParseException 
	{
		InventoryData inventory = new  InventoryData();
		return Response.ok(inventory.GetInventory()).build();
	}

	
}
 
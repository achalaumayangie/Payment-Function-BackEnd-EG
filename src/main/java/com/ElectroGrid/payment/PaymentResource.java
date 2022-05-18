package com.ElectroGrid.payment;

import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

//get method

@Path("Payments")
public class PaymentResource 
{
	
	PaymentRepository repo = new PaymentRepository();
	@GET
	
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List <Payment> getPayments() 
	{
		System.out.println("getPayment called....");
		return repo.getPayments();	
	}
	
	@GET
	@Path("Payment/{id}")
	
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Payment getPayment(@PathParam("id")int id)
	{
		return repo.getPayment(id);
	}
	
//post method
	@POST
	@Path("Payment")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Payment createPayment(Payment p1) {
		
		System.out.println(p1);
		repo.create(p1);
		return p1;
	}
	
//put method	
	@PUT
	@Path("Payment")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Payment updatePayment(Payment p1) {
		
		System.out.println(p1);
		if(repo.getPayment(p1.getId()).getId()==0) {
			repo.create(p1);
		}
		else{
			repo.update(p1);
		}
		return p1;
	}

//delete method	
	@DELETE
	@Path("Payment/{id}")
	public Payment deletePayment(@PathParam("id")int id) {
		Payment p = repo.getPayment(id);
		if(p.getId()!=0)
			repo.delete(id);
		
		return p;
	}
}


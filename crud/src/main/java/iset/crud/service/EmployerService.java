package iset.crud.service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import iset.crud.dao.EmployerDao;
import iset.crud.model.Employer;

@Path("/crud")
public class EmployerService {
	
	EmployerDao service = new EmployerDao();
	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Employer addUser(Employer emp) {
		return service.insertEmployer(emp);
	}
	
	@Path("/getEmp")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Employer>  getUser() throws SQLException {
		return service.getEmps();
	}
	
	
	@Path("/empById/{id}") 
	 @GET 
	 @Produces(MediaType.APPLICATION_JSON) 
	 public ArrayList<Employer>  getUser(@PathParam("id") int id) throws 
	SQLException { 
	  return service.getEmpById(id); 
	   
	 }
	
	@Path("/updateEmp") 
	 @PUT 
	 @Consumes(MediaType.APPLICATION_JSON) 
	 public Employer updateUser(Employer emp) { 
	   return service.updateEmp(emp); 
	   
	 }
	
	
	@Path("/deleteEmpById/{id}") 
	@DELETE 
	@Consumes(MediaType.APPLICATION_JSON) 
	public int deleteUser(@PathParam("id") int id) { 
	return service.deletetEmp(id); 
	}

}
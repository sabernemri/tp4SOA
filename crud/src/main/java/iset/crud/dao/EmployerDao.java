package iset.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.mysqlx.protobuf.MysqlxDatatypes.Scalar.String;

import iset.crud.model.Employer;

public class EmployerDao {
    Connection con;

    public EmployerDao() {
        String url = String.format("jdbc:mysql://localhost:3306/bd?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        String uname = "root";
        String pwd = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, uname, pwd);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public Employer insertEmployer(Employer emp) {
        String insert = "INSERT INTO employer(id, nom, prenom, age) VALUES (NULL, ?, ?, ?)";
        
        try (PreparedStatement ps = con.prepareStatement(insert)) {
            ps.setString(1, emp.getNom());
            ps.setString(2, emp.getPrenom());
            ps.setInt(3, emp.getAge());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return emp;
    }
    
    public ArrayList<Employer> getEmps() throws SQLException{ 
        
    	   ArrayList<Employer> data = new ArrayList<Employer>(); 
    	    
    	   String select = "select * from employer"; 
    	   PreparedStatement ps = con.prepareStatement(select); 
    	   ResultSet rs = ps.executeQuery(); 
    	    
    	   while(rs.next()) { 
    	    Employer emp = new Employer(); 
    	     
    	    emp.setNom(rs.getString("nom")); // column name 
    	    emp.setPrenom(rs.getString("prenom")); 
    	    emp.setAge(rs.getInt("age")); 
    	     
    	    data.add(emp); 
    	     
    	   } 
    	    
    	   return data; 
    	    
    	  } 
    
    public ArrayList<Employer> getEmpById(int id) throws SQLException{ 
        
    	   ArrayList<Employer> data = new ArrayList<Employer>(); 
    	   String select = "select * from employer where id =?"; 
    	   PreparedStatement ps = con.prepareStatement(select); 
    	   ps.setInt(1,id); 
    	   ResultSet rs = ps.executeQuery(); 
    	    
    	   while(rs.next()) { 
    	    Employer emp = new Employer();
    	    emp.setNom(rs.getString("nom")); // column name 
    	    emp.setPrenom(rs.getString("prenom")); // column name 
    	    emp.setAge(rs.getInt("age"));   
    	    data.add(emp);   
    	   }   
    	   return data;  
    	  }
    
    public Employer updateEmp(Employer emp) { 
    	 String insert = "update employer set nom=? , age=? where id =?"; 
    	    
    	  try { 
    	  PreparedStatement ps = con.prepareStatement(insert); 
    	    ps.setString(1, emp.getNom()); 
    	    ps.setLong(2, emp.getAge()); 
    	    ps.setInt(3, emp.getId()); 
    	     
    	    ps.executeUpdate(); 
    	   }catch(Exception e) { 
    	    System.out.println(e +"data insert unsuccess."); 
    	  } 
    	    
    	   return emp; 
    	    
    	  }
    
    
    public int deletetEmp(int id) { 
    	 String insert = "delete from employer where id =?";
    	 try { 
    		 PreparedStatement ps = con.prepareStatement(insert); 
    		 ps.setInt(1,id); 
    		 ps.executeUpdate(); 
    		 }catch(Exception e) { 
    		 System.out.println(e +"data insert unsuccess."); 
    		 } 
    		 return id; 
    		 }

}
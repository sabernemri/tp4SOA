package iset.crud.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Employer {
	
	private int id;
	private String nom;
	private String prenom;
	private int age;
	public Employer( String nom, String prenom, int age) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	
	
	
	public Employer() {
		super();
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
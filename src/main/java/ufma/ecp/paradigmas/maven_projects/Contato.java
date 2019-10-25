package ufma.ecp.paradigmas.maven_projects;

public class Contato {
private String nome, email, phone, grupo;
	
	//construtor
	public Contato(String n, String e, String p, String g) {
		this.nome = n;
		this.email = e;
		this.phone = p;
		this.grupo = g;
	}
	
	//getters and setters
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	public String getGrupo() {return grupo;}
	public void setGrupo(String grupo) {this.grupo = grupo;}
	

	@Override
	public String toString() {
		return " Contato(s) [\n Nome: " + this.getNome() + ",\n Email: " + this.getEmail() + ",\n Telefone: " + this.getPhone() + 
				",\n Grupo: " + this.getGrupo() + "]";
	}
	
}

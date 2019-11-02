package ufma.ecp.paradigmas.docentesigaa;

import ufma.ecp.paradigmas.docentesigaa_reflexao.ColunaAnnotation;

public class Docente {
	
	@ColunaAnnotation(nome = "Professor", posicao = 0)
	private String professor;
	@ColunaAnnotation(nome = "Cadeira", posicao = 1)
	private String cadeira;
	@ColunaAnnotation(nome = "Id", posicao = 2)
	private int id;
	
	//construtor
	public Docente(String n, String e, int p) {
		this.professor = n;
		this.cadeira = e;
		this.id = p;
	}
	
	//getters and setters
	public String getProfessor() {return professor;}
	public void setProfessor(String professor) {this.professor = professor;}
	public String getCadeira() {return cadeira;}
	public void setCadeira(String cadeira) {this.cadeira = cadeira;}
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	@Override
	public String toString() {
		return " Docente(s) [Professor: " + this.getProfessor() + ",Cadeira: " + this.getCadeira() + ",Id: " + this.getId() + "]";
	}
}

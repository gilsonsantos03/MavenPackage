package ufma.ecp.paradigmas.docentesigaa_reflexao;

import java.util.Arrays;
import java.util.List;

import ufma.ecp.paradigmas.docentesigaa.Docente;

public class ReflexaoDocenteDAO implements AbstractDAO<Docente>{
	
	List<Docente> docentes = Arrays.asList(new Docente("Sergio Costa", "PP", 1));
	
	@Override
	public void create(Docente docente) {
	}

	@Override
	public List<Docente> read() {
		return docentes;
	}
	
}

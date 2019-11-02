package ufma.ecp.paradigmas.docentesigaa_reflexao;

import java.util.List;

public interface AbstractDAO<T> {
	void create(T obj);
	List<T> read();
}

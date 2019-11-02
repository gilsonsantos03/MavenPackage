package ufma.ecp.paradigmas.docentesigaa_reflexao;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;

@Retention(RUNTIME)
public @interface ColunaAnnotation {
	String nome();
	int posicao();
}

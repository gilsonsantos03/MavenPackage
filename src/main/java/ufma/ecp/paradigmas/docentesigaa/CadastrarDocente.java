package ufma.ecp.paradigmas.docentesigaa;

public class CadastrarDocente {

	public static void main(String[] args) {
		//FrameCadastro j = new FrameCadastro();
		//j.setVisible(true);
		
		DocenteDAO d = new DocenteDAO();
		
		System.out.println(d.recuperaDocente());
	}
}

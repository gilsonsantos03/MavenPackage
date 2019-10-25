package ufma.ecp.paradigmas.docentesigaa;

import java.sql.SQLException;

import javax.swing.JFrame;

public class CadastrarDocente {

	public static void main(String[] args) throws SQLException {
		/*
		FrameCadastro j = new FrameCadastro();
		j.setVisible(true);
		*/
		
		FrameTable frame = new FrameTable();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}

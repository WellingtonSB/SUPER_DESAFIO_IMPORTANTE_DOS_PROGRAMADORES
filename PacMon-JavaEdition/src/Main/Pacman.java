package Main;

import javax.swing.JFrame;
import Game.Model;
import Game.ModelFase2;

public class Pacman extends JFrame{

	Model fase1 = new Model();
	
	public Pacman() {
		
		add(new Model());
		
	}
				
	public static void main(String[] args) {
		
		Pacman pac = new Pacman();
		pac.setVisible(true);
		pac.setTitle("Pacman");
		pac.setSize(380,420);
		pac.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pac.setLocationRelativeTo(null);
		pac.setResizable(false);
		
		
		
	}
	


}
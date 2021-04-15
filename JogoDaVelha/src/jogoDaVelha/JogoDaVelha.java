package jogoDaVelha;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class JogoDaVelha extends JFrame {
	
	
	ImageIcon iconNaruto = new ImageIcon(getClass().getResource("dattebayo.png"));
	ImageIcon iconFausto = new ImageIcon(getClass().getResource("bigFausto.png"));
	

	
	final int JOGADOR_1 = 1; 	// cria os jogador constante  1
	final int JOGADOR_2= 2; 	// cria os jogador constante  2
	
	int jogadorVez = JOGADOR_1;
	
	JPanel pTela = new JPanel(new GridLayout(3,3,10,10));		//INSTANCIA CLASSE JPANEL NO OBJETO TELA ONDE SERÁ SELECIONADO "X" OU "O"
	JLabel lInformacao = new JLabel("Bom Jogo");	//INSTANCIA CLASSE JLABEL NO OBJETO lInformacao PARA INDICAR QUAL JOGADOR TEM A VEZ
	Bloco[] blocos = new Bloco[9];		//CRIA O VETOR DE 9 POSIÇOES POSSIVEIS PARA SEREM SELECIONADAS
	int rodadas = 0;
	
	public JogoDaVelha() {		// CONSTRUTOR
		configurarJanela();
		configurarTela();
	}
	
	
	public void configurarTela() {			// CONFIGURAÇÃO DE CADA CAMPO A SER SELECIONADO
		add(BorderLayout.CENTER, pTela);
		add(BorderLayout.NORTH, lInformacao);
		pTela.setBackground(Color.BLACK);
		
		for (int i = 0; i <blocos.length; i++) {
			Bloco bloco = new Bloco();
			blocos[i] = bloco;
			pTela.add(bloco);
			lInformacao.setFont(new Font("Arial", Font.BOLD, 30));
			lInformacao.setForeground(new Color(37,205,200));
			lInformacao.setHorizontalAlignment(SwingConstants.CENTER);
		}
	}
	
	public void mudarVez() {
		if (jogadorVez == 1) {
			jogadorVez = 2;
			lInformacao.setText("Jogador " + JOGADOR_2);
			lInformacao.setForeground(Color.RED);
		} else {
			jogadorVez = 1;
			lInformacao.setText("Jogador " + JOGADOR_1);
			lInformacao.setForeground(new Color(37,205,200));
		}
	}
	
	public boolean testarVitoria (int jog) {
		if (blocos[0].quem == jog && blocos[1].quem == jog && blocos[2].quem == jog) {
			return true;
		}
		if (blocos[3].quem == jog && blocos[4].quem == jog && blocos[5].quem == jog) {
			return true;
		}
		if (blocos[6].quem == jog && blocos[7].quem == jog && blocos[8].quem == jog) {
			return true;
		}
		if (blocos[0].quem == jog && blocos[3].quem == jog && blocos[6].quem == jog) {
			return true;
		}
		if (blocos[1].quem == jog && blocos[4].quem == jog && blocos[7].quem == jog) {
			return true;
		}
		if (blocos[2].quem == jog && blocos[5].quem == jog && blocos[8].quem == jog) {
			return true;
		}
		if (blocos[0].quem == jog && blocos[4].quem == jog && blocos[8].quem == jog) {
			return true;
		}
		if (blocos[2].quem == jog && blocos[4].quem == jog && blocos[6].quem == jog) {
			return true;
		}
		return false;
	}
	
	
	
	
	public void configurarJanela() {		//CONFIGURAÇÃO DA JANELA DO JOGO
		setTitle("Jogo da Velha");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {	
		
		new JogoDaVelha();
		
	}
	
	public class Bloco extends JButton {	//CONFIGURAÇÃO DE CADA TELA COMO UM BOTÃO.
		int  quem = 0;
		public Bloco() {
			
			setBackground(Color.WHITE);
			addActionListener(e -> {
				if(quem == 0) {
					if (jogadorVez == JOGADOR_1) {
						
						setIcon(iconNaruto);
						quem = JOGADOR_1;
						
					} else  {
						
						setIcon(iconFausto);
						quem = JOGADOR_2;
						
					}
					if (testarVitoria(quem)) {
						
						JOptionPane.showMessageDialog(null, "Jogador " + quem + " venceu!");
						System.exit(quem);
					}
					rodadas++;
					if (rodadas == 9) {
						JOptionPane.showMessageDialog(null, "Deu Velha!");
						System.exit(0);
					}
					mudarVez();
				}
			});
		}
	}
}

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Pokemon extends JFrame {
	
	public static Pokemon pokemon;
	public Player player;
	
	public Pokemon () {
		PokemonKeyListener keyListener = new PokemonKeyListener();
		
		setLayout(null);
		setTitle("Pokémon");
		setSize(640, 480);
		addKeyListener(keyListener);

		setVisible(true);
	}
	
	public void initialize() {
		player = new Player();
	}

	public static void main(String[] args) {
		pokemon = new Pokemon();
		pokemon.initialize();
	}

}

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class PokemonKeyListener extends KeyAdapter {

	public PokemonKeyListener() {
	}
	
	public void keyPressed(KeyEvent e) {
		Player player = Pokemon.pokemon.player;
		
		player.handleInput(e.getKeyCode());
	}

}

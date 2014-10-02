import java.awt.geom.Point2D;

import javax.swing.JButton;


public class Sprite {

	JButton swingElement;
	
	public Sprite() {

		swingElement = new JButton();
		swingElement.setBounds(0, 0, 32, 32);
		swingElement.setEnabled(false);
		Pokemon.pokemon.add(swingElement);
		
	}
	
	public void setPosition(Point2D position) {
		swingElement.setBounds((int)position.getX(), (int)position.getY(), 32, 32);
	}

}

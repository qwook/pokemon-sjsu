import java.awt.geom.Point2D;


public class Player {
	
	Point2D origin;
	Sprite sprite;

	public Player() {
		origin = new Point2D.Double(0, 0);
		sprite = new Sprite();
	}
	
	void updateSprite() {
		sprite.setPosition(new Point2D.Double(origin.getX()*32, origin.getY()*32));
	}
	
	void moveUp() {
		origin.setLocation(origin.getX(), origin.getY() - 1);
		updateSprite();
	}
	
	void moveDown() {
		origin.setLocation(origin.getX(), origin.getY() + 1);
		updateSprite();
	}
	
	void moveLeft() {
		origin.setLocation(origin.getX() - 1, origin.getY());
		updateSprite();
	}
	
	void moveRight() {
		origin.setLocation(origin.getX() + 1, origin.getY());
		updateSprite();
	}

	public void handleInput(int keyCode) {
		System.out.println(keyCode);
		switch (keyCode) {
		// w
		case 87:
			moveUp();
			break;
		// s
		case 83:
			moveDown();
			break;
		// a
		case 65:
			moveLeft();
			break;
		// d
		case 68:
			moveRight();
			break;
			
		////
			
		// k (action)
		case 75:
			break;
		// l (cancel)
		case 76:
			break;
		}
	}
	
}

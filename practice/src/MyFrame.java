import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class GraphicObject {

	BufferedImage img = null;
	int x = 1, y = 0;

	public GraphicObject(String name) {

		try {
			img = ImageIO.read(new File(name));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}

	}

	public void upadate() {
	}

	public void draw(Graphics g) {

		g.drawImage(img, x, y, null);

	}

	public void keyPressed(KeyEvent event) {

	}

}

class Missile extends GraphicObject {

	boolean launched = false;

	public Missile(String name) {
		super(name);

		y = -200;

	}

	private void update() {

		if (launched) {
			y = -1;
		}
		if (y < -90) {
			launched = false;
		}
	}

	public void keyPressed(KeyEvent event, int x, int y) {
		
		if (event.getKeyCode() == KeyEvent.VK_SPACE) {

			launched = true;
			this.x = x;
			this.y = y;

		}

	}

}

class Enemy extends GraphicObject {

	int dx = -10;

	public Enemy(String name) {
		super(name);

		x = 500;
		y = 0;
	}

	public void update() {

		x += dx;
		if (x < 0) {
			dx = +10;
		}
		if (x > 500) {
			dx = -10;
		}

	}

}

class SpaceShip extends GraphicObject {

	public SpaceShip(String name) {
		super(name);

		x = 150;
		y = 350;

	}

	@Override
	public void keyPressed(KeyEvent event) {

		if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= 10;

		}

		if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += 10;

		}

		if (event.getKeyCode() == KeyEvent.VK_UP) {
			x -= 10;

		}

		if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			x += 10;

		}

	}
}

class MyPanel extends JPanel implements KeyListener {

	Enemy enemy;
	SpaceShip spaceship;
	Missile missile;

	public MyPanel() {

		super();
		this.addKeyListener(this);
		this.requestFocus();
		setFocusable(true);

		// three pictures
		enemy = new Enemy("enemy.png"); // picture 1
		spaceship = new SpaceShip("spaceship.png"); // picture2
		missile = new Missile("missile.png"); // picture3

		class MyThread extends Thread {

			@Override
			public void run() {
				while (true) {
					enemy.update();
					spaceship.upadate();
					missile.upadate();

					repaint();

					try {
						Thread.sleep(50);

					} catch (InterruptedException e) {
					}
				}

			}

		}
		Thread t = new MyThread();
		t.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		enemy.draw(g);
		spaceship.draw(g);
		missile.draw(g);
	}

	@Override
	public void keyTyped(KeyEvent event) {

		spaceship.keyPressed(event);
		missile.keyPressed(event, spaceship.x, spaceship.y);

	}

	@Override
	public void keyPressed(KeyEvent arg0) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

}

public class MyFrame extends JFrame {

	public MyFrame() {
		setTitle("My Game");
		add(new MyPanel());
		setSize(900, 900);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame();
	}

}

package window;

import entity.Fur;
import entity.Player;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import manage.KeyManager;
import world.Level1;


public class Game implements Runnable {

	private Display display;
	
	public int width, height;
	public String title;
	
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private boolean running = false;

	public KeyManager keyManager;

	Player player = new Player(this, 30, 30);
	Fur fur = new Fur(this, 300, 300);
	Level1 level1 = new Level1();

	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}

	//!!!!!Инициализация
	private void init() {
		display = new Display(this.title, width, height);
		keyManager = new KeyManager();
		display.getJFrame().addKeyListener(keyManager);
	}

	//!!!ОБНОВЛЕНИЕ
	private void move() {

        level1.move();
		player.move();
        fur.move();

	}

	//!!ПРОРИСОВКА
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		//Рисуем!!!
		///////////////////////////////////////////////////////////////
		g.clearRect(0, 0, width, height);

		level1.render(g);
		player.render(g);
		fur.render(g);



		///////////////////////////////////////////////////////////////


		//end draw
		bs.show();
		g.dispose();
	}
	
	@Override
	public void run() {
		
		init(); //инициализация
		
		int fps = 60;
		double kolNS = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();

		//бесконечный цикл пока running
		while (running) {
			now = System.nanoTime();

			delta += (now - lastTime) / kolNS;
			lastTime = now;
			
			if (delta >= 1) {
				System.out.println("60fps");
				move();  //пересчет объектов
				render();  //перерисовка объектов
				delta--;
			}
		}
		
		stop();
	}
	
	public synchronized void start() {
		if (running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Source {

	private JFrame frame;
	private static Game game;

	public static void main(String[] args) {
	    
	    
	    
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Source window = new Source();
					window.frame.setVisible(true);
					
					
					Timer timer = new Timer(1, new ActionListener() {

					    @Override
					    public void actionPerformed(ActionEvent e) {
						game.update();
						game.repaint();
					    }
					    
					});
					timer.start();		

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Source() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		game = new Game();
		game.setBounds(100, 100, 450, 300);
		frame.getContentPane().add(game);
		frame.addKeyListener(new KeyListener() {

		    @Override
		    public void keyTyped(KeyEvent e) {
			
		    }

		    @Override
		    public void keyPressed(KeyEvent e) {
			game.mapManager.handleKeyPressed(e);
		    }

		    @Override
		    public void keyReleased(KeyEvent e) {
			
		    }
		    
		});
		
	}

}

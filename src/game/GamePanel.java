package game;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable{

    //Configuracoes do painel
    public final int ORIGINAL_TILE_SIZE = 16; // 16x16
    public final int SCALE = 3;
    public final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; // 48x48

    public final int SCREEN_COL = 16;
    public final int SCREEN_ROW = 12;
    public final int SCREEN_WIDTH = SCREEN_COL * TILE_SIZE; // 728 pixels
    public final int SCREEN_HEIGHT = SCREEN_ROW * TILE_SIZE; // 576 pixels

    //Thread para o game loop
    Thread gameThread;

    //eventos
    KeyHandler keys = new KeyHandler();

    public GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // + desempenho

        //aplicar eventos no JPanel
        this.addKeyListener(keys);
        this.setFocusable(true);
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        while(gameThread != null){
           //gameLoop
            update();

            repaint(); //chama o metodo paintComponent
        }
    }
    public void update(){

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //Area para os draws

        g2.dispose();
    }
}

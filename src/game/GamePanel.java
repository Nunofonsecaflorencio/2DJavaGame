package game;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class GamePanel extends JPanel {

    //Configuracoes do painel
    public final int ORIGINAL_TILE_SIZE = 16; // 16x16
    public final int SCALE = 3;
    public final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; // 48x48

    public final int SCREEN_COL = 16;
    public final int SCREEN_ROW = 12;
    public final int SCREEN_WIDTH = SCREEN_COL * TILE_SIZE; // 728 pixels
    public final int SCREEN_HEIGHT = SCREEN_ROW * TILE_SIZE; // 576 pixels

    public GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // + desempenho
    }
}

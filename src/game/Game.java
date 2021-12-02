package game;

import javax.swing.JFrame;

public class Game {
    public static void main(String[] args) {
        //Criando janela
        JFrame window = new JFrame();
        window.setTitle("2D Jave Game");
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Area para JPanels
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        //
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}

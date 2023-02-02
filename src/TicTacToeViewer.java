import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame{
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private Image[] moves;
    private String[] axis;
    private TicTacToe t;


    TicTacToeViewer(TicTacToe t){
        this.t = t;
        moves = new Image[2];
        moves[0] = new ImageIcon("Resources/O.png").getImage();
        moves[1] = new ImageIcon("Resources/X.png").getImage();
        axis = new String[]{"0", "1", "2"};
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g){
        for (int i = 0; i < 3; i++){
            g.drawString(axis[i], i * 100 + 250, 140);
            g.drawString(axis[i], 180, i * 100 + 200);
            for (int j = 0; j < 3; j++){
                t.getBoard()[i][j].draw(g);
            }
        }
        if (t.getGameOver() == true){
            if (t.checkTie() == true){
                g.drawString("Its a tie", 350, 500);
            }
            else{
                g.drawString(t.getWinner() + " wins", 350, 500);
            }
        }
    }


    public Image[] getMoves() {
        return moves;
    }
}

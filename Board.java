import chaingingBoard.Boxes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JFrame implements MouseListener {
    public static final int TILE_SIDE_COUNT = 8;


    private Object[][] boxCollection;

    public Board() {


        this.boxCollection = new Object[TILE_SIDE_COUNT][TILE_SIDE_COUNT];
        // JFrame applicationFrame = new JFrame();
        // applicationFrame.setSize(500,500);
        // applicationFrame.setVisible(true);
        //applicationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.boxCollection[0][0] = (new Boxes(1, 0, Color.YELLOW));
        this.boxCollection[1][1] = (new Boxes(1, 1, Color.green));
        this.boxCollection[1][2] = (new Boxes(1, 2, Color.green));
        this.boxCollection[1][3] = (new Boxes(1, 3, Color.green));
        this.boxCollection[1][4] = (new Boxes(1, 4, Color.green));
        this.boxCollection[1][5] = (new Boxes(1, 5, Color.green));
        this.boxCollection[1][6] = (new Boxes(1, 6, Color.green));
        this.boxCollection[1][7] = (new Boxes(1, 7, Color.green));
        this.boxCollection[1][7] = (new Boxes(1, 7, Color.green));
        this.boxCollection[1][0] = (new Boxes(6, 0, Color.blue));
        this.boxCollection[1][1] = (new Boxes(6, 1, Color.blue));
        this.boxCollection[1][2] = (new Boxes(6, 2, Color.blue));
        this.boxCollection[1][3] = (new Boxes(6, 3, Color.blue));
        this.boxCollection[1][4] = (new Boxes(6, 4, Color.blue));



        this.setSize(800, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);
        
            JOptionPane.showMessageDialog(null, "Game Over","Display Message",JOptionPane.INFORMATION_MESSAGE );


    }

    /**
     * Метод който взима кординатите върху който  щракне мишката
     *
     * @param e
     */


    public void mouseClicked(MouseEvent e) {

        System.out.println("Col  -> " + this.getBoardDimentionBasedOnCoordinates(e.getX()));

        System.out.println("Row  -> " + this.getBoardDimentionBasedOnCoordinates(e.getY()));




    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override

    /**
     * Метод принтиращ редовете , колоните , гардовете и лидерите
     */
    public void paint(Graphics g) {

        // super.paint(g);

        for (int row = 0; row < 8; row++) {

            for (int col = 0; col < 8; col++) {

              this.rendererGameTile( g,row,col);
             this.renderGameBox(g,row,col);

            }

        }


    }

    /**
     * Метод принтиращ игралното поле по подадени кординати за ред и колона
     *
     * @param row
     * @param col
     * @return
     */

    private Color getTileColor(int row, int col) {
        boolean isRowEven = (row % 2 == 0);
        boolean isRowOdd = !isRowEven;
        boolean isColEven = (col % 2 == 0);
        boolean isCOlOdd = !isColEven;

        if (isRowEven && isColEven) return Color.red;
        if (isRowEven && isCOlOdd) return Color.green;
        if (isRowOdd && isColEven) return Color.yellow;

        return Color.blue;

    }


    /**
     * Метод взимащ кординатите от игралното поле
     */

    private int getBoardDimentionBasedOnCoordinates(int coordinates) {

        return coordinates / GameTile.TILE_SIZE;

    }

    private  void rendererGameTile (Graphics g ,  int row , int col ){

        Color tileColor = this.getTileColor(row, col);
        GameTile tile = new GameTile(row, col, tileColor);
        tile.render(g);




    }

    private Object getBoardPiece(int row, int col) {
        return this.boxCollection[row][col];
    }

    private boolean hasBoardPiece(int row, int col) {
        return this.getBoardPiece(row, col) != null;
    }

    private void renderGamePiece(Graphics g, int row, int col) {

        if(this.hasBoardPiece(row, col)) {

            Boxes p = (Boxes) this.getBoardPiece(row, col);
            p.render(g);
        }
    }

    private  void renderGameBox (Graphics g , int row , int col) {


    }

}

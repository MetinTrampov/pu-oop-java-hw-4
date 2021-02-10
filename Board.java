import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JFrame implements MouseListener {
    public static final int TILE_SIDE_COUNT = 6;


    public Board() {


        // JFrame applicationFrame = new JFrame();
        // applicationFrame.setSize(500,500);
        // applicationFrame.setVisible(true);
        //applicationFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setSize(800, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);

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

                Color tileColor = this.getTileColor(row, col);
                GameTile tile = new GameTile(row, col, tileColor);
                tile.render(g);

             /* Pawns p1 = new Pawns(row,col);
                p1.render(g);
                Liders lidYellow= new Liders(row,col);
                lidYellow.render(g);
*/


                // Knight k1 = new Knight(row,col);
                // k1.render(g);
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

        if (isRowEven && isColEven) return Color.RED;
        if (isRowEven && isCOlOdd) return Color.WHITE;
        if (isRowOdd && isColEven) return Color.yellow;

        return Color.blue;

    }


    /**
     * Метод взимащ кординатите от игралното поле
     */

    private int getBoardDimentionBasedOnCoordinates(int coordinates) {
        return coordinates / GameTile.TILE_SIZE;
    }

}

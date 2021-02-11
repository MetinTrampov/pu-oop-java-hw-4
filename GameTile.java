import java.awt.*;

public class GameTile {
    public static final int TILE_SIZE = 100 ;
    private  int row;
    private  int col;
   // private  int tileSize;
    private Color color;


    public  GameTile(int row , int col,Color color){

        this.row        = row;
        this.col        = col;
        //this.tileSize   = 100;
        this.color      =color;


    }
    public  void render (Graphics g){

        int tileX = this.col * this.TILE_SIZE;
        int tileY = this.row * this.TILE_SIZE;


        g.setColor(this.color);
        g.fillRect(tileX,tileY,TILE_SIZE,TILE_SIZE);

    }

}

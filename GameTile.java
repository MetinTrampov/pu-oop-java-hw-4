import java.awt.*;

public class GameTile {
    public static final int TILE_SIZE =6 ;
    private  int row;
    private  int col;
    private  int tileSize;
    private Color color;


    public  GameTile(int row , int col,Color color){

        this.row        = row;
        this.col        = col;
        this.tileSize   = 100;
        this.color      =color;


    }
    public  void render (Graphics g){

        int tileX = this.col * this.tileSize;
        int tileY = this.row * this.tileSize;






        //   if(this.row % 2 == 0 ){
        //      g.setColor(Color.BLACK);
        //   }else {
        //     g.setColor(Color.WHITE);
        //  }

        g.setColor(this.color);
        g.fillRect(tileX,tileY,tileSize,tileSize);

    }

}

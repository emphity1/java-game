package game;
import java.awt.image.BufferedImage;


/*loading every images every sec is heavy
 * so let's make it simplier...
 * It will load once
 */

public class Assets {

    public static BufferedImage grass,fence,biom,water;
    public static BufferedImage[] player_down,player_up,player_right,player_left,player_stop;

    public static BufferedImage tree1,tree2,tree3;

    public static final int width = 16, height = 16;
    public static final int fenceWidth = 16, fenceHeight = 48;
    
    //LOADING MY SPRITES AND CROPING THEM
    public static void init(){

        SpriteSheet GrassSheet = new SpriteSheet(ImageLoader.loadImage("/game/res/textures/Sprout Lands/Tilesets/ground tiles/new tiles/Grass tiles v.2.png"));
        SpriteSheet PlayerSheet = new SpriteSheet(ImageLoader.loadImage("/game/res/textures/Sprout Lands/Characters/Basic Charakter Spritesheet.png"));
        SpriteSheet FenceSheet = new SpriteSheet(ImageLoader.loadImage("/game/res/textures/Sprout Lands/Tilesets/Fences.png"));
        SpriteSheet TreeSheet = new SpriteSheet(ImageLoader.loadImage("/game/res/textures/Sprout Lands/Objects/Basic Grass Biom things 1.png"));


        //player anim
        player_down = new BufferedImage[2];
        player_up = new BufferedImage[2];
        player_right = new BufferedImage[2];
        player_left = new BufferedImage[2];
        player_stop = new BufferedImage[2];

        player_down[0] = PlayerSheet.crop(14*8,2*8,width,height);
        player_down[1] = PlayerSheet.crop(20*8,2*8,width,height);
        player_up[0] = PlayerSheet.crop(14*8,8*8,width,height);
        player_up[1] = PlayerSheet.crop(20*8,8*8,width,height);
        player_right[0] = PlayerSheet.crop(14*8,14*8,width,height);
        player_right[1] = PlayerSheet.crop(20*8,14*8,width,height);
        player_left[0] = PlayerSheet.crop(14*8,20*8,width,height);
        player_left[1] = PlayerSheet.crop(20*8,20*8,width,height);

        player_stop[0] = PlayerSheet.crop(16, 16, width, height);
        player_stop[1] = PlayerSheet.crop(8*8, 16, width, height);
        
        //tiles
        grass = GrassSheet.crop(0,80, width,height);
        fence = FenceSheet.crop(0, 0, fenceWidth,fenceHeight);
        //trees
        tree1 = TreeSheet.crop(0, 0, 2*8, 4*8);
        tree2 = TreeSheet.crop(2*3, 0, 3*8, 4*8);

    }

    public int getFenceWidth(){
        return fenceWidth;
    }

    public int getFenceHeight(){
        return fenceHeight;
    }


    
}

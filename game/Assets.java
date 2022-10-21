package game;
import java.awt.image.BufferedImage;

/*loading every images every sec is heavy
 * so let's make it simplier...
 * It will load once
 */

public class Assets {

    public static BufferedImage player,grass,fence,biom,water;

    public static final int Width = 48, height = 48;
    public static final int GrassWidth = 48, GrassHeight = 48;
    public static final int PlayerWidth = 48, PlayerHeight = 48;

    public static void init(){
        SpriteSheet GrassSheet = new SpriteSheet(ImageLoader.loadImage("/game/res/textures/Sprout Lands/Tilesets/ground tiles/new tiles/Grass tiles v.2.png"));
        SpriteSheet PlayerSheet = new SpriteSheet(ImageLoader.loadImage("/game/res/textures/Sprout Lands/Characters/Basic Charakter Spritesheet.png"));
        SpriteSheet FenceSheet = new SpriteSheet(ImageLoader.loadImage("/game/res/textures/Sprout Lands/Tilesets/Fences.png"));

        
        grass = GrassSheet.crop(0, 0, GrassWidth, GrassHeight);
        player = PlayerSheet.crop(0, 0, PlayerWidth, PlayerHeight);
        fence = FenceSheet.crop(16, 16, Width, height);
    }
    
}

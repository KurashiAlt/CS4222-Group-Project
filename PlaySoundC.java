import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
public class PlaySoundC {
    public static void main (String [] args) 
    {
        
        File file = new File("C.wav.mp3");
        Media sound = new Media(file.toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.play();
    }
}
import javax.sound.sampled.*;
import java.io.File;

public class PlayEnemySound { // call on this method to play the harsh noise when an enemy hits you
    public static void main(String[] args) {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("EnemySound.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();

            // Keep program alive until audio finishes
            Thread.sleep(clip.getMicrosecondLength() / 1000);

        } catch (Exception e) {
            System.out.println("Error playing audio.");
        }
    }
    }
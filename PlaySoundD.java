import javax.sound.sampled.*;
import java.io.File;

public class PlaySoundD {
    public static void main(String[] args) {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("D.wav"));
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
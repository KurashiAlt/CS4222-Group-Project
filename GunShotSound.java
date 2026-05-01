import javax.sound.sampled.*;

public class GunShotSound
{
    public static void playGunshot()
    {
        try {
            float sampleRate = 44100;
            int durationMs = 120;
            int numSamples = (int)(sampleRate * durationMs / 1000);
            byte[] audioData = new byte[numSamples * 2]; // 16-bit audio

            for (int i = 0; i < numSamples; i++) {
                // Random noise
                double noise = (Math.random() * 2.0) - 1.0;

                // Fast decay envelope
                double envelope = Math.exp(-6.0 * i / numSamples);
                short sample = (short)(noise * envelope * 32767);

                audioData[2 * i]     = (byte)(sample & 0xff);
                audioData[2 * i + 1] = (byte)((sample >> 8) & 0xff);
            }

            AudioFormat format = new AudioFormat(
                sampleRate,
                16,
                1,
                true,
                false
            );

            Clip clip = AudioSystem.getClip();
            clip.open(format, audioData, 0, audioData.length);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
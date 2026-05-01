import javax.sound.sampled.*;

public class SoundEffects
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
    public static void playEnemyNoise()
    {
        try {
            float sampleRate = 44100;
            int durationMs = 250;
            int numSamples = (int)(sampleRate * durationMs / 1000);
            byte[] audio = new byte[numSamples * 2]; // 16-bit mono

            double frequency = 1800; // Very piercing frequency

            for (int i = 0; i < numSamples; i++) {

                // Square wave (extremely harsh)
                double square =
                    Math.signum(
                        Math.sin(2.0 * Math.PI * frequency * i / sampleRate)
                    );

                // White noise
                double noise = (Math.random() * 2.0) - 1.0;

                // Combine + distortion
                double mixed = (square * 0.8) + (noise * 0.6);

                // Hard clipping distortion
                mixed = Math.max(-1.0, Math.min(1.0, mixed));

                // Slight decay to avoid speaker damage
                double envelope = Math.exp(-3.0 * i / numSamples);

                short sample = (short)(mixed * envelope * 32767);

                audio[i * 2]     = (byte)(sample & 0xff);
                audio[i * 2 + 1] = (byte)((sample >> 8) & 0xff);
            }

            AudioFormat format = new AudioFormat(
                sampleRate,
                16,
                1,
                true,
                false
            );

            Clip clip = AudioSystem.getClip();
            clip.open(format, audio, 0, audio.length);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
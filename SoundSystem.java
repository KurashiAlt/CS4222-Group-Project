import javax.sound.midi.*;

public class SoundSystem {
    public static Sequencer sequencer;

    // MIDI note numbers for A–G (4th octave)
    private static final int NOTE_A = 69;
    private static final int NOTE_B = 71;
    private static final int NOTE_C = 60;
    private static final int NOTE_D = 62;
    private static final int NOTE_E = 64;
    private static final int NOTE_F = 65;
    private static final int NOTE_G = 67;

    // -------------------------
    // INITIALIZATION
    // -------------------------
    public static void start() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // -------------------------
    // GENERIC NOTE PLAYER
    // -------------------------
    public static void playNote(int note) {
        try {
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            // Note ON
            track.add(makeEvent(144, 1, note, 100, 1));

            // Note OFF
            track.add(makeEvent(128, 1, note, 100, 16));

            sequencer.setSequence(sequence);
            sequencer.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // -------------------------
    // A–G NOTE METHODS
    // -------------------------
    public static void playA() { playNote(NOTE_A); }
    public static void playB() { playNote(NOTE_B); }
    public static void playC() { playNote(NOTE_C); }
    public static void playD() { playNote(NOTE_D); }
    public static void playE() { playNote(NOTE_E); }
    public static void playF() { playNote(NOTE_F); }
    public static void playG() { playNote(NOTE_G); }

    // -------------------------
    // MIDI EVENT HELPER
    // -------------------------
    public static MidiEvent makeEvent(int command, int channel, int note, int velocity, int tick) {
        try {
            ShortMessage msg = new ShortMessage();
            msg.setMessage(command, channel, note, velocity);
            return new MidiEvent(msg, tick);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
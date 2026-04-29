import java.util.Scanner;
public class SoundSystemTest
{
    public static void main (String []args) {
        SoundSystem.start();
        Scanner note = new Scanner(System.in);
        System.out.println("1, corresponds to A, 2 corresponds to B, and so on up until 7, which corresponds to G");
        System.out.println("Enter a number 1-7 to play its corresponding note:");
        int noteSelection = note.nextInt();
        if (noteSelection == 1) {
            SoundSystem.playA();
        }
        else if (noteSelection == 2) {
            SoundSystem.playB();
        }
        else if (noteSelection == 3) {
            SoundSystem.playC();
        }
        else if (noteSelection == 4) {
            SoundSystem.playD();
        }
        else if (noteSelection == 5) {
            SoundSystem.playE();
        }
        else if (noteSelection == 6) {
            SoundSystem.playF();
        }
        else if (noteSelection == 7) {
            SoundSystem.playG();
        }
        else {
            System.out.println(noteSelection + "  does not correspond to a note. Please restart and try again");
        }
    }
}
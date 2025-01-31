package sound;

import javazoom.jl.decoder.Bitstream;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;

public class SoundEffect {
    // Method to play a success sound when login is successful
    public static String playSuccessSound() {
        try {
            // Path to the MP3 file
            File mp3File = new File("src/sound/success-sound.mp3");
            if (!mp3File.exists()) {
                System.out.println("File not found.");
            }

            // Use JLayer's Bitstream class to play the MP3 file
            Bitstream bitstream = new Bitstream(new FileInputStream(mp3File));
            Player player = new Player(new FileInputStream(mp3File));

            // Start playing the sound
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "\nLogin successfully!" ;
    }
    public static String playFailSound() {
        try {
            // Path to the MP3 file
            File mp3File = new File("src/sound/fail-sound.mp3");
            if (!mp3File.exists()) {
                System.out.println("File not found.");
            }

            // Use JLayer's Bitstream class to play the MP3 file
            Bitstream bitstream = new Bitstream(new FileInputStream(mp3File));
            Player player = new Player(new FileInputStream(mp3File));

            // Start playing the sound
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "\nInvalid Username or Password! Try again.\n" ;
    }

    public static String playStartOrder() {
        try {
            // Path to the MP3 file
            File mp3File = new File("src/sound/start-order.mp3");
            if (!mp3File.exists()) {
                System.out.println("File not found.");
            }

            // Use JLayer's Bitstream class to play the MP3 file
            Bitstream bitstream = new Bitstream(new FileInputStream(mp3File));
            Player player = new Player(new FileInputStream(mp3File));

            // Start playing the sound
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

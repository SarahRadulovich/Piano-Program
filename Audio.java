/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pianoprogram;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;

/**
 *
 * @author Sarah Radulovich
 * Due Date: Jan. 26, 2016
 */
public class Audio {
    
    //This is the audio method for the treble cleff
    public void playSound(String note, int a) throws InterruptedException {
        //sending the audio file with a 250 sleep thread
        try {
            URL url = this.getClass().getClassLoader().getResource(note);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            Thread.sleep(a);

        //catching all exceptions
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }


}
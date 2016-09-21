/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pianoprogram;


/**
 *
 * @author Sarah Radulovich 
 * Due Date: Jan. 26, 2016
 */
public class SoundFileNames {

    public String[] soundFileNames(String[] notes, int a, int y) {
        Run gui = new Run();
        
        //treble clef
        //57
        if (y <= 70 && y > 60 || y<= 290 && y > 280) {
                notes[a] = "39205__jobro__piano-ff-057.wav";
                System.out.println(y);
            }
            //56
            if (y <= 80 && y > 70 || y <= 300 && y > 290) {
                notes[a] = "39204__jobro__piano-ff-056.wav";
            }
            //54
            if (y <= 90 && y > 80 || y <= 310 && y > 300) {
                notes[a] = "39202__jobro__piano-ff-054.wav";
            }
            //52
            if (y <= 100 && y > 90 || y<= 320 && y > 310) {
                notes[a] = "39200__jobro__piano-ff-052.wav";
            }
            //51
            if (y <= 110 && y > 100 || y<= 330 && y > 320) {
                notes[a] = "39199__jobro__piano-ff-051.wav";
            }
            //49
            if (y <= 120 && y > 110 || y <= 340 && y > 330) {
                notes[a] = "39197__jobro__piano-ff-049.wav";
            }
            //47
            if (y <= 130 && y > 120 || y <= 350 && y > 340) {
                notes[a] = "39195__jobro__piano-ff-047.wav";
            }
            //45
            if (y <= 140 && y > 130 || y <= 360 && y > 350) {
                notes[a] = "fnote2.wav";
            }
            //44
            if (y <= 150 && y > 140 || y <= 370 && y > 360) {
                notes[a] = "enote2.wav";
            }
            //42
            if (y <= 160 && y > 150 || y <= 380 && y > 370) {
                notes[a] = "dnote.wav";
            }

            //bass clef
            //37
            if (y <= 170 && y > 160 || y <= 390 && y > 380) {
                notes[a] = "039.wav";
                
            }
            if (y <= 180 && y > 170 || y <= 400 && y > 390) {
                notes[a] = "anote.wav";
            }
            //35
            if (y <= 190 && y > 180 || y <= 410 && y > 400) {
                notes[a] = "gnote.wav";
            }
            //33
            if (y <= 200 && y > 190 || y <= 420 && y > 410) {
                notes[a] = "fnote.wav";
            }
            //32
            if (y <= 210 && y > 200|| y <= 430 && y > 420) {
                notes[a] = "enote.wav";
            }
            //actual a d, need to remane
            if (y <= 220 && y > 210 || y <= 440 && y > 430) {
                notes[a] = "enote030.wav";
            }
            if (y <= 230 && y > 220 || y <= 450 && y > 440) {
                notes[a] = "cnote028.wav";
            }
            if (y <= 240 && y > 230 || y <= 460 && y > 450) {
                notes[a] = "bnote027.wav";
            }
            if (y <= 250 && y > 240 || y <= 470 && y > 460) {
                notes[a] = "025.wav";
            }
            if (y <= 260 && y > 250 || y <= 480 && y > 470) {
                notes[a] = "023.wav";
            }
            if (y <= 270 && y > 260 || y <= 490 && y > 480) {
                notes[a] = "021.wav";
                System.out.println(y);
            }
            
        return notes;
    }

}

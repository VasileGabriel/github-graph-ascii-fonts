
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gabriel
 */
public class Comitter {

    private String repo = "matrixrepo";
    private String output
            = "#!/bin/bash\n"
            + "REPO=" + repo + "\n"
            + "rm -rf $REPO\n"
            + "git init $REPO\n"
            + "cd $REPO\n"
            + "touch README.md\n"
            + "git add README.md\n"
            + "touch gitfiti\n"
            + "git add gitfiti\n";

    public void processPhrase(String phrase) {

        char[][] fonts = Fonts.getFonts();
        char character;
        int i;

        for (i = 0; i < phrase.length(); i++) {
            character = phrase.charAt(i);
            output += processCharacter(fonts[character], i);
            System.out.println();
        }
        output
                += "git remote add origin https://github.com/testcomitter/qqq.git\n"
                + "git push -u origin master\n";

        File file = new File("/home/gabriel/Code/sh/asd.sh");
        try {
            FileUtils.writeStringToFile(file, output);
        } catch (IOException ex) {
            Logger.getLogger(Comitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(output);
    }

    private String processCharacter(char[] rowChars, int charactersOffset) {
        int[][] matrix = new int[8][6];
        int weeksCount = 6;
        int weekDaysCount = 7;
        int totalDays = weeksCount * weekDaysCount;
        int charHeight = 8;
        int subDays;
        String dateAsString, output = "";
        int counter = 0;
        
        int i=0;
        for (char myChar : rowChars) {
            
            for (int bit=0; bit<8; bit++) {
                if ((myChar & (1L << bit)) != 0) {
                    matrix[bit][i] = 1;
                 } else {
                    matrix[bit][i] = 0;
                 }
            }
            i++;
        //System.out.println();
        }
        
        for (int asd=0; asd<totalDays; asd++) {
            dateAsString = LocalDateTime.now().minusDays(totalDays-asd+4+21+6*7*charactersOffset).toString();
            if (matrix[asd%weekDaysCount][asd/(weeksCount+1)] == 1) {
                output += "GIT_AUTHOR_DATE="+dateAsString+
                            " GIT_COMMITTER_DATE="+dateAsString+
                            " git commit --allow-empty -m \"ceva\" > /dev/null \n";
            }
            System.out.println("a[" + asd%weekDaysCount + "," + asd/(weeksCount+1) + "]="
                    +matrix[asd%weekDaysCount][asd/(weeksCount+1)]);
        }
        return output;
    }
}

package linkchecker;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HyperlinkCheckerLinear {
	
	private int depth;
    private int counter;
    private String link;
    private int valid = -1;
    private int invalid = 0;
    
    HyperlinkCheckerLinear(String link, int depth, int counter)
    {
    	this.link = link;
    	this.depth = depth;
    	this.counter = counter;
    }
    
    public void depth(String link, int current, int max) throws IOException {
        Checker c = new Checker();
        Links l = new Links();
        if (c.checkSingleLink(link) == false) {
            System.out.println("Invalid Link " + link);
            invalid++;
            return;
        } else if (c.checkSingleLink(link) == true) {
            System.out.println("Valid Link " + link);
            valid++;
            String[] data = l.getLinks(link);
            if (current > max) {
                return;
            } else {
                for (int i = 0; i < data.length; i++) {
                    depth(data[i], current+1, max);
                }
            }

        }
    }
    
    public void myProgram() throws InterruptedException {
        long startTime = System.nanoTime();
    	try {

            depth(link, 0, depth);

        } catch (IOException ex) {
            Logger.getLogger(HyperlinkChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.err.println("\nProgram has terminated. CONGRATULATIONS!");
        if(valid==-1)
        {
        	valid = -1;
           	invalid = 0;
			JFrame f = new JFrame();
			JOptionPane.showMessageDialog(f, "Input URL is invalid! (It should be a valid link starting with https://www. .....)");
        } 
        else
        {
            System.out.println("Valid count: " + valid + "\nInvalid count: " + invalid);
            long elapsedTime = System.nanoTime() - startTime;
            System.err.println("Time elapsed with " + counter + " threads" + " is: " + elapsedTime / 1000000 + " milliseconds.\n");
            new outputPanel(valid, invalid, elapsedTime/ 1000000 , counter).setVisible(true);	
        }
    }
}
   
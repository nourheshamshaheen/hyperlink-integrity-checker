package linkchecker;

import java.io.IOException;




public class runny implements Runnable{

	private String link;
	private int current;
	private int max;
	
	public runny(String link, int current, int max)
	{
		this.link = link;
		this.current = current;
		this.max = max;
	}
	@Override
	public void run()
	{
		try {
			HyperlinkChecker.depth(link, current+1, max);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR.");
			e.printStackTrace();
		}
	}
	
}
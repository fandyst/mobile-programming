import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Main extends MIDlet {
	Display display;

	public void startApp() {
		display = Display.getDisplay(this);
		display.setCurrent(new HitungLuas());
	}

	public void pauseApp() {

	}

	public void destroyApp(boolean unconditional) {

	}

}
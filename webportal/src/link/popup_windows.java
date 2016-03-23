package link;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Window;

public class popup_windows extends GenericForwardComposer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Window winReg;
	Window emailwin;
	public void onCreate$winReg()
	{
		winReg.doHighlighted();
		
	}
	public void onCreate$emailwin()
	{
		emailwin.doHighlighted();
		
	}
	
}

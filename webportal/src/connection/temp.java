package connection;
import java.util.*;

import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.util.*;
import org.zkoss.zk.ui.ext.*;
import org.zkoss.zk.au.*;
import org.zkoss.zk.au.out.*;
import org.zkoss.zul.*;

@SuppressWarnings("rawtypes")
public class temp extends GenericForwardComposer{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
Listbox lsb;
Button btn;
	@SuppressWarnings("unchecked")
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
          

	}
	public void onClick$btn()
	{
		List<Listitem> items = lsb.getItems();
		for (int i = 0;i < items.size();i ++) {
			if (i%2 == 0)
				Messagebox.show(items.get(i).toString());
		}
	}

}


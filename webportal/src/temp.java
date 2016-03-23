import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Window;


public class temp extends GenericForwardComposer{
 Window ee;
 public void onCreate$ee()
 {
	 alert(requestScope.get("name").toString());
 }
 
}

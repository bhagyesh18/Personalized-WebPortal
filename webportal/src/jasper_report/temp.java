package jasper_report;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Window;



import org.zkoss.zul.Label; 
public class temp extends GenericForwardComposer{
 Window ee;
Label lbl;

 public void onCreate$ee()
 {
	 //alert();
	lbl.setValue(requestScope.get("name").toString());
 }
 
}

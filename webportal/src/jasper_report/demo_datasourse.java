package jasper_report;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class demo_datasourse implements JRDataSource {

	private Object[][] data =
	{
		{"Berne", "bhagyesh","patel","bhagyesh","bhagyesh","bhagyesh","bhagyesh","bhagyesh","bhagyesh"},
		
	};

	

	@Override
	public Object getFieldValue(JRField field) throws JRException {
				Object value = null;
		
		String fieldName = field.getName();
			if ("emp_id".equals(fieldName))
			{
				value ="gfhjfhj";
			}
		/*else if ("user_id".equals(fieldName))
		{
			value ="111";
		}
		else if ("first_name".equals(fieldName))
		{
			value = data[index][1];
		}else if ("last_name".equals(fieldName))
		{
			value = data[index][1];
		}else if ("address".equals(fieldName))
		{
			value = data[index][1];
		}else if ("city_id".equals(fieldName))
		{
			value = "1";
		}else if ("email_id".equals(fieldName))
		{
			value = data[index][1];
		}else if ("mobile_no".equals(fieldName))
		{
			value = data[index][1];
		}else if ("emp_designation_id".equals(fieldName))
		{
			value = "1";
		}
		else if ("dateOfjoin".equals(fieldName))
		{
			value = "2012-02-02";
		}
		else if ("dateOfbirth".equals(fieldName))
		{
			value = "2012-02-02";
		}
		else if ("gender".equals(fieldName))
		{
			value = "1";
		}
		else if ("maritual_status".equals(fieldName))
		{
			value = "1";
		}
		else if ("status".equals(fieldName))
		{
			value = "1";
		}
*/		return value;
	}

	@Override
	public boolean next() throws JRException {
		// TODO Auto-generated method stub
		return false;
	}

	

}

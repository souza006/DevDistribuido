
import OlaApp.OlaPOA;
import org.omg.CORBA.ORB;

public class OlaServo extends OlaPOA {
	String msg = "\n Ola Teste\n";
	private ORB orb;
	
	public void setORB(ORB orb_val) {
		orb = orb_val;
	}
	
	@Override
	public String msg() {
		return msg;
	}

	@Override
	public void msg(String newMsg) {
		msg = newMsg;

	}

}

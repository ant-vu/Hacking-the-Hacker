import java.util.Random;

public abstract class Site {
		
	//---  Instance Variables   -------------------------------------------------------------------
	protected Random rand;
	protected String[] e;
	protected Encryptor protocol;
	public abstract void update();	
	public abstract String randomProtocol();
	public abstract String receiveMessage(String message, int type);
	public abstract String sendMessage(String message, int type);

}

import java.util.ArrayList;
import java.util.List;

public class Cerebus implements Encryptor {
	
	//---  Constants   ----------------------------------------------------------------------------
	private static final int CEREBUS_ONE = 18;
	private static final int CEREBUS_TWO = 31;
	private static final int CEREBUS_INIT_VALUE = 32;
	private static final int CEREBUS_ALPH_SIZE = 128;
	private static final int CEREBUS_KEY_ONE = 0;
	private static final int CEREBUS_KEY_TWO = 1;

	@Override
	public String encrypt(int am, String in) {
		StringBuilder out = new StringBuilder();
		String use = in.toLowerCase();
		for(char a : use.toCharArray()) {
			out.append((char) (((a + am - CEREBUS_INIT_VALUE) % CEREBUS_ALPH_SIZE) + CEREBUS_INIT_VALUE));
		}
		return out.toString();
	}

	@Override
	public String decrypt(int am, String in) {
		StringBuilder out = new StringBuilder();
		String use = in.toLowerCase();
		for(char a : use.toCharArray()) {
			out.append((char) (((a - am - CEREBUS_INIT_VALUE + CEREBUS_ALPH_SIZE) % CEREBUS_ALPH_SIZE) + CEREBUS_INIT_VALUE));
		}
		return out.toString();
	}
	
	public String encryptOne(String in) {
		return encrypt(CEREBUS_ONE, in);
	}
	
	public String encryptTwo(String in) {
		return encrypt(CEREBUS_TWO, in);
	}

	public String decryptOne(String in) {
		return decrypt(CEREBUS_ONE, in);
	}
	
	public String decryptTwo(String in) {
		return decrypt(CEREBUS_TWO, in);
	}

	@Override
	public String encrypt(int[] am, String in) {
		return null;
	}

	@Override
	public String decrypt(int[] am, String in) {
		return null;
	}		

	// observer
	private final List<Site> sites = new ArrayList<>();
	private String state;

	@Override
	public String getChange() {
	   return state;
	}
	
	@Override
	public void setChange(String state) {
		this.state = state;
	    notifyAllObservers();
	}
		
	@Override
	public void notifyAllObservers(){
		for (Site site : sites) {
			site.update();
		}
	}
	
	@Override
	public void attach(Site site) {
		sites.add(site);	
	}

	//check for the key while keeping it encapsulated
	@Override
	public Boolean key1(int type) {
		return type == CEREBUS_KEY_ONE;
	}

	@Override
	public Boolean key2(int type) {
		return type == CEREBUS_KEY_TWO;
	}

}

import java.util.ArrayList;
import java.util.List;

public class Ouroboros implements Encryptor {
	
	//---  Constants   ----------------------------------------------------------------------------
	private static final int[] OUROBOROS_ONE = new int[] {3, 1, 0, 2};
	private static final int[] OUROBOROS_TWO = new int[] {2, 5, 4, 1, 3, 0};
	private static final int OUROBOROS_KEY_ONE = 0;
	private static final int OUROBOROS_KEY_TWO = 1;

	@Override
	public String encrypt(int [] am, String in) {
		StringBuilder out = new StringBuilder();
		String use = in + new String(new char[am.length - (in.length() % am.length)]).replace("\0", " ");
		for(int i = 0; i < use.length(); i += am.length) {
			char[] next = new char[am.length];
			for(int j = 0; j < am.length; j++) {
				next[j] = use.charAt(i + am[j]);
			}
			out.append(new String(next));
		}
		return out.toString();
	}

	@Override
	public String decrypt(int [] am, String in) {
		StringBuilder out = new StringBuilder();
		String use = in+"";
		for(int i = 0; i < use.length(); i += am.length) {
			char[] next = new char[am.length];
			for(int j = 0; j < am.length; j++) {
				next[am[j]] = use.charAt(i + j);
			}
			out.append(new String(next));
		}
		return out.toString();
	}

	@Override
	public String encrypt(int am, String in) {
		return null;
	}

	@Override
	public String decrypt(int am, String in) {
		return null;
	}

	public String encryptOne(String in) {
		return encrypt(OUROBOROS_ONE, in);
	}
	
	public String encryptTwo(String in) {
		return encrypt(OUROBOROS_TWO, in);
	}
	
	public String decryptOne(String in) {
		return decrypt(OUROBOROS_ONE, in);
	}

	public String decryptTwo(String in) {
		return decrypt(OUROBOROS_TWO, in);
	}	
	
	//Observer
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
		return type == OUROBOROS_KEY_ONE;
	}

	@Override
	public Boolean key2(int type) {
		return type == OUROBOROS_KEY_TWO;
	}

}

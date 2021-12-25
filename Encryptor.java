public interface Encryptor {
	
	// encryption for lists of integers
	String encrypt(int[] am, String in);
	String decrypt(int[] am, String in);

	// encryption for single integers
	String encrypt(int am, String in);
	String decrypt(int am, String in);
	
	// others
	String encryptOne(String in);
	String decryptOne(String in);
	String encryptTwo(String in);
	String decryptTwo(String in);

	// observer
	String getChange();
	void setChange(String state);
	void notifyAllObservers();
	Boolean key1(int type);
	Boolean key2(int type);
	void attach(Site site);
	
}

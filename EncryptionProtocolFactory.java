public class EncryptionProtocolFactory {

	public Encryptor encryptionGenerator(String eName) {
		if(eName.equals("Ouroboros")) {
			return new Ouroboros();
		}
		else if(eName.equals("Cerebus")) {
			return new Cerebus();
		}
		return null;
	}

}

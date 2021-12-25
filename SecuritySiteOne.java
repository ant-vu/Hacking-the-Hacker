import java.util.Random;

public class SecuritySiteOne extends Site {
	EncryptionProtocolFactory eFactory = new EncryptionProtocolFactory(); // the factory to produce whatever encryption methods will be needed below
	// current assumed roster: String [] roster = {"Ouroboros", "Cerebus"};
	// the roster of protocols that can be selected from, while also allowing different rosters for different sites
	
	public SecuritySiteOne(String [] roster){
		this.e = roster;
		this.protocol = eFactory.encryptionGenerator(randomProtocol());
		this.protocol.attach(this); // observer
	}
	
	@Override
	public String receiveMessage(String message, int type) {
		if (this.protocol.key1(type)) {
			return this.protocol.decryptOne(message);
		}
		else if (protocol.key2(type)) {
			return this.protocol.decryptTwo(message);
		}
		else {
			return null;
		}
	}
	
	@Override
	public String sendMessage(String message, int type) {
		if (this.protocol.key1(type)) {
			return this.protocol.encryptOne(message);
		}
		else if (protocol.key2(type)) {
			return this.protocol.encryptTwo(message);
		}
		else {
			return null;
		}
	}

	@Override
	public void update() { // maybe different update message for what has changed, keys etc
		System.out.println( "Attention Security Site One, there has been a security update to the encryption protocols. Please update your security accordingly. The change is: " + protocol.getChange() );  // a unique message for the site to know when things have been updated while differentiating between recipients
	}

	@Override
	public String randomProtocol() {
		rand = new Random();
		return this.e[rand.nextInt(this.e.length)];
	}

}

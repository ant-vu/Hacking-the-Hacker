public class Runner {

    public static void main(String[] args) {

    	String[] roster = {"Ouroboros", "Cerebus"};
    	SecuritySiteOne site = new SecuritySiteOne(roster);
    	String scramble = site.sendMessage("Hello World", 1);
    	System.out.println(scramble);
    	System.out.println(site.receiveMessage(scramble, 1));

    }

}

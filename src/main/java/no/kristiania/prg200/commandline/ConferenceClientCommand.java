package no.kristiania.prg200.commandline;

public interface ConferenceClientCommand {
	
public default String getArgument(String[] args, String identifier ) {
		
		for (int i = 0; i < args.length; i++) {
			if(args[i].equals(identifier)) {
				String value = args[i + 1];
			
				System.out.println("argument input: " + value.toString());
				return value;
			}
			
		}
		return null;
	}	

}


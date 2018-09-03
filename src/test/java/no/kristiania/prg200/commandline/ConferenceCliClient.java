package no.kristiania.prg200.commandline;

import java.io.IOException;

public class ConferenceCliClient {


/*
 * Skal ListTalksCommand implementeres i decodeCommand, eller egen funksjon?
 */
	public ConferenceClientCommand decodeCommand(String[] strings) throws IOException {
		// TODO Auto-generated method stub
		
		String type = strings[0];
		switch (type ) {
		case "add":
			return constructAddCommand(strings);
		case "list":
			return constructListCommand(strings);
		case "remove":
			return constructUpdateCommand(strings);
		default:
			throw new IOException();
		}
		
		
		
		/*AddTalkCommand command = new AddTalkCommand();
		
		for (int i = 0; i < strings.length; i++) {
			if(strings[i].equals("-title")) {
				command.withTitle(strings[i+1]);
			} else if (strings[i].equals("-description")) {
				command.withDescription(strings[i + 1]);
			} else if(strings[i].equals("-topic")) {
				command.withTopic(strings[i+1]);
			}
		}
		return command;
	}
	
	public ConferenceClientCommand decodeListCommand(String[] strings) {
		ListTalksCommand listCommand = new ListTalksCommand();
		for (int i = 0; i < strings.length; i++) {
			if(strings[i].equals("-topic")) {
				listCommand.withTopic(strings[i+1]);
			}
		}
		return listCommand;	
	}
	
	public ConferenceClientCommand listAllTalksByTopic(String topic) {
		return null;
		
	}
	*/
	
	}
	
	private ConferenceClientCommand constructUpdateCommand(String[] strings) {
	// TODO Auto-generated method stub
	return null;
}

	private ListTalksCommand constructListCommand(String[] strings) {
		String list = "";
		
		return null;
}

	public AddTalkCommand constructAddCommand(String[] strings) {
		String title = getArgument("-title", strings, "unknown");
		String description = getArgument("-description", strings, "unknown");
		String topic = getArgument("-topic", strings, "unknown");
		
		return new AddTalkCommand().withTitle(title).withDescription(description).withTopic(topic);
		
	}

	private String getArgument(String identifier, String[] strings, String defaultValue) {
		
		for (int i = 0; i < strings.length - 1; i++) {
			if(strings[i].equals(identifier)) {
				String value = strings[i + 1];
				return value;
			}
			
		}
		
		return defaultValue;
	}
	
}

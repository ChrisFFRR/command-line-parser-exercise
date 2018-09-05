package no.kristiania.prg200.commandline;

import java.io.IOException;

public class ConferenceCliClient {

	private ListTalksCommand talksCommand = new ListTalksCommand();

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
	}
	
	private ConferenceClientCommand constructUpdateCommand(String[] strings) {
	return null;
}

	private ListTalksCommand constructListCommand(String[] strings) {
		String[] input = strings;
		String topic = getArgument("-topic", strings, "unknown");
		if(input[1].equals("-topic")) {	
			return new ListTalksCommand().withTopic(topic);
		}
		return new ListTalksCommand();
	}
			

	public AddTalkCommand constructAddCommand(String[] strings) {
		String title = getArgument("-title", strings, "unknown");
		String description = getArgument("-description", strings, "unknown");
		String topic = getArgument("-topic", strings, "unknown");
		
		return talksCommand.add(new AddTalkCommand().withTitle(title).withDescription(description).withTopic(topic));
		
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

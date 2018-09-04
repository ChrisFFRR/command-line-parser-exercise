package no.kristiania.prg200.commandline;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

public class ConferenceCliClient {



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

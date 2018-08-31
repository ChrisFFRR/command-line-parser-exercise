package no.kristiania.prg200.commandline;

public class ConferenceCliClient {


/*
 * Skal ListTalksCommand implementeres i decodeCommand, eller egen funksjon?
 */
	public ConferenceClientCommand decodeCommand(String[] strings) {
		// TODO Auto-generated method stub
		AddTalkCommand command = new AddTalkCommand();
		
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
	
	
	
}

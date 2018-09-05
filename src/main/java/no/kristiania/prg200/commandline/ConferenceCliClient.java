package no.kristiania.prg200.commandline;



public class ConferenceCliClient {


	public ConferenceClientCommand decodeCommand(String[] args) {
		
		if(args[0].equals("list")) {
			ListTalksCommand command = new ListTalksCommand();
			command.readArguments(args);
			return command;
		}
		
		AddTalkCommand command = new AddTalkCommand();
		
		command.readArguments(args);
		System.out.println(command.toString());
		return command;
		
	}
}

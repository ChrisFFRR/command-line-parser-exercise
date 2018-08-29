package no.kristiania.prg200.commandline;

public class AddTalkCommand implements ConferenceClientCommand {

	private String title;
	private String description;
	private String topic;

	public AddTalkCommand withTitle(String title) {
		this.title = title;
		// TODO Auto-generated method stub
		return this;
	}
	public AddTalkCommand withDescription(String description) {
		this.description = description;
		// TODO Auto-generated method stub
		return this;
	}
	public AddTalkCommand withTopic(String topic) {
		this.topic = topic;
		// TODO Auto-generated method stub
		return this;
	}
}

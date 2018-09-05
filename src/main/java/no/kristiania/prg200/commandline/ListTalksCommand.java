package no.kristiania.prg200.commandline;


public class ListTalksCommand implements ConferenceClientCommand{

	
	private String topic;
	
	public ListTalksCommand withTopic(String topic) {
		this.setTopic(topic);
		return this;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public void readArguments(String[] args) {
		setTopic(getArgument(args, "-topic"));
	}
}

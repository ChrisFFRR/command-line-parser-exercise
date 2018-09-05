package no.kristiania.prg200.commandline;

import java.util.List;

public class ListTalksCommand implements ConferenceClientCommand{

	private List<AddTalkCommand> talks;
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

	public ListTalksCommand getAllTalks() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public AddTalkCommand add(AddTalkCommand talk) {
		talks.add(talk);
		
		return talk;
	}
	
	
}

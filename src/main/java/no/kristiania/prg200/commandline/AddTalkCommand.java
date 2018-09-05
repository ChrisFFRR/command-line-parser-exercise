package no.kristiania.prg200.commandline;

public class AddTalkCommand implements ConferenceClientCommand {

	private String title;
	private String description;
	private String topic;


	public AddTalkCommand withTitle(String title) {
		this.setTitle(title);
		// TODO Auto-generated method stub
		return this;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public AddTalkCommand withDescription(String description) {
		this.setDescription(description);
		// TODO Auto-generated method stub
		return this;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public AddTalkCommand withTopic(String topic) {
		this.setTopic(topic);
		// TODO Auto-generated method stub
		return this;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	
}

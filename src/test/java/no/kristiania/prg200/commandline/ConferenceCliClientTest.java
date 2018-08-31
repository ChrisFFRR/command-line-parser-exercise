package no.kristiania.prg200.commandline;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.Test;


public class ConferenceCliClientTest {

    private ConferenceCliClient client = new ConferenceCliClient();

    @Test
    public void shouldDecodeAddCommand() {
    	String topic = SampleData.sampleTopic();
        String title = SampleData.sampleText(5);
        String description = SampleData.sampleText(10);
		ConferenceClientCommand command = client.decodeCommand(new String[] { 
        		"add",
        		"-topic", topic,
        		"-title", title,
        		"-description", description
        		});
        AddTalkCommand expectedCommand = new AddTalkCommand().withTopic(topic).withTitle(title).withDescription(description);
		assertThat(command)
		.isInstanceOf(AddTalkCommand.class)
		.isEqualToComparingFieldByField(expectedCommand);
    }
    
    
    @Test 
    public void shouldDecodeListCommand() {
    	String topic = SampleData.sampleTopic();
    	
    	ConferenceClientCommand command = client.decodeCommand(new String[] {
    			"list","-topic", topic
    			});
    	ListTalksCommand expectedCommand = new ListTalksCommand().withTopic(topic);
    	
    	assertThat(command)
    	.isInstanceOf(ListTalksCommand.class)
    	.isEqualToComparingFieldByField(expectedCommand);
    	}
    	
 }

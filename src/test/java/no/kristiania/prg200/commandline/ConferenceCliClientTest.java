package no.kristiania.prg200.commandline;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;

import no.kristiania.prg200.commandline.AddTalkCommand;
import no.kristiania.prg200.commandline.ConferenceCliClient;
import no.kristiania.prg200.commandline.ConferenceClientCommand;
import no.kristiania.prg200.commandline.ListTalksCommand;


public class ConferenceCliClientTest {

    private ConferenceCliClient client = new ConferenceCliClient();

    @Test
    public void shouldDecodeAddCommand() throws IOException {
    	String topic = SampleData.sampleTopic();
        String title = SampleData.sampleText(5);
        String description = SampleData.sampleText(10);
		ConferenceClientCommand command = client.decodeCommand(new String[] { 
        		"add",
        		"-topic", topic,
        		"-title", title,
        		"-description", description
        		});
        AddTalkCommand expectedCommand = new AddTalkCommand().withTitle(title).withDescription(description).withTopic(topic);
		
        assertThat(command)
        .isInstanceOf(AddTalkCommand.class)
		.isEqualToComparingFieldByField(expectedCommand);
    }
    
    @Test
    public void ShouldReturnTitleAndDescriptionAndTopic() {
    	String title = SampleData.sampleText(3);
    	String description = SampleData.sampleText(5);
    	String topic = SampleData.sampleTopic();
    	
    	ConferenceClientCommand command = client.constructAddCommand(new String[] {    		
    		"-title", title,
    		"-description", description,
    		"-topic", topic
    		});
    	
    	AddTalkCommand expectedCommand = new AddTalkCommand().withTitle(title).withDescription(description).withTopic(topic);
    	
    	assertThat(command)
    	.isInstanceOfAny(AddTalkCommand.class)
    	.isEqualToComparingFieldByField(expectedCommand);
    }
    //Incomplete
    @Test 
    public void shouldDecodeListWithTopicCommand() throws IOException {
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

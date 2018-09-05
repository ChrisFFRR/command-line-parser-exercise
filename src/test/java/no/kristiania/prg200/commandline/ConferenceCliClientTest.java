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
    public void shouldDecodeAddCommand() {
        String title = SampleData.sampleText(5);
        String description = SampleData.sampleText(10);
		ConferenceClientCommand command = client.decodeCommand(new String[] { 
        		"add",
        		"-title", title,
        		"-description", description
        		});
        AddTalkCommand expectedCommand = new AddTalkCommand().withTitle(title).withDescription(description);
		
        assertThat(command)
        .isInstanceOf(AddTalkCommand.class)
		.isEqualToComparingFieldByField(expectedCommand);
    }
    
    @Test
    public void ShouldDecodeAddCommandWithTopic() {
    	String title = SampleData.sampleText(3);
    	String description = SampleData.sampleText(5);
    	String topic = SampleData.sampleTopic();
    	
    	ConferenceClientCommand command = client.decodeCommand(new String[] {    	
    		"add",
    		"-title", title,
    		"-description", description,
    		"-topic", topic
    		});
    	
    	AddTalkCommand expectedCommand = new AddTalkCommand().withTitle(title).withTopic(topic).withDescription(description);
    	
    	assertThat(command)
    	.isInstanceOfAny(AddTalkCommand.class)
    	.isEqualToComparingFieldByField(expectedCommand);
    }
    //Incomplete
    @Test 
    public void shouldDecodeListCommandWithTopic() throws IOException {
    	String title = SampleData.sampleText(5);
    	String description = SampleData.sampleText(10);
    	String topic = SampleData.sampleTopic();
    	
    	ConferenceClientCommand command = client.decodeCommand(new String[] {
    			"list",
    			"-topic", topic
    	});
    	ListTalksCommand expectedCommand = new ListTalksCommand();
    	expectedCommand.withTopic(topic);
    	assertThat(command)
    	.isInstanceOf(ListTalksCommand.class)
    	.isEqualToComparingFieldByField(expectedCommand);
    }
 }

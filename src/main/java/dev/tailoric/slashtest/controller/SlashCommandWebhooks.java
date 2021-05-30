package dev.tailoric.slashtest.controller;

import dev.tailoric.slashtest.model.InteractionReceive;
import dev.tailoric.slashtest.model.InteractionResponse;
import dev.tailoric.slashtest.model.discord.InteractionApplicationCommandCallbackData;
import dev.tailoric.slashtest.model.discord.InteractionCallbackType;
import dev.tailoric.slashtest.model.discord.InteractionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping
public class SlashCommandWebhooks {

    /***
     * The hello world command, simply should only reply with hello.
     * @return A interaction response containing the content "hello world"
     */
    public InteractionResponse helloCommand(){
        var response = new InteractionResponse();
        response.setType(InteractionCallbackType.ChannelMessageWithSource);
        var data = new InteractionApplicationCommandCallbackData();
        data.setTts(false);
        data.setContent("hello world");
        data.setEmbeds(new ArrayList<>());
        return response;
    }

    /**
     * The endpoint responsible for reacting to slash commands
     * TODO: Maybe create something like a command handler currently only replies to PING requests or replies to the hello
     * @param interaction The interaction receive object see https://discord.com/developers/docs/interactions/slash-commands#interaction
     * @return An InteractionResponse which is currently either a PONG to a PING or the hello result
     */
    @RequestMapping(value = "/slash/incoming", method = RequestMethod.POST, produces = "application/json")
    public InteractionResponse receive(@RequestBody InteractionReceive interaction) {
        if(interaction.getType().equals(InteractionType.PING)){
            var pong = new InteractionResponse();
            pong.setType(InteractionCallbackType.Pong);
            return pong;
        }
        return helloCommand();
    }

}

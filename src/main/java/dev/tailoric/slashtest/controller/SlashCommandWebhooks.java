package dev.tailoric.slashtest.controller;

import dev.tailoric.slashtest.model.InteractionReceive;
import dev.tailoric.slashtest.model.InteractionResponse;
import dev.tailoric.slashtest.model.discord.AllowedMentions;
import dev.tailoric.slashtest.model.discord.InteractionApplicationCommandCallbackData;
import dev.tailoric.slashtest.model.discord.InteractionCallbackType;
import dev.tailoric.slashtest.model.discord.InteractionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping
public class SlashCommandWebhooks {

    public InteractionResponse helloCommand(){
        var response = new InteractionResponse();
        response.setType(InteractionCallbackType.ChannelMessageWithSource);
        var data = new InteractionApplicationCommandCallbackData();
        data.setTts(false);
        data.setContent("hello world");
        data.setEmbeds(new ArrayList<>());
        return response;
    }
    @RequestMapping(value = "/slash/incoming", method = RequestMethod.POST, produces = "application/json")
    public InteractionResponse receive(@RequestBody InteractionReceive interaction, HttpServletRequest request) {
        if(interaction.getType().equals(InteractionType.PING)){
            var pong = new InteractionResponse();
            pong.setType(InteractionCallbackType.Pong);
            return pong;
        }
        return helloCommand();
    }

}

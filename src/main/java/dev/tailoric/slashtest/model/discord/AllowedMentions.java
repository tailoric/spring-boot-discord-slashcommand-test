package dev.tailoric.slashtest.model.discord;

import java.util.List;

public class AllowedMentions {
    List<String> parse;
    List<Long> roles;
    List<Long> users;
    boolean repliedUser;
}

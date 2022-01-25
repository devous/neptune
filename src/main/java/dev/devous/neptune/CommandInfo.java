package dev.devous.neptune;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public record CommandInfo(@NotNull CommandHandler handler,
                          @NotNull SlashCommandEvent event,
                          @NotNull String usage) {
    public @NotNull List<OptionMapping> optionData() {
        return event.getOptions();
    }

    public @NotNull MessageChannel channel() {
        return event.getChannel();
    }

    public @NotNull String message() {
        return "/" + event.getName() + " " + buildMessage();
    }

    private @NotNull String buildMessage() {
        StringBuilder builder = new StringBuilder();
        for (OptionMapping option : event.getOptions()) {
            builder.append(option.getAsString()).append(" ");
        }
        return builder.toString();
    }

    public @NotNull String[] args() {
        return Arrays.copyOfRange(message().split("\\s+"), 1,
                message().split("\\s+").length);
    }

    public @NotNull User author() {
        return event.getUser();
    }

    public @Nullable Member member() {
        return event.getMember();
    }

    public @NotNull JDA jda() {
        return event.getJDA();
    }

    @Override
    public @NotNull String toString() {
        return "CommandInfo{" +
                "handler=" + handler +
                ", message=" + message() +
                ", usage='" + usage + '\'' +
                '}';
    }
}

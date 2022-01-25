package dev.devous.neptune;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {
    String label();

    String usage() default "";

    String[] aliases() default {};

    String description() default "";

    long roleId() default 0L;

    long guildId() default 0L;

    boolean log() default false;
}

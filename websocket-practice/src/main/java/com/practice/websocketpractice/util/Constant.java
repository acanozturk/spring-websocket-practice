package com.practice.websocketpractice.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {

    @UtilityClass
    public class Collection {

        public final String CHAT_MESSAGES = "chat-messages";

    }

    @UtilityClass
    public class Destination {

        public final String APP_PREFIX = "/app";

    }

    @UtilityClass
    public class Endpoint {

        public final String CHAT = "/chat";

    }

    @UtilityClass
    public class Topic {

        public final String TOPIC_PREFIX = "/topic";

        public final String CHAT_MESSAGES = TOPIC_PREFIX + "/chat-messages";

    }

}

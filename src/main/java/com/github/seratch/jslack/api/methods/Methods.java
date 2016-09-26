package com.github.seratch.jslack.api.methods;

public class Methods {

    private Methods() {
    }

    // ------------------------------
    // api
    // ------------------------------

    public static final String API_TEST = "api.test";

    // ------------------------------
    // auth
    // ------------------------------

    public static final String AUTH_REVOKE = "auth.revoke";
    public static final String AUTH_TEST = "auth.test";


    // ------------------------------
    // channels
    // ------------------------------


    public static final String CHANNELS_LIST = "channels.list";


    // ------------------------------
    // chat
    // ------------------------------

    public static final String CHAT_DELETE = "chat.delete";
    public static final String CHAT_ME_MESSAGE = "chat.meMessage";
    public static final String CHAT_POST_MESSAGE = "chat.postMessage";
    public static final String CHAT_UPDATE = "chat.update";



    // ------------------------------
    // emoji
    // ------------------------------

    public static final String EMOJI_LIST = "emoji.list";

   
   

    // ------------------------------
    // oauth
    // ------------------------------

    public static final String OAUTH_ACCESS = "oauth.access";

    // ------------------------------
    // pins
    // ------------------------------

    public static final String PINS_ADD = "pins.add";
    public static final String PINS_LIST = "pins.list";
    public static final String PINS_REMOVE = "pins.remove";

    // ------------------------------
    // reactions
    // ------------------------------

    public static final String REACTIONS_ADD = "reactions.add";
    public static final String REACTIONS_GET = "reactions.get";
    public static final String REACTIONS_LIST = "reactions.list";
    public static final String REACTIONS_REMOVE = "reactions.remove";

    // ------------------------------
    // rtm
    // ------------------------------

    public static final String RTM_START = "rtm.start";


    // ------------------------------
    // stars
    // ------------------------------

    public static final String STARS_ADD = "stars.add";
    public static final String STARS_LIST = "stars.list";
    public static final String STARS_REMOVE = "stars.remove";



    // ------------------------------
    // users
    // ------------------------------

    public static final String USERS_GET_PRESENCE = "users.getPresence";
    public static final String USERS_IDENTITY = "users.identity";
    public static final String USERS_INFO = "users.info";
    public static final String USERS_LIST = "users.list";
    public static final String USERS_SET_ACTIVE = "users.setActive";
    public static final String USERS_SET_PRESENCE = "users.setPresence";


}

package com.github.seratch.jslack.api.methods.impl;

import com.github.seratch.jslack.api.methods.Methods;
import com.github.seratch.jslack.api.methods.MethodsClient;
import com.github.seratch.jslack.api.methods.SlackApiException;
import com.github.seratch.jslack.api.methods.request.api.ApiTestRequest;
import com.github.seratch.jslack.api.methods.request.auth.AuthRevokeRequest;
import com.github.seratch.jslack.api.methods.request.auth.AuthTestRequest;
import com.github.seratch.jslack.api.methods.request.channels.*;
import com.github.seratch.jslack.api.methods.request.chat.ChatDeleteRequest;
import com.github.seratch.jslack.api.methods.request.chat.ChatMeMessageRequest;
import com.github.seratch.jslack.api.methods.request.chat.ChatPostMessageRequest;
import com.github.seratch.jslack.api.methods.request.chat.ChatUpdateRequest;
import com.github.seratch.jslack.api.methods.request.emoji.EmojiListRequest;
import com.github.seratch.jslack.api.methods.request.oauth.OAuthAccessRequest;
import com.github.seratch.jslack.api.methods.request.pins.PinsAddRequest;
import com.github.seratch.jslack.api.methods.request.pins.PinsListRequest;
import com.github.seratch.jslack.api.methods.request.pins.PinsRemoveRequest;
import com.github.seratch.jslack.api.methods.request.reactions.ReactionsAddRequest;
import com.github.seratch.jslack.api.methods.request.reactions.ReactionsGetRequest;
import com.github.seratch.jslack.api.methods.request.reactions.ReactionsListRequest;
import com.github.seratch.jslack.api.methods.request.reactions.ReactionsRemoveRequest;
import com.github.seratch.jslack.api.methods.request.reminders.*;
import com.github.seratch.jslack.api.methods.request.rtm.RTMStartRequest;
import com.github.seratch.jslack.api.methods.request.search.SearchAllRequest;
import com.github.seratch.jslack.api.methods.request.search.SearchFilesRequest;
import com.github.seratch.jslack.api.methods.request.search.SearchMessagesRequest;
import com.github.seratch.jslack.api.methods.request.stars.StarsAddRequest;
import com.github.seratch.jslack.api.methods.request.stars.StarsListRequest;
import com.github.seratch.jslack.api.methods.request.stars.StarsRemoveRequest;
import com.github.seratch.jslack.api.methods.request.team.TeamAccessLogsRequest;
import com.github.seratch.jslack.api.methods.request.team.TeamBillableInfoRequest;
import com.github.seratch.jslack.api.methods.request.team.TeamInfoRequest;
import com.github.seratch.jslack.api.methods.request.team.TeamIntegrationLogsRequest;
import com.github.seratch.jslack.api.methods.request.team.profile.TeamProfileGetRequest;
import com.github.seratch.jslack.api.methods.request.usergroups.*;
import com.github.seratch.jslack.api.methods.request.usergroups.users.UsergroupUsersListRequest;
import com.github.seratch.jslack.api.methods.request.usergroups.users.UsergroupUsersUpdateRequest;
import com.github.seratch.jslack.api.methods.request.users.*;
import com.github.seratch.jslack.api.methods.request.users.profile.UsersProfileGetRequest;
import com.github.seratch.jslack.api.methods.request.users.profile.UsersProfileSetRequest;
import com.github.seratch.jslack.api.methods.response.api.ApiTestResponse;
import com.github.seratch.jslack.api.methods.response.auth.AuthRevokeResponse;
import com.github.seratch.jslack.api.methods.response.auth.AuthTestResponse;
import com.github.seratch.jslack.api.methods.response.channels.*;
import com.github.seratch.jslack.api.methods.response.chat.ChatDeleteResponse;
import com.github.seratch.jslack.api.methods.response.chat.ChatMeMessageResponse;
import com.github.seratch.jslack.api.methods.response.chat.ChatPostMessageResponse;
import com.github.seratch.jslack.api.methods.response.chat.ChatUpdateResponse;
import com.github.seratch.jslack.api.methods.response.emoji.EmojiListResponse;
import com.github.seratch.jslack.api.methods.response.oauth.OAuthAccessResponse;
import com.github.seratch.jslack.api.methods.response.pins.PinsAddResponse;
import com.github.seratch.jslack.api.methods.response.pins.PinsListResponse;
import com.github.seratch.jslack.api.methods.response.pins.PinsRemoveResponse;
import com.github.seratch.jslack.api.methods.response.reactions.ReactionsAddResponse;
import com.github.seratch.jslack.api.methods.response.reactions.ReactionsGetResponse;
import com.github.seratch.jslack.api.methods.response.reactions.ReactionsListResponse;
import com.github.seratch.jslack.api.methods.response.reactions.ReactionsRemoveResponse;
import com.github.seratch.jslack.api.methods.response.reminders.*;
import com.github.seratch.jslack.api.methods.response.rtm.RTMStartResponse;
import com.github.seratch.jslack.api.methods.response.search.SearchAllResponse;
import com.github.seratch.jslack.api.methods.response.search.SearchFilesResponse;
import com.github.seratch.jslack.api.methods.response.search.SearchMessagesResponse;
import com.github.seratch.jslack.api.methods.response.stars.StarsAddResponse;
import com.github.seratch.jslack.api.methods.response.stars.StarsListResponse;
import com.github.seratch.jslack.api.methods.response.stars.StarsRemoveResponse;
import com.github.seratch.jslack.api.methods.response.team.TeamAccessLogsResponse;
import com.github.seratch.jslack.api.methods.response.team.TeamBillableInfoResponse;
import com.github.seratch.jslack.api.methods.response.team.TeamInfoResponse;
import com.github.seratch.jslack.api.methods.response.team.TeamIntegrationLogsResponse;
import com.github.seratch.jslack.api.methods.response.team.profile.TeamProfileGetResponse;
import com.github.seratch.jslack.api.methods.response.usergroups.*;
import com.github.seratch.jslack.api.methods.response.usergroups.users.UsergroupUsersListResponse;
import com.github.seratch.jslack.api.methods.response.usergroups.users.UsergroupUsersUpdateResponse;
import com.github.seratch.jslack.api.methods.response.users.*;
import com.github.seratch.jslack.api.methods.response.users.profile.UsersProfileGetResponse;
import com.github.seratch.jslack.api.methods.response.users.profile.UsersProfileSetResponse;
import com.github.seratch.jslack.common.http.SlackHttpClient;
import com.github.seratch.jslack.common.json.GsonFactory;
import lombok.extern.slf4j.Slf4j;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.Response;

import java.io.IOException;

import static java.util.stream.Collectors.joining;

@Slf4j
public class MethodsClientImpl implements MethodsClient {

    public static final String ENDPOINT_URL_PREFIX = "https://slack.com/api/";

    private final SlackHttpClient slackHttpClient = new SlackHttpClient();

    // ----------------------------------------------------------------------------------
    // public methods
    // ----------------------------------------------------------------------------------
    @Override
    public ApiTestResponse apiTest(ApiTestRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("foo", req.getFoo(), form);
        setIfNotNull("error", req.getError(), form);
        return doPostForm(form, Methods.API_TEST, ApiTestResponse.class);
    }

    @Override
    public AuthRevokeResponse authRevoke(AuthRevokeRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("test", req.getTest(), form);
        return doPostForm(form, Methods.AUTH_REVOKE, AuthRevokeResponse.class);
    }

    @Override
    public AuthTestResponse authTest(AuthTestRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        return doPostForm(form, Methods.AUTH_TEST, AuthTestResponse.class);
    }

    @Override
    public ChannelsListResponse channelsList(ChannelsListRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("exclude_archived", req.getExcludeArchived(), form);
        return doPostForm(form, Methods.CHANNELS_LIST, ChannelsListResponse.class);
    }

    @Override
    public ChatDeleteResponse chatDelete(ChatDeleteRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("channel", req.getChannel(), form);
        setIfNotNull("ts", req.getTs(), form);
        return doPostForm(form, Methods.CHAT_DELETE, ChatDeleteResponse.class);
    }

    @Override
    public ChatMeMessageResponse chatMeMessage(ChatMeMessageRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("channel", req.getChannel(), form);
        setIfNotNull("text", req.getText(), form);
        return doPostForm(form, Methods.CHAT_ME_MESSAGE, ChatMeMessageResponse.class);
    }

    @Override
    public ChatPostMessageResponse chatPostMessage(ChatPostMessageRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("channel", req.getChannel(), form);
        setIfNotNull("text", req.getText(), form);
        setIfNotNull("parse", req.getParse(), form);
        setIfNotNull("link_names", req.getLinkNames(), form);
        if (req.getAttachments() != null) {
            String json = GsonFactory.createSnakeCase().toJson(req.getAttachments());
            form.add("attachments", json);
        }
        setIfNotNull("unfurl_links", req.isUnfurlLinks(), form);
        setIfNotNull("unfurl_media", req.isUnfurlMedia(), form);
        setIfNotNull("username", req.getUsername(), form);
        setIfNotNull("as_user", req.isAsUser(), form);
        setIfNotNull("icon_url", req.getIconUrl(), form);
        setIfNotNull("icon_emoji", req.getIconEmoji(), form);
        return doPostForm(form, Methods.CHAT_POST_MESSAGE, ChatPostMessageResponse.class);
    }

    @Override
    public ChatUpdateResponse chatUpdate(ChatUpdateRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("ts", req.getTs(), form);
        setIfNotNull("channel", req.getChannel(), form);
        setIfNotNull("text", req.getText(), form);
        setIfNotNull("parse", req.getParse(), form);
        setIfNotNull("link_names", req.getLinkNames(), form);
        if (req.getAttachments() != null) {
            String json = GsonFactory.createSnakeCase().toJson(req.getAttachments());
            form.add("attachments", json);
        }
        setIfNotNull("as_user", req.isAsUser(), form);
        return doPostForm(form, Methods.CHAT_UPDATE, ChatUpdateResponse.class);
    }

    @Override
    public EmojiListResponse emojiList(EmojiListRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        return doPostForm(form, Methods.EMOJI_LIST, EmojiListResponse.class);
    }

    @Override
    public OAuthAccessResponse oauthAccess(OAuthAccessRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("client_id", req.getClientId(), form);
        setIfNotNull("client_secret", req.getClientSecret(), form);
        setIfNotNull("code", req.getCode(), form);
        setIfNotNull("redirect_uri", req.getRedirectUri(), form);
        return doPostForm(form, Methods.OAUTH_ACCESS, OAuthAccessResponse.class);
    }

    @Override
    public PinsAddResponse pinsAdd(PinsAddRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("channel", req.getChannel(), form);
        setIfNotNull("file", req.getFile(), form);
        setIfNotNull("file_comment", req.getFileComment(), form);
        setIfNotNull("timestamp", req.getTimestamp(), form);
        return doPostForm(form, Methods.PINS_ADD, PinsAddResponse.class);
    }

    @Override
    public PinsListResponse pinsList(PinsListRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("channel", req.getChannel(), form);
        return doPostForm(form, Methods.PINS_LIST, PinsListResponse.class);
    }

    @Override
    public PinsRemoveResponse pinsRemove(PinsRemoveRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("channel", req.getChannel(), form);
        setIfNotNull("file", req.getFile(), form);
        setIfNotNull("file_comment", req.getFileComment(), form);
        setIfNotNull("timestamp", req.getTimestamp(), form);
        return doPostForm(form, Methods.PINS_REMOVE, PinsRemoveResponse.class);
    }

    @Override
    public ReactionsAddResponse reactionsAdd(ReactionsAddRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("name", req.getName(), form);
        setIfNotNull("file", req.getFile(), form);
        setIfNotNull("file_comment", req.getFileComment(), form);
        setIfNotNull("channel", req.getChannel(), form);
        setIfNotNull("timestamp", req.getTimestamp(), form);
        return doPostForm(form, Methods.REACTIONS_ADD, ReactionsAddResponse.class);
    }

    @Override
    public ReactionsGetResponse reactionsGet(ReactionsGetRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("file", req.getFile(), form);
        setIfNotNull("file_comment", req.getFileComment(), form);
        setIfNotNull("channel", req.getChannel(), form);
        setIfNotNull("timestamp", req.getTimestamp(), form);
        setIfNotNull("full", req.isFull(), form);
        return doPostForm(form, Methods.REACTIONS_GET, ReactionsGetResponse.class);
    }

    @Override
    public ReactionsListResponse reactionsList(ReactionsListRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("user", req.getUser(), form);
        setIfNotNull("full", req.isFull(), form);
        setIfNotNull("count", req.getCount(), form);
        setIfNotNull("page", req.getPage(), form);
        return doPostForm(form, Methods.REACTIONS_LIST, ReactionsListResponse.class);
    }

    @Override
    public ReactionsRemoveResponse reactionsRemove(ReactionsRemoveRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("name", req.getName(), form);
        setIfNotNull("file", req.getFile(), form);
        setIfNotNull("file_comment", req.getFileComment(), form);
        setIfNotNull("channel", req.getChannel(), form);
        setIfNotNull("timestamp", req.getTimestamp(), form);
        return doPostForm(form, Methods.REACTIONS_REMOVE, ReactionsRemoveResponse.class);
    }

  

    @Override
    public RTMStartResponse rtmStart(RTMStartRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        return doPostForm(form, Methods.RTM_START, RTMStartResponse.class);
    }
    @Override
    public StarsAddResponse starsAdd(StarsAddRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("channel", req.getChannel(), form);
        setIfNotNull("file", req.getFile(), form);
        setIfNotNull("file_comment", req.getFileComment(), form);
        setIfNotNull("timestamp", req.getTimestamp(), form);
        return doPostForm(form, Methods.STARS_ADD, StarsAddResponse.class);
    }

    @Override
    public StarsListResponse starsList(StarsListRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("count", req.getCount(), form);
        setIfNotNull("page", req.getPage(), form);
        return doPostForm(form, Methods.STARS_LIST, StarsListResponse.class);
    }

    @Override
    public StarsRemoveResponse starsRemove(StarsRemoveRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("channel", req.getChannel(), form);
        setIfNotNull("file", req.getFile(), form);
        setIfNotNull("file_comment", req.getFileComment(), form);
        setIfNotNull("timestamp", req.getTimestamp(), form);
        return doPostForm(form, Methods.STARS_REMOVE, StarsRemoveResponse.class);
    }


    @Override
    public UsersGetPresenceResponse usersGetPresence(UsersGetPresenceRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("user", req.getUser(), form);
        return doPostForm(form, Methods.USERS_GET_PRESENCE, UsersGetPresenceResponse.class);
    }

    @Override
    public UsersIdentityResponse usersIdentity(UsersIdentityRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        return doPostForm(form, Methods.USERS_IDENTITY, UsersIdentityResponse.class);
    }

    @Override
    public UsersInfoResponse usersInfo(UsersInfoRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("user", req.getUser(), form);
        return doPostForm(form, Methods.USERS_INFO, UsersInfoResponse.class);
    }

    @Override
    public UsersListResponse usersList(UsersListRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("presence", req.getPresence(), form);
        return doPostForm(form, Methods.USERS_LIST, UsersListResponse.class);
    }

    @Override
    public UsersSetActiveResponse usersSetActive(UsersSetActiveRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        return doPostForm(form, Methods.USERS_SET_ACTIVE, UsersSetActiveResponse.class);
    }

    @Override
    public UsersSetPresenceResponse usersSetPresence(UsersSetPresenceRequest req) throws IOException, SlackApiException {
        FormBody.Builder form = new FormBody.Builder();
        setIfNotNull("token", req.getToken(), form);
        setIfNotNull("presence", req.getPresence(), form);
        return doPostForm(form, Methods.USERS_SET_PRESENCE, UsersSetPresenceResponse.class);
    }
    // ----------------------------------------------------------------------------------
    // private methods
    // ----------------------------------------------------------------------------------
    private static void setIfNotNull(String name, Object value, FormBody.Builder form) {
        if (value != null) {
            form.add(name, String.valueOf(value));
        }
    }

    private static void setIfNotNull(String name, Object value, MultipartBody.Builder form) {
        if (value != null) {
            form.addFormDataPart(name, String.valueOf(value));
        }
    }

    private <T> T doPostForm(FormBody.Builder form, String endpoint, Class<T> clazz) throws IOException, SlackApiException {
        Response response = slackHttpClient.postForm(ENDPOINT_URL_PREFIX + endpoint, form.build());
        return SlackHttpClient.buildJsonResponse(response, clazz);
    }

    private <T> T doPostMultipart(MultipartBody.Builder form, String endpoint, Class<T> clazz) throws IOException, SlackApiException {
        form.setType(MultipartBody.FORM);
        Response response = slackHttpClient.postMultipart(ENDPOINT_URL_PREFIX + endpoint, form.build());
        return SlackHttpClient.buildJsonResponse(response, clazz);
    }

}

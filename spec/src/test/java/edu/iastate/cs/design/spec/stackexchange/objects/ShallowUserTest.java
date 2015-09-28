package edu.iastate.cs.design.spec.stackexchange.objects;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ShallowUserTest {

    @Test
    public void deserialize() {
        String json = "{" +
                "\"reputation\": 9001," +
                "\"user_id\": 1," +
                "\"user_type\": \"registered\"," +
                "\"accept_rate\": 55," +
                "\"profile_image\": \"https://www.gravatar.com/avatar/a007be5a61f6aa8f3e85ae2fc18dd66e?d=identicon&r=PG\"," +
                "\"display_name\": \"Example User\"," +
                "\"badge_counts\": {  \"bronze\": 1,\n" +
                "  \"silver\": 2,\n" +
                "  \"gold\": 3},"+
                "\"link\": \"http://example.stackexchange.com/users/1/example-user\"" +
                "}";
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        ShallowUser shallowUser = gson.fromJson(json, ShallowUser.class);
        BadgeCount expectedBadgeCount = new BadgeCount(1, 2, 3);
        assertEquals(9001, shallowUser.getReputation());
        assertEquals(1, shallowUser.getUserId());
        assertEquals(User.REGISTERED_USER_TYPE, shallowUser.getUserType());
        assertEquals(55, shallowUser.getAcceptRate());
        assertEquals("https://www.gravatar.com/avatar/a007be5a61f6aa8f3e85ae2fc18dd66e?d=identicon&r=PG", shallowUser.getProfileImage());
        assertEquals("Example User", shallowUser.getDisplayName());
        assertEquals(expectedBadgeCount, shallowUser.getBadgeCounts());
        assertEquals("http://example.stackexchange.com/users/1/example-user", shallowUser.getLink());
    }
}

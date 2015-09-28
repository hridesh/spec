package edu.iastate.cs.design.spec.stackexchange.objects;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by chanika on 9/23/2015.
 */
public class BadgeCountTest {

    @Test
    public void deserialize() {
        String json = "{\"bronze\": 1,\"silver\": 2,\"gold\": 3}";
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        BadgeCount badgeCount = gson.fromJson(json, BadgeCount.class);
        assertEquals(1, badgeCount.getBronze());
        assertEquals(2, badgeCount.getSilver());
        assertEquals(3, badgeCount.getGold());
    }
}

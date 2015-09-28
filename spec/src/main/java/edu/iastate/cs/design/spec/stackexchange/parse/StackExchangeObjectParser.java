package edu.iastate.cs.design.spec.stackexchange.parse;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.iastate.cs.design.spec.stackexchange.objects.BadgeCount;
import edu.iastate.cs.design.spec.stackexchange.objects.Post;
import edu.iastate.cs.design.spec.stackexchange.objects.ShallowUser;

/**
 This class abstracts away the library that parses our json objects from Stack Exchange. Uses gson for the moment.
 */
public class StackExchangeObjectParser {

    public static Post parsePostObject(String jsonObject) {
        return gsonParse(jsonObject, Post.class);
    }

    public static BadgeCount parseBadgeCountObject(String jsonObject) {
        return gsonParse(jsonObject, BadgeCount.class);
    }

    public static ShallowUser parseShallowUserObject(String jsonObject) {
        return gsonParse(jsonObject, ShallowUser.class);
    }

    private static <T> T gsonParse(String jsonObject, Class<T> objectType) {
        Gson parser = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        return parser.fromJson(jsonObject, objectType);
    }
}

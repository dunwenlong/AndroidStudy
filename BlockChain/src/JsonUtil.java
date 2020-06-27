import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Dun Wenlong
 * @time 2020/6/27 16:12
 */
public class JsonUtil {
    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}

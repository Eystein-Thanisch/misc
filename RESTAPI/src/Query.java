import java.io.IOException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Query {

    public static void executeQuery(String country) throws IOException, UnirestException, JSONException {
        String url = String.format("https://ghoapi.azureedge.net/api/SUNBEDREG_ACCESS?$filter=SpatialDim%%20eq%%20%%27%s%%27",country);
        HttpResponse<JsonNode> jResp = Unirest
                                        .get(url)
                                        .asJson();
        JSONObject jObj = jResp.getBody().getObject();
        JSONArray jData = (JSONArray) jObj.get("value");
        if (jData.length() == 0) System.out.println("No data on sunbed regulation available for this country.");
        else {
            for (int i = 0; i < jData.length(); i++) {
                JSONObject dim = (JSONObject) jData.get(i);
                System.out.println(dim.get("Dim1") + ": " + dim.get("Value"));
                if (!dim.isNull("Comments")) {
                    System.out.println(dim.get("Comments"));
                }
            }
        }
    }

    public static void main(String[] args) throws UnirestException, IOException, JSONException {
        executeQuery(args[0]);
    }

}

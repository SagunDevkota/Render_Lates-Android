package json;

import android.content.Context;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JsonReader {
    String jsonString="";
    Context context;
    public JsonReader(Context context){
        this.context = context;
    }
    public ArrayList<String> readFile() throws IOException, JSONException {
        InputStream is = context.getAssets().open("physics1.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        ArrayList<String> list = new ArrayList<>();
        String line;
        while((line = bufferedReader.readLine())!= null){
            list.add(line);

        }
        return list;
    }
}

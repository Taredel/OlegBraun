package JDI.dataProviders;

import JDI.entities.MetalColorsData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

public class JSONReader {

    @DataProvider(name = "provider")
    public Object[] getDataFromJsonFile() {
        Map<String, MetalColorsData> map = null;
        try (Reader reader = new FileReader("src\\main\\resources\\JDI_ex8_metalsColorsDataSet.json")) {
            Gson gson = new GsonBuilder().create();
            map = gson.fromJson(reader, new TypeToken<Map<String, MetalColorsData>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map.values().toArray();
    }
}


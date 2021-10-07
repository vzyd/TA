import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataProviders {

    @DataProvider(name = "test-data")
    public Object[][] dataProvFunc() {
        return new Object[][]{
                {"tv", "TV"},
                {"iphone", "IPHONE"},
                {"монитор", "МОНИТОР"}
        };
    }

    @DataProvider(name = "json-data")
    public Object[][] getJsonDataProvider() throws IOException {
        List<ProductMenuDTO> data = new ArrayList<>();
        FileReader inFile = new FileReader("dataprovider.json");
        data = new Gson().fromJson((inFile), new TypeToken<ArrayList<ProductMenuDTO>>() {
        }.getType());

        int i = 0;
        Object[][] returnData = new Object[data.size()][1];
        for (ProductMenuDTO productMenu : data) {
            Object[] aTest = new Object[1];
            aTest[0] = productMenu.getProductMenu();
            returnData[i] = aTest;
            i++;
        }

        return returnData;

    }
}

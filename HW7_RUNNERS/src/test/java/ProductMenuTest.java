import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class ProductMenuTest extends BaseTest {
    private String NAME_MENU = "Каталог товаров";


    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface XmlParameters {
        String[] value();
    }

    @Test(dataProvider = "XMLFileLoader")
    @XmlParameters({"username", "password"})
    public void testSomething(String username, String password) {
        // implementation omitted for brevity
    }

    @DataProvider(name = "XMLFileLoader")
    public static Object[][] getDataFromXmlFile(final Method testMethod) {
        XmlParameters parameters = testMethod.getAnnotation(XmlParameters.class);
        String[] fields = parameters.value();
        //load just the fields you want
        return new Object[][]{{"user1", "pass1"}};
    }


    @DataProvider(name = "json-data")


    public Object[][] getJsonDataProvider() throws IOException {
        List<Object> data = new ArrayList<>();
        FileReader inFile = new FileReader("dataprovider.json");
        data = new Gson().fromJson((inFile), new TypeToken<ArrayList<Object>>() {
        }.getType());
        return data.toArray(new Object[0][]);

    }
//    @Test
//    public void checkThatHomePageContainsProductsMenu() {
//        getHomePage().getTextOfProductMenu();
//        assertTrue(getHomePage().getTextOfProductMenu().contains(NAME_MENU));
//    }

        @Test(dataProvider = "json-data")
        public void checkThatHomePageContainsProductsMenu (String keyword){
            // getHomePage().getTextOfProductMenu();
            assertTrue(getHomePage().getProductsMenu().getText().contains(keyword));
        }
    }


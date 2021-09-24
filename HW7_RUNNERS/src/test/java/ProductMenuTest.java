import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

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
        return new Object[][] { { "user1", "pass1" } };
    }

    @Test
    public void checkThatHomePageContainsProductsMenu() {
        getHomePage().getTextOfProductMenu();
        assertTrue(getHomePage().getTextOfProductMenu().contains(NAME_MENU));
    }
}

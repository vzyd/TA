import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;

public class BaseSettings {
    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder().setBaseUri("https://demoqa.com/").setConfig(getConfig()).build();
    }

    public static RestAssuredConfig getConfig() {
        return RestAssuredConfig.newConfig();
    }
}

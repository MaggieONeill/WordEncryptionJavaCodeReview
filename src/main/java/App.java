import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.Arrays;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
      staticFileLocation("/public");
      String layout = "templates/layout.vtl";

      get("/", (request, response) ->{
          HashMap model = new HashMap();
          model.put("template", "templates/index.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());




      get("/results", (request, response) ->{
        HashMap model = new HashMap();
        model.put("template", "templates/results.vtl");

        String userInput = request.queryParams("phrase");
        String encryption = encryption(userInput);
        model.put("encryption", encryption);


        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
  }

    public static String encryption (String userInput){
      String originalPhrase = userInput;
      String encryptedPhrase = originalPhrase.replaceAll("[AEIOUaeiou]", "-");
      return encryptedPhrase;
    }

}

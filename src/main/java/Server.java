import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
/**
 * Created by once2go on 26/01/17.
 */
public class Server {


    public void init() throws Exception {
        port(Integer.valueOf(System.getenv("PORT")));
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration freeMarkerConfiguration = new Configuration();
        freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(Server.class, "/web/"));
        freeMarkerEngine.setConfiguration(freeMarkerConfiguration);

        ///staticFileLocation("/public");
        get("/", (req, res) -> "Hello World");
        get("/hello", (request, response) -> {
                response.status(200);
                response.type("text/html");
                Map<String, Object> attributes = new HashMap<>();
               // attributes.put("posts", model.getAllPosts());
                attributes.put("message", "Kijiji parser");
                return freeMarkerEngine.render(new ModelAndView(attributes, "index.ftl"));
        });
    }

}

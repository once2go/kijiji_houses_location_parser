import com.google.gson.Gson;
import data.RequestData;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import presenter.RequestValidator;
import presenter.SearchWorker;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

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
        staticFileLocation("/web");

        get("/", (req, res) -> {
            res.status(200);
            res.type("text/html");
            return freeMarkerEngine.render(new ModelAndView(null, "index.ftl"));
        });

        post("/", (request, response) -> {
            RequestData requestData = new Gson().fromJson(request.body(), RequestData.class);
            String validationErrors = RequestValidator.validate(requestData);
            if (validationErrors != null) {
                return validationErrors;
            }
            SearchWorker searchWorker = new SearchWorker(requestData);
            Thread wThread = new Thread(searchWorker);
            wThread.start();
            wThread.join();
            return new Gson().toJson(searchWorker.getResult());
        });

    }

}

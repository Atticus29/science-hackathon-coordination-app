import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/team-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/all-teams.vtl");
      String name = request.queryParams("team-name");
      String description = request.queryParams("team-description");
      String url = request.queryParams("team-url");
      int teamSizeLimit = Integer.parseInt(request.queryParams("team-size"));
      Team newTeam = new Team(name, description, url, teamSizeLimit);
      // System.out.println(Team.allTeams());
      model.put("teams", Team.getAllTeams());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/all-teams.vtl");
      // System.out.println(Team.allTeams());
      // model.put("teams", Team.allTeams());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}

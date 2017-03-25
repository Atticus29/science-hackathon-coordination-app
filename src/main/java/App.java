import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.regex.*;

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
      // System.out.println(request.queryParams());
      int teamSizeLimit = Integer.parseInt(request.queryParams("team-size"));
      Team newTeam = new Team(name, description, url, teamSizeLimit);
      // System.out.println("newTeam made? " + (newTeam instanceof Team));
      // System.out.println(Team.allTeams());
      model.put("teams", Team.getAllTeams());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/all-teams.vtl");
      // System.out.println(Team.allTeams());
      // if(Team.getAllTeams()){
      model.put("teams", Team.getAllTeams());
      // }
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:teamID", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/team.vtl");
      // System.out.println("team ID is " + ":teamID");
      System.out.println("Params are: " + request.queryParams());

      // Some failed regular expression stuff
      // _____________________________________________
      // String fullURL = request.url();
      // Pattern teamIDPattern = Pattern.compile(".*teams\\/(.*)");
      // Matcher matcher = teamIDPattern.matcher(fullURL);
      // String teamIdentifier = matcher.group(1);
      // System.out.println("teamIdentifier is " + teamIdentifier);

       model.put("team",Team.getAllTeams().get(request.queryParams("teamIdentifier")));

      //  Perry, it's not clear to me why this didn't work
      // ______________________________________________________
      //  model.put("team",Team.getAllTeams().get(request.queryParams(":teamID")));

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams/:teamID", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/team.vtl");
      String memberName = request.queryParams("member-name");
      String memberURL = request.queryParams("member-url");
      String memberWork = request.queryParams("member-work");
      String memberLanguages = request.queryParams("member-languages");
      String memberLocation = request.queryParams("member-location");
      Member newMember = new Member(memberName, memberURL, memberWork, memberLanguages, memberLocation);
      Team.getAllTeams().get(request.queryParams("teamID")).addMember(newMember);
      // request.queryParams("team").addMember(newMember);
      model.put("team",Team.getAllTeams().get(request.queryParams("teamID")));
      // model.put("team",request.queryParams("team"));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:teamID/members/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/member-form.vtl");
      model.put("team",Team.getAllTeams().get(request.queryParams("teamID")));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:teamID/members/:memberID", (request, response) ->{
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("team",Team.getAllTeams().get(request.queryParams("teamID")));
      model.put("member",Team.getAllTeams().get(request.queryParams("teamID")).getMembers().get(request.queryParams("memberID")));
      model.put("template", "templates/member.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}

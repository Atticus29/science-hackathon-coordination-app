import java.util.Map;
import java.util.HashMap;
// import java.util.List;
// import java.util.ArrayList;

public class Team {
  private String mName;
  private String mDescription;
  private String mURL;
  private static Map<String, Team> allTeams = new HashMap<String, Team>();
  private Map<String, Member> mTeamMembers;
  private int mSizeLimit;

  public Team(String name, String description, String url, int maxSize){
    mName = name;
    mDescription = description;
    mURL = url;
    mTeamMembers = new HashMap<String, Member>();
    mSizeLimit = maxSize;
    allTeams.put(mName, this);
  }

  public void addMember(Member member){
    mTeamMembers.put(member.getName(), member);
  }

  public int getMemberCount(){
    return mTeamMembers.size();
  }

  public static void clear(){
    allTeams.clear();
  }

  public static Map<String, Team> getAllTeams(){
    return allTeams;
  }

  public Map<String, Member> getMembers(){
    return mTeamMembers;
  }

  public String getName(){
    return mName;
  }

  public String getDescription(){
    return mDescription;
  }

  public String getURL(){
    return mURL;
  }
  public int getSizeLimit(){
    return mSizeLimit;
  }

  public void setName(String name){
    mName = name;
  }

  public void setDescription(String description){
    mDescription = description;
  }

  public void setURL(String url){
    mURL = url;
  }

  public void setSizeLimit(int max){
    mSizeLimit = max;
  }

}

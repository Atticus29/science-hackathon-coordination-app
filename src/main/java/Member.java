import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Member {
  private String mName;
  private String mURL;
  private String mWork;
  private String mLanguages;
  private String mLocation;
  private static Map<String, Member> allMembers = new HashMap<String, Member>();

  public Member(String name, String url, String work, String languages, String location){
    mName = name;
    mURL = url;
    mWork = work;
    mLanguages = languages;
    mLocation = location;
    allMembers.put(mName, this);
  }

  public static void clear(){
    allMembers.clear();
  }

  public String getName(){
    return mName;
  }

  public String getURL(){
    return mURL;
  }

  public String getWork(){
    return mWork;
  }

  public String getLanguages(){
    return mLanguages;
  }

  public String getLocation(){
    return mLocation;
  }

  public void setName(String name){
    mName = name;
  }

  public void setURL(String url){
  mURL = url;
  }

  public void setWork(String work){
    mWork = work;
  }

  public void setLanguages(String languages){
    mLanguages = languages;
  }

  public void setLocation(String location){
    mLocation = location;
  }

  public static Map<String, Member> getAllMembers(){
    return allMembers;
  }

  public static Member findMember(String name){
    return allMembers.get(name);
  }

}

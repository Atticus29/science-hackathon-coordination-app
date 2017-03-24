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
}

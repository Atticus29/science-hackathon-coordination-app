import org.junit.*;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.HashMap;

public class TeamTest {

  private Team testTeam;

  @Before
  public void setUp(){
    Team.clear();
    testTeam = new Team("Alpha-Wing", "Build a stealth jet in one weekend", "http://www.alphaWing.com", 6);
    // System.out.println(testTeam instanceof Team);
  }

  @Test
  public void clear_ClearsTeamsCorrectly_1(){
    assertEquals(1, Team.getAllTeams().size());
    Team.clear();
    Team testTeam2 = new Team("Beta-leg", "3D prosthetic legs for an amputee", "http://www.legsForDays.com", 4);
    assertEquals(1, Team.getAllTeams().size());
  }

  @Test
  public void team_instantiatesCorrectly(){
    // System.out.println(testTeam instanceof Team);
    assertEquals(true, testTeam instanceof Team);
  }

  @Test
  public void addMember_increments_mTeamMembersHashMapByOne_1(){
    Member testMember = new Member("Janice", "http://www.janiceIsAwesome.com", "Garage scientist", "python, javaScript, java", "Portland");
    testTeam.addMember(testMember);
    assertEquals(1, testTeam.getMemberCount());
  }

  @Test
  public void getMemberCount_correctlyReturnsNumberOfMembers_2(){
    Member testMember1 = new Member("Janice", "http://www.janiceIsAwesome.com", "Garage scientist", "python, javaScript, java", "Portland");
    Member testMember2 = new Member("Amir", "http://www.amirIsAwesome.com", "Bud tender at the pot shop", "sql, fortran, BASIC, C, C++", "San Diego");
    testTeam.addMember(testMember1);
    testTeam.addMember(testMember2);
    assertEquals(2, testTeam.getMemberCount());
  }

  @Test
  public void getMembers_returnsHashMap_ofSize2_true(){
    Member testMember1 = new Member("Janice", "http://www.janiceIsAwesome.com", "Garage scientist", "python, javaScript, java", "Portland");
    Member testMember2 = new Member("Amir", "http://www.amirIsAwesome.com", "Bud tender at the pot shop", "sql, fortran, BASIC, C, C++", "San Diego");
    testTeam.addMember(testMember1);
    testTeam.addMember(testMember2);
    assertEquals(true, testTeam.getMembers() instanceof Map);
    assertEquals(2, testTeam.getMembers().size());
  }

  @Test
  public void getName_returnsTeamName_String(){
    assertEquals("Alpha-Wing", testTeam.getName());
  }

  @Test
  public void getURL_returnsURL_String(){
    assertEquals("http://www.alphaWing.com", testTeam.getURL());
  }

  @Test
  public void getDescription_returnsDescription_String(){
    assertEquals("Build a stealth jet in one weekend", testTeam.getDescription());
  }

  @Test
  public void getSizeLimit_returnsSizeLimitOfTeam_6(){
    assertEquals(6, testTeam.getSizeLimit());
  }

  @Test
  public void setName_returnsNewName_BetaWing(){
    testTeam.setName("Beta Wing");
    assertEquals("Beta Wing", testTeam.getName());
  }

  @Test
  public void setDescription_returnsNewDescription_String(){
    testTeam.setDescription("make a less good wing in 24 hours");
    assertEquals("make a less good wing in 24 hours", testTeam.getDescription());
  }

  @Test
  public void setURL_returnsNewURL_String(){
    testTeam.setURL("http://www.betaWing.com");
    assertEquals("http://www.betaWing.com", testTeam.getURL());
  }

  @Test
  public void setSizeLimit_returnsNewSize(){
    testTeam.setSizeLimit(10);
    assertEquals(10, testTeam.getSizeLimit());
  }

}

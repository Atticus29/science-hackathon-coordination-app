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

}

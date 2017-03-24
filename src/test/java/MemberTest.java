import org.junit.*;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class MemberTest {

  private Member testMember;

  @Before
  public void setUp(){
    Member.clear();
    testMember = new Member("Janice", "http://www.janiceIsAwesome.com", "Garage scientist", "python, javaScript, java", "Portland");
  }

  @Test
  public void member_instantiatesCorrectly(){
    assertEquals(true, testMember instanceof Member);
  }

  @Test
  public void getName_returnsMemberName_Janice(){
    assertEquals("Janice", testMember.getName());
  }

  @Test
  public void getURL_returnsURL_String(){
    assertEquals("http://www.janiceIsAwesome.com", testMember.getURL());
  }

  @Test
  public void getWork_returnsWork_String(){
    //Member testMember = new Member();
    assertEquals("Garage scientist", testMember.getWork());
  }

  @Test
  public void getLanguages_returnsLanguages_String(){
    //Member testMember = new Member();
    assertEquals("python, javaScript, java", testMember.getLanguages());
  }

  @Test
  public void getLocation_returnsLocation_Portland(){
    //Member testMember = new Member();
    assertEquals("Portland", testMember.getLocation());
  }

  @Test
  public void setName_changesNameToRick_Rick(){
    testMember.setName("Rick");
    assertEquals("Rick", testMember.getName());
  }

  @Test
  public void setURL_changesNameToRick_Rick(){
    testMember.setURL("http://www.rickIsAwesome.com");
    assertEquals("http://www.rickIsAwesome.com", testMember.getURL());
  }

  @Test
  public void setWork_changesNameToRick_Rick(){
    testMember.setWork("target");
    assertEquals("target", testMember.getWork());
  }

  @Test
  public void setLanguages_changesNameToRick_Rick(){
    testMember.setLanguages("scala");
    assertEquals("scala", testMember.getLanguages());
  }

  @Test
  public void setLocation_changesNameToRick_Rick(){
    testMember.setLocation("Seattle");
    assertEquals("Seattle", testMember.getLocation());
  }

}

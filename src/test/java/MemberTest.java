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

}

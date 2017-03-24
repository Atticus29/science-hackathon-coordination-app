import org.junit.*;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class MemberTest {
  @Test
public void member_instantiatesCorrectly(){
    Member testMember = new Member("Janice", "http://www.janiceIsAwesome.com", "Garage scientist", "python, javaScript, java", "Portland");
    assertEquals(true, testMember instanceof Member);
}
}

import roborally.domain.Board;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {

    private Board map;

    @BeforeEach
    public void setUp() {
      map = new Board();
    }
    
    @Test 
    public void CheckLengthYpositionTest(){
        for (int i = 0; i < map.getMap().length; i++) {
            for (int j = 0; j < map.getMap()[j].length; j++) {
                assertEquals(14, map.getMap()[j].length);
            }
        }
    }

    @Test 
    public void CheckLengthXpositionTest(){
        for (int i = 0; i < map.getMap().length; i++) {
         
                assertEquals(14, map.getMap()[i].length);
        
        }
    }
}





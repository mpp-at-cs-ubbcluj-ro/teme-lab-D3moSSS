import model.ComputerRepairRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ComputerRepairRequestTest {
    
    @Test
    @DisplayName("First Test")

    public void testFirstTest() {
        ComputerRepairRequest computerRepairRequest = new ComputerRepairRequest();
        assertEquals("", computerRepairRequest.getOwnerName());
        assertEquals("", computerRepairRequest.getOwnerAddress());

    }

    @Test
    @DisplayName("Second Test")
    public void testSecondTest() {
        assertEquals(2 , 2 , "numerele ar trebui sa fie egale");
    }
      
}

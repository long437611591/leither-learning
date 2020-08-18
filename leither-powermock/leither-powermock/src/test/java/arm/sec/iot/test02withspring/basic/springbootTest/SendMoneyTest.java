package arm.sec.iot.test02withspring.basic.springbootTest;

import static org.mockito.Mockito.spy;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import arm.sec.iot.controller.SendMoneyController;
import arm.sec.iot.service.SendMoneyUseCase;

@WebMvcTest(controllers = {SendMoneyController.class})
public class SendMoneyTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SendMoneyUseCase sendMoneyUseCase;


    @Test
    void testSendMoney(){

    }


    
    
}
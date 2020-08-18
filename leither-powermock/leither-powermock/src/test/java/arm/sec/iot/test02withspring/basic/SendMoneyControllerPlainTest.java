package arm.sec.iot.test02withspring.basic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.powermock.api.mockito.PowerMockito.*;

import arm.sec.iot.controller.SendMoneyController;
import arm.sec.iot.service.SendMoneyUseCase;
import arm.sec.iot.service.impl.SendMoneyService;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringRunner.class)
@PrepareForTest({ SendMoneyService.class, SendMoneyController.class })
public class SendMoneyControllerPlainTest {

  // private SendMoneyService sendMoneyService = mock(SendMoneyService.class);

  //  private SendMoneyController sendMoneyController = mock(SendMoneyController.class);
  @SpyBean
  private SendMoneyController sendMoneyController ;
  @MockBean
  private SendMoneyService  sendMoneyService;

  @Test
  public void testSucess() throws Exception {

    SendMoneyUseCase.SendMoneyCommand command = new SendMoneyUseCase.SendMoneyCommand(1L, 2L, 500);

    when(sendMoneyService.sendMoney(command)).thenReturn(true);
    // when(sendMoneyController.sendMoney(1L, 2L,
    // 500)).thenReturn(ResponseEntity.ok().build());

    ResponseEntity response = sendMoneyController.sendMoney(11111L, 2222L, 500);
    assertEquals(HttpStatus.OK, response.getStatusCode());

    // boolean ok =sendMoneyService.sendMoney(1L, 2L, 500);
    // assertEquals(true,ok);

  }

}
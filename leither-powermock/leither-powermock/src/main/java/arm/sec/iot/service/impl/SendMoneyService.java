package arm.sec.iot.service.impl;

import arm.sec.iot.service.SendMoneyUseCase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SendMoneyService implements SendMoneyUseCase {

    SendMoneyService() {
        log.info(">>>>>>>>>>>>>construction》》》》》》》》");
    }

    @Override
    public boolean sendMoney(SendMoneyCommand command) {
        log.info("sending money");
        return false;
    }

}
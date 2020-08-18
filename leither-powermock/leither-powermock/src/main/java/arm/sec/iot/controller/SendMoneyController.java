package arm.sec.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import arm.sec.iot.service.SendMoneyUseCase;
import arm.sec.iot.service.impl.SendMoneyService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SendMoneyController {

    @Autowired
    private SendMoneyService sendMoneyService;


    @PostMapping("/sendMoney/{sourceAccountId}/{targetAccountId}/{amount}")
    public ResponseEntity sendMoney(
    @PathVariable("sourceAccountId") Long sourceAccountId,
    @PathVariable("targetAccountId") Long targetAccountId,
    @PathVariable("amount") Integer amount){

        SendMoneyUseCase.SendMoneyCommand command  = new SendMoneyUseCase.SendMoneyCommand(sourceAccountId, targetAccountId, amount);
             
        boolean sucess = sendMoneyService.sendMoney(command);

        if (sucess) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    
    
}
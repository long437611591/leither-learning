package arm.sec.iot.test01;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.powermock.api.mockito.PowerMockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import arm.sec.iot.PrivatePatialMockingExample;

@RunWith(PowerMockRunner.class)
@PrepareForTest({PrivatePatialMockingExample.class})
public class PrivatePatialMockingExampleTest {

    @Test
    public void demoPrivateMethodMocking() throws Exception{

        final String expected  = "test value ";
        final String nameOfMethodToMock = "methodToMock";
        final String input = "input";
 
        PrivatePatialMockingExample undetTest =  spy(new PrivatePatialMockingExample());

        when(undetTest,nameOfMethodToMock,input).thenReturn("123");

        Assert.assertEquals(expected,undetTest.methodToTest());

        verifyPrivate(undetTest).invoke(nameOfMethodToMock,input);

        
    }

    
}
package arm.sec.iot.test01;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.reporter.PowerMockReporter;
import org.powermock.modules.junit4.PowerMockRunner;

import arm.sec.iot.utils.IdGenerator;

@RunWith(PowerMockRunner.class)
@PrepareForTest({IdGenerator.class})
public class TestStatic {

    @Test
    public void testCallInternalInstance() throws Exception{

        PowerMockito.mockStatic(IdGenerator.class);

        PowerMockito.when(IdGenerator.generateNewId()).thenReturn(15L);
        Assert.assertEquals(15L, new ClassUnderTest().methodToTest());

        PowerMockito.verifyStatic(IdGenerator.class);

        IdGenerator.generateNewId();

    }
    
}
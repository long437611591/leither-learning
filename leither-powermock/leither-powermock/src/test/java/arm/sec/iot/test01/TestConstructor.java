package arm.sec.iot.test01;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ClassUnderTestConstructor.class,ClassUnderTest.class})
public class TestConstructor {

    @Test
    public void createDirectoryStructurePathDoesnotExist() throws Exception {

        final String directoryPath =  "seem good ";
        //create File mock object
        File  directoryMock = mock(File.class);
        
        PowerMockito.whenNew(File.class).withArguments(directoryPath).thenReturn(directoryMock);

        PowerMockito.when(directoryMock.exists()).thenReturn(false);

        PowerMockito.when(directoryMock.mkdirs()).thenReturn(true);

        assertTrue(new ClassUnderTestConstructor().createDirectoryStructure(directoryPath));
        assertTrue(new ClassUnderTestConstructor().createDirectoryStructure(directoryPath));
        
        PowerMockito.verifyNew(File.class,times(2)).withArguments(directoryPath);
    }


    
}
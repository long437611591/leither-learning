package arm.sec.iot.test01;

import java.io.File;

public class ClassUnderTestConstructor {

    public boolean createDirectoryStructure(String directoryPath) {
        File directory =new File(directoryPath);
        if (directory.exists()) {
            String msg = "\\" + directoryPath +"\\"+ "already exist";
            throw new IllegalArgumentException(msg);
        }
        return directory.mkdirs();
    }
}
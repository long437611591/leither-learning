package arm.sec.iot;

public class PrivatePatialMockingExample {

    public String methodToTest() {
        return methodToMock("input");

    }

    private String methodToMock(String input) {
        return "real value  = " + input;
    }

}
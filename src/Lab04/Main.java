package Lab04;

public class Main {
    public static void main(String[] args) {
        TestClass test = new TestClass();
        MethodRepeater repeater = new MethodRepeater();
        repeater.repeatAsAnnotated(test);
    }
}

package Lab04;

public class TestClass {
    private int counter1 = 1;
    private int counter2 = 1;
    private int counter3 = 1;
    private int counter4 = 1;
    private int counter5 = 1;
    private int counter6 = 1;

    @NumOfCalls(num = 2)
    public void method1() {
        System.out.println("Public method 1: " + counter1++);
    }

    public void method2() {
        System.out.println("Public method 2: " + counter2++);
    }

    @NumOfCalls(num = 0)
    protected void method3() {
        System.out.println("Protected method 3: " + counter3++);
    }

    @NumOfCalls(num = 2)
    protected void method4() {
        System.out.println("Protected method 4: " + counter4++);
    }

    @NumOfCalls(num = 3)
    private void method5() {
        System.out.println("Private method 5: " + counter5++);
    }

    @NumOfCalls(num = 1)
    private void method6() {
        System.out.println("Private method 6: " + counter6++);
    }
}

package Lab04;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodRepeater {
    public void repeatAsAnnotated(Object object) {
        TestClass test = new TestClass();
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(NumOfCalls.class)) {
                method.setAccessible(true);
                int counter = method.getAnnotation(NumOfCalls.class).num();
                for (int i = 0; i < counter; i++) {
                    try {
                        method.invoke(test);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                method.setAccessible(false);
            }
        }
    }
}

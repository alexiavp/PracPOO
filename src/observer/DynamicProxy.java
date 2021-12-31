package observer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Class with the DynamicProxy implemented
 */
public class DynamicProxy implements InvocationHandler {
    /**
     * Variable of the class
     */
    private Object target;

    /**
     * Creates an instence of the proxy
     * @param target of the proxy
     * @return the object
     */
    public static Object newInstance(Object target) {
        Class targetClass = target.getClass();
        Class interfaces[] = targetClass.getInterfaces();
        return Proxy.newProxyInstance(targetClass.getClassLoader(), interfaces, new DynamicProxy(target));
    }

    /**
     * Method  to assign the target
     * @param target to assign
     */
    private DynamicProxy(Object target) {
        this.target = target;
    }

    /**
     * Method to invokes the method called
     * @param proxy of the target
     * @param method to call
     * @param args to the method
     * @return the object
     * @throws Throwable of the class
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invocationResult = null;
        try {
            //System.out.println("Proxy execute before method... " + method.getName());
            invocationResult = method.invoke(this.target, args);
            //System.out.println("After method " + method.getName());
        } catch (InvocationTargetException ite) {
            throw ite.getTargetException();
        } catch (Exception e) {
            System.err.println("Invocation of " + method.getName() + " failed");
        } finally {
            return invocationResult;
        }
    }
}

package method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args){
		try {
			Class<Circle> clazz = Circle.class;
			Object obj = clazz.newInstance();
			Method _setter = clazz.getDeclaredMethod("setRadius", new Class[]{int.class});
			Method _method = clazz.getDeclaredMethod("getShape", new Class[]{});
			_setter.invoke(obj, 5);
			Object ret = _method.invoke(obj, new Object[] { });
			System.out.println(ret);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}
}

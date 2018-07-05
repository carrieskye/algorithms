package dataStructures;

import java.lang.reflect.Constructor;

public class UFFactory {

	public static UF createUF(String type, Object... args) {
		UF instance = null;
		Class<?>[] arg = new Class[args.length];
		int tel = 0;
		for (Object object : args) {
			arg[tel++] = object.getClass();
		}
		try {
			Class<?> UFClass = Class.forName("dataStructures." + type);
			Constructor<?> constructor = UFClass.getConstructor(arg);
			instance = (UF) constructor.newInstance(args);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return instance;
	}

}

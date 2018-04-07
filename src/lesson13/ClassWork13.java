package lesson13;

import java.lang.reflect.*;

import lesson02.imports.Numbers;

public class ClassWork13 {

	public static void main(String[] args) {
		//## Reflection ##
		Class<Numbers> cl = Numbers.class;
//		Field[] f = cl.getDeclaredFields();
//		for (Field field : f) {
//			System.out.println(field);
//		}
		Method[] meth = cl.getDeclaredMethods();
		for (Method method : meth) {
			System.out.println(method);
		}
		
		//## Annotation ##
		
		
		
	}
}

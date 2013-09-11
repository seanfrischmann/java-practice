package supportcode;

import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Circle extends cse115.graphics.Ellipse {
	private lab5.ColorHolder _holder;
	
	public Circle(lab5.ColorHolder h) {
		_holder = h;
		this.setColor(callGetColorOnColorHolder(_holder));
		this.setDimension(new java.awt.Dimension(100,100));
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Circle.this.setColor(callGetColorOnColorHolder(_holder));
			}
		});
	}
	private java.awt.Color callGetColorOnColorHolder(lab5.ColorHolder b) {
        final String className = "ColorHolder";
        final String methodName = "getColor";
//		System.out.println("REFLECTION to call "+methodName+" on "+className);
		java.awt.Color color = null;
        Method meth=null;
		try {
			meth = b.getClass().getMethod(methodName, new Class[0]);
	        try {
	            color = (java.awt.Color) meth.invoke(b, new Object[0]);
			} catch (IllegalArgumentException e) {
				System.err.println("Error calling "+methodName+" in "+className+": "+e.getMessage());
			} catch (IllegalAccessException e) {
				System.err.println("Error calling "+methodName+" in "+className+": "+e.getMessage());
			} catch (InvocationTargetException e) {
				System.err.println("Error calling "+methodName+" in "+className+": "+e.getMessage());
			}
		} catch (SecurityException e) {
			System.err.println("Error calling "+methodName+" in "+className+": "+e.getMessage());
		} catch (NoSuchMethodException e) {
			System.err.println("Error calling "+methodName+" in "+className+": "+e.getMessage());
		}
		return color;
	}
}

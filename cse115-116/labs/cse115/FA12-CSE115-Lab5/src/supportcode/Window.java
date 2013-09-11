package supportcode;

import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JFrame;

import cse115.graphics.DrawingCanvas;

public class Window {

	private DrawingCanvas _drawingCanvas;
	private JFrame _window;
	private javax.swing.JPanel _colorButtonColumn;
	private javax.swing.JPanel _squareButtonColumn;
	private javax.swing.JPanel _circleButtonColumn;

	public Window() {
		_drawingCanvas = new DrawingCanvas();
		_drawingCanvas.setDimension(new java.awt.Dimension(800,600));
		_drawingCanvas.setColor(java.awt.Color.DARK_GRAY);
//		_drawingCanvas.setColor(java.awt.Color.WHITE);
		_window = new javax.swing.JFrame("CSE115 Fall 2012 Lab 5");
		java.awt.Container cp = _window.getContentPane();
		javax.swing.JPanel row = new javax.swing.JPanel();
		row.setLayout(new javax.swing.BoxLayout(row,javax.swing.BoxLayout.X_AXIS));
		_squareButtonColumn = new javax.swing.JPanel();
		_squareButtonColumn.setLayout(new javax.swing.BoxLayout(_squareButtonColumn,javax.swing.BoxLayout.Y_AXIS));
		_circleButtonColumn = _squareButtonColumn;
		_colorButtonColumn = new javax.swing.JPanel();
		_colorButtonColumn.setLayout(new javax.swing.BoxLayout(_colorButtonColumn,javax.swing.BoxLayout.Y_AXIS));
		cp.add(row);
		row.add(_squareButtonColumn);
		row.add(_drawingCanvas);
		row.add(_colorButtonColumn);
		_window.pack();
		_window.setVisible(true);
	}
	
	public void addSquare(Square s) {
		// make sure whole of 100 wide square is on canvas
		// 72 is approx squareRootOfTwo times 100
		s.setCenterLocation(new java.awt.Point(
				cse115.utilities.Random.randomInteger(72,_drawingCanvas.getWidth()-72),
				cse115.utilities.Random.randomInteger(72,_drawingCanvas.getHeight()-72))
		);
		s.setRotation(cse115.utilities.Random.randomInteger(0, 89));
		_drawingCanvas.add(s);
	}
	
	public void addCircle(Circle s) {
		// make sure whole of 100 wide circle is on canvas
		// 72 is approx squareRootOfTwo times 100
		s.setCenterLocation(new java.awt.Point(
				cse115.utilities.Random.randomInteger(72,_drawingCanvas.getWidth()-72),
				cse115.utilities.Random.randomInteger(72,_drawingCanvas.getHeight()-72))
		);
		_drawingCanvas.add(s);
	}
	
	public void addSquareButton(lab5.SquareButton sb) {
		_squareButtonColumn.add(new MagicSquareButton(sb));
		_window.pack();
	}
	
	public void addCircleButton(lab5.CircleButton sb) {
		_circleButtonColumn.add(new MagicCircleButton(sb));
		_window.pack();
	}
	
	public void addColorButton(lab5.ColorButton cb) {
		_colorButtonColumn.add(new MagicColorButton(cb));
		_window.pack();
	}
	
	private class MagicSquareButton extends javax.swing.JButton {
		private static final long serialVersionUID = 1L;
		private lab5.SquareButton _sb;
		public MagicSquareButton(lab5.SquareButton sb) {
			super("NEW SQUARE");
			this.setOpaque(true);
			this.setBackground(java.awt.Color.WHITE);
			_sb = sb;
			this.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
					callButtonPressedOnButton(_sb);
				}
			});
		}
		private void callButtonPressedOnButton(lab5.SquareButton b) {
	        final String className = "SquareButton";
	        final String methodName = "buttonPressed";
	        Method meth=null;
			try {
				meth = b.getClass().getMethod(methodName, new Class[0]);
		        try {
		            meth.invoke(b, new Object[0]);
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
				System.err.println("Whoops!  Did you forget to define the '"+methodName+"' method in the "+className+" class?");
			}
		}
	}
	
	private class MagicCircleButton extends javax.swing.JButton {
		private static final long serialVersionUID = 1L;
		private lab5.CircleButton _sb;
		public MagicCircleButton(lab5.CircleButton sb) {
			super("NEW CIRCLE");
			this.setOpaque(true);
			this.setBackground(java.awt.Color.WHITE);
			_sb = sb;
			this.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
					callButtonPressedOnButton(_sb);
				}
			});
		}
		private void callButtonPressedOnButton(lab5.CircleButton b) {
	        final String className = "CircleButton";
	        final String methodName = "buttonPressed";
	        Method meth=null;
			try {
				meth = b.getClass().getMethod(methodName, new Class[0]);
		        try {
		            meth.invoke(b, new Object[0]);
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
				System.err.println("Whoops!  Did you forget to define the '"+methodName+"' method in the "+className+" class?");
			}
		}
	}
	
	
	private class MagicColorButton extends javax.swing.JButton {
		private static final long serialVersionUID = 1L;
		private lab5.ColorButton _cb;
		public MagicColorButton(lab5.ColorButton cb) {
			super(" ");
			if (System.getProperty("os.name").toLowerCase().equals("mac os x")) {
				// Running on a Mac with OS X
				this.setOpaque(true);
			}
	        final String className = "ColorButton";
	        final String fieldType = "java.awt.Color";
			Field _$_color = null;
			String fieldName = "";
			try {
				Field [] fields = cb.getClass().getDeclaredFields();
				if (fields.length != 2) {
					System.err.println("Whoops!  You need to declare TWO instance variables in the ColorButton class, one of type java.awt.Color and one of type lab5.ColorHolder.  You declared "+fields.length+" instance variables.");
				}
				for (Field f : fields) {
					try {
						if (f.getType().equals(Class.forName("java.awt.Color"))) {
							fieldName = f.getName();
						}
					} catch (ClassNotFoundException e1) {
						System.err.println("Whoops!  It looks like you forgot to declare an instance variable of type java.awt.Color in the ColorButton class.");
					}
				}
				_$_color = cb.getClass().getDeclaredField(fieldName);
				try {
					_$_color.setAccessible(true);
					java.awt.Color tempColor = (java.awt.Color) _$_color.get(cb);
					this.setOpaque(true);
					this.setBackground(tempColor);
				} catch (IllegalArgumentException e1) {
					System.err.println("Error occured when trying to access the instance variable of type "+fieldType+" in the "+className+" class: "+e1.getMessage());
				} catch (IllegalAccessException e1) {
					System.err.println("Error occured when trying to access the instance variable of type "+fieldType+" in the "+className+" class: "+e1.getMessage());
				}
			} catch (SecurityException e1) {
				System.err.println("Error occured when trying to access the instance variable of type "+fieldType+" in the "+className+" class: "+e1.getMessage());
			} catch (NoSuchFieldException e1) {
				System.err.println("Whoops!  It looks like you forgot to declare an instance variable of type java.awt.Color in the ColorButton class.");
			}  
			_cb = cb;
			this.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
					callButtonPressedOnButton(_cb);
				}
			});
		}
		private void callButtonPressedOnButton(lab5.ColorButton b) {
	        final String className = "ColorButton";
	        final String methodName = "buttonPressed";
	        Method meth=null;
			try {
				meth = b.getClass().getMethod(methodName, new Class[0]);
		        try {
		            meth.invoke(b, new Object[0]);
				} catch (IllegalArgumentException e) {
					System.err.println("**ERROR ("+className+"): "+e.getMessage());
				} catch (IllegalAccessException e) {
					System.err.println("**ERROR ("+className+"): "+e.getMessage());
				} catch (InvocationTargetException e) {
					System.err.println("**ERROR ("+className+"): "+e.getMessage());
				}
			} catch (SecurityException e) {
				System.err.println("**ERROR ("+className+"): "+e.getMessage());
			} catch (NoSuchMethodException e) {
				System.err.println("Whoops!  Did you forget to define the '"+methodName+"' method in the "+className+" class?");
			}
		}
	}
}

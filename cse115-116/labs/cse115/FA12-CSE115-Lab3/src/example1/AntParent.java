package example1;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

import cse115.graphics.AbstractColorableGraphic;
import cse115.utilities.Timer;
import cse115.utilities.Vector;

public abstract class AntParent extends AbstractColorableGraphic implements Organism {
	
	public boolean isMoving() {
		return _timer.isRunning();
	}

	private AntTimer _timer;
	private IBehavior _behavior;
	private Vector _velocity;
	
	public AntParent() {
		this.setDimension(new Dimension(20,6));
		this.setColor(java.awt.Color.BLACK);
		_velocity = new Vector(2,0);
		_behavior = new Tunnel();
	}
	
	public void createTimer(Ant ant) {
		_timer = new AntTimer(50, ant);
	}
	
	public void actualPaint(Graphics2D gs, Point location, Dimension dimension) {
		if (_velocity.getDx() > 0) {  // Moving to the right
			gs.fillRect(location.x, location.y, dimension.width - dimension.height, dimension.height);
			gs.fillOval(location.x + dimension.width - dimension.height, location.y, dimension.height, dimension.height);
		}
		else if (_velocity.getDx() < 0) {  // Moving to the left
			gs.fillOval(location.x, location.y, dimension.height, dimension.height);
			gs.fillRect(location.x + dimension.height, location.y, dimension.width - dimension.height, dimension.height);
		}
		else if (_velocity.getDy() > 0) { // Moving down
			gs.fillRect(location.x, location.y, dimension.height, dimension.width - dimension.height);
			gs.fillOval(location.x, location.y + dimension.width - dimension.height, dimension.height, dimension.height);
		}
		else if (_velocity.getDy() < 0) { // Moving up
			gs.fillOval(location.x, location.y, dimension.height, dimension.height);
			gs.fillRect(location.x, location.y + dimension.height, dimension.height, dimension.width - dimension.height);
		}
	}
	
	public void startTimer() {
		_timer.start();
	}

	public void stopTimer() {
		_timer.stop();
	}

	public void flipHorizontal() {
		_velocity.setDx(-_velocity.getDx());
	}

	public void flipVertical() {
		_velocity.setDy(-_velocity.getDy());
	}

	public Vector getVelocity() {
		return _velocity;
	}

	public void setVelocity(Vector v) {
		_velocity = v;
	}

	public Shape getShape() {
		return this.getBounds();
	}
	
	private class AntTimer extends Timer {
		private static final long serialVersionUID = 1650366194111312566L;
		private Ant _ant;
		
		public AntTimer(Integer delay, Ant ant) {
			super(delay);
			_ant = ant;
		}

		@Override
		public void activate() {
			_behavior.perform(_ant);
		}
	}
}

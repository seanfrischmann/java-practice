package example1;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

import cse115.graphics.AbstractColorableGraphic;
import cse115.utilities.Timer;
import cse115.utilities.Vector;

public abstract class ButterflyParent extends AbstractColorableGraphic implements Organism {
	private ButterflyTimer _timer;
	private IBehavior _behavior;
	private Vector _velocity;
	private boolean _wingsClosed;
	
	public ButterflyParent() {
		this.setDimension(new Dimension(9,18));
		this.setColor(new java.awt.Color(80,80,200));
		_velocity = new Vector(2,2);
		_behavior = new Fly();
		_wingsClosed = false;
	}
	
	public void createTimer(Butterfly butterfly) {
		_timer = new ButterflyTimer(150, butterfly);
	}
	
	@Override
	public void actualPaint(Graphics2D gs, Point location, Dimension dimension) {
		int segmentWidth = dimension.width/3;
		int segmentHeight = dimension.height;
		if (_wingsClosed) {
			gs.fillRect(location.x+1*segmentWidth, location.y, segmentWidth, segmentHeight);
		}
		else {
			gs.fillRect(location.x+0*segmentWidth, location.y, segmentWidth, segmentHeight);
			gs.fillRect(location.x+1*segmentWidth, location.y, segmentWidth, segmentHeight);
			gs.fillRect(location.x+2*segmentWidth, location.y, segmentWidth, segmentHeight);
		}
	}
	
	/* (non-Javadoc)
	 * @see cse115.graphics.AbstractGraphic#setLocation(java.awt.Point)
	 * Changes state of caterpillar whenever it moves
	 */
	@Override
	public void setLocation(Point point) {
		// TODO Auto-generated method stub
		super.setLocation(point);
		_wingsClosed = !_wingsClosed;
	}
	
	public void startTimer() {
		_timer.start();
	}

	public void stopTimer() {
		_timer.stop();
	}

	@Override
	public void flipHorizontal() {
		_velocity.setDx(-_velocity.getDx());
	}

	@Override
	public void flipVertical() {
		_velocity.setDy(-_velocity.getDy());
	}

	@Override
	public Vector getVelocity() {
		return _velocity;
	}

	@Override
	public void setVelocity(Vector v) {
		_velocity = v;
	}

	@Override
	public Shape getShape() {
		return this.getBounds();
	}
	
	private class ButterflyTimer extends Timer {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Butterfly _butterfly;
		
		public ButterflyTimer(Integer delay, Butterfly butterfly) {
			super(delay);
			_butterfly = butterfly;
		}

		@Override
		public void activate() {
			_behavior.perform(_butterfly);
		}
	}
}

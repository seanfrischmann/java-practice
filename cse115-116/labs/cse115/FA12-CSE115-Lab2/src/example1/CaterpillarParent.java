package example1;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

import cse115.graphics.AbstractColorableGraphic;
import cse115.utilities.Timer;
import cse115.utilities.Vector;

public abstract class CaterpillarParent extends AbstractColorableGraphic implements Organism {
	private CaterpillarTimer _timer;
	private IBehavior _behavior;
	private Vector _velocity;
	private boolean _middleUp;
	
	public CaterpillarParent() {
		this.setDimension(new Dimension(30,6));
		this.setColor(new java.awt.Color(80,200,80));
		_velocity = new Vector(2,0);
		_behavior = new Walk();
		_middleUp = false;
	}
	
	public void createTimer(Caterpillar caterpillar) {
		_timer = new CaterpillarTimer(150, caterpillar);
	}
	
	@Override
	public void actualPaint(Graphics2D gs, Point location, Dimension dimension) {
		int segmentWidth = dimension.width/3;
		int segmentHeight = dimension.height;
		if (_middleUp) {
			gs.fillRect(location.x+0*segmentWidth, location.y, segmentWidth, segmentHeight);
			gs.fillRect(location.x+segmentWidth/2, location.y-segmentHeight, segmentWidth, segmentHeight);
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
		_middleUp = !_middleUp;
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
	
	private class CaterpillarTimer extends Timer {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Caterpillar _caterpillar;
		
		public CaterpillarTimer(Integer delay, Caterpillar caterpillar) {
			super(delay);
			_caterpillar = caterpillar;
		}

		@Override
		public void activate() {
			_behavior.perform(_caterpillar);
		}
	}
}

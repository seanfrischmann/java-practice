package example1;

import java.awt.Dimension;
import java.awt.Point;

public interface ITerrariumConstants {
	Dimension WORLD_SIZE = new Dimension(600,400);
	Dimension SKY_SIZE = new Dimension(WORLD_SIZE.width,WORLD_SIZE.height/2);
	Point SKY_LOCATION = new Point(0,0);
	Dimension SOIL_SIZE = new Dimension(WORLD_SIZE.width,WORLD_SIZE.height/2);
	Point SOIL_LOCATION = new Point(0,WORLD_SIZE.height/2);
}

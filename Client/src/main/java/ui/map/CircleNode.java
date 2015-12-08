package ui.map;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class CircleNode extends NodeEntity
{
	public CircleNode(float scaleX,float scaleY,int diameter,String layer,String nodeText)
	{
		super(scaleX,scaleY,layer,nodeText);
		this.setLayer(layer);
		setNodeWidth(diameter);
		setNodeHeight(diameter);
	}

	@Override
	public Shape getArea()
	{
		return new Ellipse2D.Double(getInViewPoint().getX(),getInViewPoint().getY(),getNodeWidth(),getNodeHeight());
	}

}

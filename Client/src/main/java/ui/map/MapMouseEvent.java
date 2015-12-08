
package ui.map;

import java.awt.event.MouseEvent;
import java.util.EventObject;


public class MapMouseEvent extends EventObject
{

	private MouseEvent trigger;
	private NodeEntity nodeEntity;
	public MapMouseEvent(MouseEvent trigger,NodeEntity entity)
	{
		super(entity);
		this.trigger = trigger;
		this.nodeEntity = entity;
	}
	public MouseEvent getTrigger()
	{
		return trigger;
	}
	
	public void setTrigger(MouseEvent trigger)
	{
		this.trigger = trigger;
	}
	
	public NodeEntity getNodeEntity()
	{
		return nodeEntity;
	}

	public void setNodeEntity(NodeEntity nodeEntity)
	{
		this.nodeEntity = nodeEntity;
	}
	
}

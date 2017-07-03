package maze;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public abstract class MapSite
{
	private List<EntryListener> listeners = new ArrayList<EntryListener>();

	public final synchronized void addEntryListener(final EntryListener el)
	{
		listeners.add(el);
	}
	
	public final synchronized void removeEntryListener(final EntryListener el)
	{
		listeners.remove(el);
	}

	protected final synchronized void notifyEntryListeners()
	{
		for (EntryListener el : listeners)
			el.entered(this);
	}

	public abstract Color getColor();
	public abstract void enter();
}

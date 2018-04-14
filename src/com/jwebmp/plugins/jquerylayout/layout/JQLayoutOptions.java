/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.plugins.jquerylayout.layout;

import com.jwebmp.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.jquerylayout.layout.options.JQLayoutDefaultOptions;

import javax.validation.constraints.NotNull;

/**
 * @author Marc Magon
 * @version 1.0
 * @since 29 Aug 2015
 */
public class JQLayoutOptions<J extends JQLayoutOptions<J>>
		extends JavaScriptPart<J>
{

	private static final long serialVersionUID = 1L;
	/**
	 * The name of the layout
	 */
	private String name;
	/**
	 * The global defaults
	 */
	private JQLayoutDefaultOptions defaults;
	/**
	 * The west entry
	 */
	private JQLayoutDefaultOptions west;
	/**
	 * The north entry
	 */
	private JQLayoutDefaultOptions north;
	/**
	 * The east entry
	 */
	private JQLayoutDefaultOptions east;
	/**
	 * The south entry
	 */
	private JQLayoutDefaultOptions south;
	/**
	 * The center entry
	 */
	private JQLayoutDefaultOptions center;

	/**
	 * A blank options canvas
	 */
	public JQLayoutOptions()
	{
		//Nothing needed
	}

	/**
	 * Gets the name of this layout
	 * <p>
	 *
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of this layout
	 * <p>
	 *
	 * @param name
	 */
	@SuppressWarnings("unchecked")
	public J setName(String name)
	{
		this.name = name;
		return (J) this;
	}

	/**
	 * Returns the default options for each layout
	 * <p>
	 *
	 * @return
	 */
	@NotNull
	public JQLayoutDefaultOptions getDefaults()
	{
		if (defaults == null)
		{
			defaults = new JQLayoutDefaultOptions();
		}
		defaults.setOnResize("$.layout.callbacks.resizeJQuery");
		return defaults;
	}

	/**
	 * Returns the west options pane
	 * <p>
	 *
	 * @return
	 */
	@NotNull
	public JQLayoutDefaultOptions getWest()
	{
		if (west == null)
		{
			west = new JQLayoutDefaultOptions();
		}
		return west;
	}

	/**
	 * Sets the west option pane
	 * <p>
	 *
	 * @param west
	 */
	public void setWest(JQLayoutDefaultOptions west)
	{
		this.west = west;
	}

	/**
	 * Returns the north options pane
	 * <p>
	 *
	 * @return
	 */
	public JQLayoutDefaultOptions getNorth()
	{
		if (north == null)
		{
			north = new JQLayoutDefaultOptions();
		}
		return north;
	}

	/**
	 * Sets the north options
	 * <p>
	 *
	 * @param north
	 */
	public void setNorth(JQLayoutDefaultOptions north)
	{
		this.north = north;
	}

	/**
	 * Returning the east
	 * <p>
	 *
	 * @return
	 */
	public JQLayoutDefaultOptions getEast()
	{
		if (east == null)
		{
			east = new JQLayoutDefaultOptions();
		}
		return east;
	}

	/**
	 * Sets the east
	 * <p>
	 *
	 * @param east
	 */
	public void setEast(JQLayoutDefaultOptions east)
	{
		this.east = east;
	}

	/**
	 * Returns the south
	 * <p>
	 *
	 * @return
	 */
	public JQLayoutDefaultOptions getSouth()
	{
		if (south == null)
		{
			south = new JQLayoutDefaultOptions();
		}
		return south;
	}

	/**
	 * Sets the south
	 * <p>
	 *
	 * @param south
	 */
	public void setSouth(JQLayoutDefaultOptions south)
	{
		this.south = south;
	}

	/**
	 * Returns the center
	 * <p>
	 *
	 * @return
	 */
	public JQLayoutDefaultOptions getCenter()
	{
		if (center == null)
		{
			center = new JQLayoutDefaultOptions();
		}
		return center;
	}

	/**
	 * Sets the center
	 * <p>
	 *
	 * @param center
	 */
	public void setCenter(JQLayoutDefaultOptions center)
	{
		this.center = center;
	}

}

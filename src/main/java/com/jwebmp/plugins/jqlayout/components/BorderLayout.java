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
package com.jwebmp.plugins.jqlayout.components;

import com.jwebmp.core.Component;
import com.jwebmp.core.base.html.Body;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.exceptions.NullComponentException;
import com.jwebmp.plugins.jqlayout.JQLayout;
import com.jwebmp.plugins.jqlayout.JQLayoutContentDiv;
import com.jwebmp.plugins.jqlayout.JQLayoutDiv;
import com.jwebmp.plugins.jqlayout.JQLayoutOptions;
import com.jwebmp.plugins.jqlayout.enumerations.JQLayoutArea;
import com.jwebmp.plugins.jqlayout.enumerations.JQLayoutAttributes;
import com.jwebmp.plugins.jqlayout.enumerations.JQLayoutCSSThemeBlockNames;
import com.jwebmp.plugins.jqlayout.events.*;
import com.jwebmp.plugins.jqlayout.interfaces.IJQLayout;

import javax.validation.constraints.NotNull;

import static com.jwebmp.core.utilities.StaticStrings.*;

/**
 * Another name for the JQuery UI Layout
 *
 * @author GedMarc
 * @version 1.0
 * @since 22 Dec 2016
 */
public class BorderLayout<J extends BorderLayout<J>>
		extends JQLayoutContentDiv<J>
		implements IJQLayout<J>
{


	private JQLayout feature;

	/**
	 * The variable associated with this layout
	 */
	private String variableID;

	/**
	 * The center div
	 */
	private JQLayoutDiv<?> center;
	/**
	 * The north div
	 */
	private JQLayoutDiv<?> north;
	/**
	 * The east div
	 */
	private JQLayoutDiv<?> east;
	/**
	 * The west div
	 */
	private JQLayoutDiv<?> west;
	/**
	 * The south div
	 */
	private JQLayoutDiv<?> south;

	private boolean fullScreen;

	/**
	 * Sets a component as a border layout container
	 */
	public BorderLayout()
	{
		super();
		addFeature(feature = new JQLayout(this));
		addAttribute(JQLayoutAttributes.JWType.toString(), "layout");
		removeClass(JQLayoutCSSThemeBlockNames.UI_Layout_Content);
	}

	@NotNull
	@Override
	public J setID(String id)
	{
		setVariableID(id);
		return super.setID(id);
	}

	/**
	 * Returns the layout options
	 * <p>
	 *
	 * @return
	 */
	@Override
	@NotNull
	public JQLayoutOptions<?> getOptions()
	{
		return feature.getOptions();
	}

	/**
	 * Configures the feature
	 */
	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{
			add(getCenter());
			if (west != null)
			{
				add(west);
			}
			if (east != null)
			{
				add(east);
			}
			if (south != null)
			{
				add(south);
			}
			if (north != null)
			{
				add(north);
			}
			if (isFullScreen())
			{
				addStyle("width:100%;height:100%;");
				if (getParent() != null && Body.class.isAssignableFrom(getParent().getClass()))
				{
					((Body) getParent())
							.setFullScreen();
				}
			}
		}
		super.preConfigure();
	}

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public final JQLayoutDiv<? extends IComponentHierarchyBase> getCenter()
	{
		if (center == null)
		{
			setCenter(new JQLayoutDiv(this, JQLayoutArea.Center, new JQLayoutContentDiv<>()));
		}
		return center;
	}

	/**
	 * Sets the center pane
	 *
	 * @param centerDiv
	 * 		The new center panel
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setCenter(JQLayoutDiv centerDiv)
	{
		if (getComponent() != null)
		{
			getComponent().remove(center);
		}
		center = centerDiv;
		return (J) this;
	}

	/**
	 * Creates a toggle button for the given pane on the component.
	 * <p>
	 * The feature is added to the component
	 *
	 * @param component
	 * @param pane
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public JQLayoutAddToggleButtonFeature createToggleButton(Component component, JQLayoutArea pane)
	{
		return new JQLayoutAddToggleButtonFeature(getPane(pane), component);
	}

	/**
	 * Gets the layout div for a pane
	 *
	 * @param area
	 *
	 * @return
	 */
	@Override
	public JQLayoutDiv getPane(JQLayoutArea area)
	{
		switch (area)
		{
			case North:
				return getNorth();
			case West:
				return getWest();
			case South:
				return getSouth();
			case East:
				return getEast();
			case Center:
				return getCenter();
			default:
				throw new NullComponentException("getPane() returned null due to missing area configuration");
		}
	}

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */
	@Override
	public JQLayoutDiv<?> getNorth()
	{
		if (north == null)
		{
			setNorth(new JQLayoutDiv<>(this, JQLayoutArea.North, new JQLayoutContentDiv<>()));
		}
		return north;
	}

	/**
	 * Sets the north pane
	 *
	 * @param northDiv
	 * 		The new center panel
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setNorth(JQLayoutDiv<?> northDiv)
	{
		remove(north);
		north = northDiv;
		return (J) this;
	}

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */
	@Override
	@NotNull
	public JQLayoutDiv<?> getWest()
	{
		if (west == null)
		{
			setWest(new JQLayoutDiv<>(this, JQLayoutArea.West, new JQLayoutContentDiv<>()));
		}
		return west;
	}

	/**
	 * Sets the center pane
	 *
	 * @param westDiv
	 * 		The new center panel
	 */

	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setWest(JQLayoutDiv<?> westDiv)
	{
		if (getComponent() != null)
		{
			remove(west);
		}
		west = westDiv;
		return (J) this;
	}

	/**
	 * Returns the south pane
	 *
	 * @return A Layout pane on the center div
	 */

	@Override
	public JQLayoutDiv<?> getSouth()
	{
		if (south == null)
		{
			setSouth(new JQLayoutDiv<>(this, JQLayoutArea.South, new JQLayoutContentDiv<>()));
		}
		return south;
	}

	/**
	 * Sets the south pane
	 *
	 * @param southDiv
	 * 		The new center panel
	 */

	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSouth(JQLayoutDiv<?> southDiv)
	{
		if (getComponent() != null)
		{
			remove(south);
		}
		south = southDiv;
		return (J) this;
	}

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */

	@Override
	@NotNull
	public JQLayoutDiv<?> getEast()
	{
		if (east == null)
		{
			setEast(new JQLayoutDiv<>(this, JQLayoutArea.East, new JQLayoutContentDiv<>()));
		}
		return east;
	}

	/**
	 * Sets the center pane
	 *
	 * @param eastDiv
	 * 		The new center panel
	 */

	@Override
	@SuppressWarnings("unchecked")
	public J setEast(JQLayoutDiv<?> eastDiv)
	{
		if (getComponent() != null)
		{
			remove(east);
		}
		east = eastDiv;
		return (J) this;
	}

	/**
	 * Creates a toggle button that uses the animation for the given pane on the component.
	 * <p>
	 * The feature is added to the component
	 *
	 * @param pane
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public JQLayoutSlideToggleLayoutDivFeature createSlideToggleButton(JQLayoutArea pane)
	{
		return new JQLayoutSlideToggleLayoutDivFeature(getPane(pane));
	}

	/**
	 * Creates a toggle button that uses the animation for the given pane on the component.
	 * <p>
	 * The feature is added to the component
	 *
	 * @param pane
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public JQLayoutAddSlideToggleButtonFeature createAddSlideToggleButton(JQLayoutArea pane, Component pinButton)
	{
		return new JQLayoutAddSlideToggleButtonFeature(getPane(pane), pinButton);
	}

	/**
	 * Creates a toggle button for the given pane on the component.
	 * <p>
	 * The feature is added to the component
	 *
	 * @param pane
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public JQLayoutAddPinButtonFeature createPinButton(Component component, JQLayoutArea pane)
	{
		return new JQLayoutAddPinButtonFeature(getPane(pane), component);
	}

	/**
	 * Creates a toggle button for the given pane on the component.
	 * <p>
	 * The feature is added to the component
	 *
	 * @param pane
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public JQLayoutSlideCloseLayoutDivFeature createSlideCloseFeature(JQLayoutArea pane)
	{
		return new JQLayoutSlideCloseLayoutDivFeature(getPane(pane));
	}

	/**
	 * Creates a toggle button for the given pane on the component.
	 * <p>
	 * The feature is added to the component
	 *
	 * @param pane
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public JQLayoutSlideOpenLayoutDivFeature createSlideOpenFeature(JQLayoutArea pane)
	{
		return new JQLayoutSlideOpenLayoutDivFeature(getPane(pane));
	}

	/**
	 * Creates a toggle button for the given pane on the component.
	 * <p>
	 * The feature is added to the component
	 *
	 * @param component
	 * @param pane
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public JQLayoutCloseLayoutDivFeature createCloseButton(Component component, JQLayoutArea pane)
	{
		return new JQLayoutCloseLayoutDivFeature(getPane(pane));
	}

	/**
	 * Creates a toggle button for the given pane on the component.
	 * <p>
	 * The feature is added to the component
	 *
	 * @param component
	 * @param pane
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public JQLayoutOpenLayoutDivFeature createOpenButton(Component component, JQLayoutArea pane)
	{
		return new JQLayoutOpenLayoutDivFeature(getPane(pane));
	}

	/**
	 * Returns the variable ID
	 *
	 * @return
	 */
	@Override
	@NotNull
	public String getVariableID()
	{
		if (variableID == null)
		{
			setVariableID(getID());
		}
		return variableID;
	}

	/**
	 * Sets the variable ID. Adds 'lay_' in front and takes all hyphens (-) into underscores (_)
	 *
	 * @param variableID
	 */
	@Override
	@SuppressWarnings("unchecked")
	public final J setVariableID(@NotNull String variableID)
	{
		this.variableID = "lay_" + variableID.replace(CHAR_DASH, CHAR_UNDERSCORE);
		addVariable(this.variableID);
		return (J) this;
	}

	public boolean isFullScreen()
	{
		return fullScreen;
	}

	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J setFullScreen(boolean fullScreen)
	{
		this.fullScreen = fullScreen;
		return (J) this;
	}

	/**
	 * Returns a clean version of this components options
	 *
	 * @return
	 */
	public IJQLayout asMe()
	{
		return this;
	}

}

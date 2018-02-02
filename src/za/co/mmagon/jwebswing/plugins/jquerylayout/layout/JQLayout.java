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
package za.co.mmagon.jwebswing.plugins.jquerylayout.layout;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.plugins.ComponentInformation;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events.JQLayoutAddPinButtonFeature;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events.JQLayoutAddToggleButtonFeature;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events.JQLayoutCloseLayoutDivFeature;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events.JQLayoutOpenLayoutDivFeature;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.interfaces.IJQLayout;
import za.co.mmagon.logger.LogFactory;

import javax.validation.constraints.NotNull;
import java.util.logging.Logger;

import static za.co.mmagon.jwebswing.utilities.StaticStrings.*;

/**
 * This is a Layout Pane and can be applied to any div to turn it into a border layout
 *
 * @author MMagon
 * @version 1.0
 * @since 16 Jul 2013
 */
@ComponentInformation(name = "JQuery UI Layout", description = "?The UI Layout plug-in can create any UI look you want - from simple headers or sidebars, to a complex application with toolbars, menus, help-panels, status bars, sub-forms, etc.", url = "http://layout.jquery-dev.com/")
public class JQLayout<J extends JQLayout<J>> extends Feature<JQLayoutOptions, J> implements IJQLayout<J>
{

	private static final Logger log = LogFactory.getInstance()
			                                  .getLogger("JQLayout");
	private static final long serialVersionUID = 1L;

	/**
	 * The variable associated with this layout
	 */
	private String variableID;
	/**
	 * The set of options
	 */
	private JQLayoutOptions<?> options;
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

	/**
	 * Constructs a new JWLayout Layout Handler with the given parameters
	 * <p>
	 *
	 * @param component
	 * 		The component to apply the Layout Handler To
	 */
	public JQLayout(ComponentHierarchyBase component)
	{
		super("JQLayout");
		AngularPageConfigurator.setRequired(true);
		setComponent(component);
		setVariableID(component.getID());
		getComponent().addAttribute(GlobalAttributes.JWType, "layout");
		getCenter();
		getComponent().addFeature(this);
	}

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */

	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public final JQLayoutDiv getCenter()
	{
		if (this.center == null)
		{
			setCenter(new JQLayoutDiv(this, JQLayoutArea.Center, new Div()));
		}
		return this.center;
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
		getComponent().remove(this.center);
		this.center = centerDiv;
		if (this.center != null)
		{
			getComponent().add(this.center);
		}
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
		JQLayoutAddToggleButtonFeature atfb = new JQLayoutAddToggleButtonFeature(getPane(pane), component);
		component.addFeature(atfb);
		return atfb;
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
			{
				return getNorth();
			}
			case West:
			{
				return getWest();
			}
			case South:
			{
				return getSouth();
			}
			case East:
			{
				return getEast();
			}
			case Center:
			{
				return getCenter();
			}
			default:
			{
				log.warning("Unknown pane found? - " + area);
				return null;
			}
		}
	}

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */

	@Override
	public JQLayoutDiv getNorth()
	{
		if (this.north == null)
		{
			setNorth(new JQLayoutDiv(this, JQLayoutArea.North, new Div()));
		}
		return this.north;
	}

	/**
	 * Sets the north pane
	 *
	 * @param centerDiv
	 * 		The new center panel
	 */

	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setNorth(JQLayoutDiv centerDiv)
	{
		getComponent().remove(this.north);
		this.north = centerDiv;
		if (this.north != null)
		{
			getComponent().add(this.north);
		}
		return (J) this;
	}

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */
	@Override
	@NotNull
	public JQLayoutDiv getWest()
	{
		if (this.west == null)
		{
			setWest(new JQLayoutDiv(this, JQLayoutArea.West, new Div()));
		}
		return this.west;
	}

	/**
	 * Returns the south pane
	 *
	 * @return A Layout pane on the center div
	 */

	@Override
	public JQLayoutDiv getSouth()
	{
		if (this.south == null)
		{
			setSouth(new JQLayoutDiv(this, JQLayoutArea.South, new Div()));
		}
		return this.south;
	}

	/**
	 * Write the layout options
	 */

	@Override
	public void assignFunctionsToComponent()
	{
		String sb = getVariableID() + STRING_EQUALS + getComponent().getJQueryID() + "layout(" + getNewLine() + getOptions() + STRING_CLOSING_BRACKET_SEMICOLON;
		addQuery(sb);
	}

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */

	@Override
	@NotNull
	public JQLayoutDiv getEast()
	{
		if (this.east == null)
		{
			setEast(new JQLayoutDiv(this, JQLayoutArea.East, new Div()));
		}
		return this.east;
	}

	/**
	 * Sets the center pane
	 *
	 * @param eastDiv
	 * 		The new center panel
	 */

	@Override
	@SuppressWarnings("unchecked")
	public J setEast(JQLayoutDiv eastDiv)
	{
		getComponent().remove(this.east);
		this.east = eastDiv;
		if (this.east != null)
		{
			getComponent().add(this.east);
		}
		return (J) this;
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
	public J setSouth(JQLayoutDiv southDiv)
	{
		getComponent().remove(this.south);
		this.south = southDiv;
		if (this.south != null)
		{
			getComponent().add(this.south);
		}
		return (J) this;
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
	public J setWest(JQLayoutDiv westDiv)
	{
		getComponent().remove(this.west);
		this.west = westDiv;
		if (this.west != null)
		{
			getComponent().add(this.west);
		}
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
	public JQLayoutAddPinButtonFeature createPinButton(Component component, JQLayoutArea pane)
	{
		JQLayoutAddPinButtonFeature atfb = new JQLayoutAddPinButtonFeature(getPane(pane), component);
		component.addFeature(atfb);
		return atfb;
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(0);
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
		JQLayoutOpenLayoutDivFeature atfb = new JQLayoutOpenLayoutDivFeature(getPane(pane));
		component.addFeature(atfb);
		return atfb;
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
		return variableID;
	}

	/**
	 * Returns the layout options
	 * <p>
	 *
	 * @return
	 */

	@Override
	@NotNull
	public JQLayoutOptions getOptions()
	{
		if (options == null)
		{
			options = new JQLayoutOptions();
		}
		return options;
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
		getComponent().addVariable(this.variableID);
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

	/**
	 * Configures the feature
	 */

	@Override
	public void preConfigure()
	{
		if (!isInitialized())
		{
			init();
		}
		if (!isConfigured())
		{
			JQueryPageConfigurator.setRequired(true);
		}
		super.preConfigure();
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
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
		JQLayoutCloseLayoutDivFeature atfb = new JQLayoutCloseLayoutDivFeature(getPane(pane));
		component.addFeature(atfb);
		return atfb;
	}

	@Override
	public J setID(String id)
	{
		setVariableID(id);
		return super.setID(id);
	}
}

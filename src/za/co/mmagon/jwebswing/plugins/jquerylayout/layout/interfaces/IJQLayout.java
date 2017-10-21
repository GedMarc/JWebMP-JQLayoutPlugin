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
package za.co.mmagon.jwebswing.plugins.jquerylayout.layout.interfaces;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.interfaces.LayoutHandler;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.JQLayoutArea;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.JQLayoutDiv;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.JQLayoutOptions;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events.JQLayoutAddPinButtonFeature;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events.JQLayoutAddToggleButtonFeature;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events.JQLayoutCloseLayoutDivFeature;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events.JQLayoutOpenLayoutDivFeature;

/**
 * A Clean Interface for the JQLayout Component
 *
 * @author GedMarc
 * @version 1.0
 * @since Oct 30, 2016
 */
public interface IJQLayout extends LayoutHandler
{

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */
	JQLayoutDiv getCenter();

	/**
	 * Sets the center pane
	 *
	 * @param centerDiv The new center panel
	 */
	void setCenter(JQLayoutDiv centerDiv);

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */
	JQLayoutDiv getEast();

	/**
	 * Sets the center pane
	 *
	 * @param eastDiv The new center panel
	 */
	void setEast(JQLayoutDiv eastDiv);

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */
	JQLayoutDiv getNorth();

	/**
	 * Sets the north pane
	 *
	 * @param centerDiv The new center panel
	 */
	void setNorth(JQLayoutDiv centerDiv);

	/**
	 * Returns the layout options
	 * <p>
	 *
	 * @return
	 */
	JQLayoutOptions getOptions();

	/**
	 * Returns the south pane
	 *
	 * @return A Layout pane on the center div
	 */
	JQLayoutDiv getSouth();

	/**
	 * Sets the south pane
	 *
	 * @param southDiv The new center panel
	 */
	void setSouth(JQLayoutDiv southDiv);

	/**
	 * Returns the variable ID
	 *
	 * @return
	 */
	String getVariableID();

	/**
	 * Sets the variable ID.
	 * Adds 'lay_' in front and takes all hyphens (-) into underscores (_)
	 *
	 * @param variableID
	 */
	void setVariableID(String variableID);

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */
	JQLayoutDiv getWest();

	/**
	 * Sets the center pane
	 *
	 * @param westDiv The new center panel
	 */
	void setWest(JQLayoutDiv westDiv);

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
	public JQLayoutAddToggleButtonFeature createToggleButton(Component component, JQLayoutArea pane);

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
	public JQLayoutAddPinButtonFeature createPinButton(Component component, JQLayoutArea pane);

	/**
	 * Makes the component a close pane button
	 * <p>
	 * The feature is added to the component
	 *
	 * @param component
	 * @param pane
	 *
	 * @return
	 */
	public JQLayoutCloseLayoutDivFeature createCloseButton(Component component, JQLayoutArea pane);

	/**
	 * Makes the component an open pane button
	 * <p>
	 * The feature is added to the component
	 *
	 * @param component
	 * @param pane
	 *
	 * @return
	 */
	public JQLayoutOpenLayoutDivFeature createOpenButton(Component component, JQLayoutArea pane);

}

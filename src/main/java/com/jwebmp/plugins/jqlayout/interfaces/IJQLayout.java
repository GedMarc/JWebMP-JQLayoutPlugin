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

package com.jwebmp.plugins.jqlayout.interfaces;

import com.jwebmp.core.Component;
import com.jwebmp.plugins.jqlayout.JQLayoutDiv;
import com.jwebmp.plugins.jqlayout.JQLayoutOptions;
import com.jwebmp.plugins.jqlayout.enumerations.JQLayoutArea;
import com.jwebmp.plugins.jqlayout.events.*;

import javax.validation.constraints.NotNull;

public interface IJQLayout<J extends IJQLayout<J>>
{
	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */

	@SuppressWarnings("unchecked")
	@NotNull
	JQLayoutDiv getCenter();

	/**
	 * Sets the center pane
	 *
	 * @param centerDiv
	 * 		The new center panel
	 */

	@SuppressWarnings("unchecked")
	@NotNull
	J setCenter(JQLayoutDiv centerDiv);

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
	@SuppressWarnings("unchecked")
	@NotNull
	JQLayoutAddToggleButtonFeature createToggleButton(Component component, JQLayoutArea pane);

	/**
	 * Gets the layout div for a pane
	 *
	 * @param area
	 *
	 * @return
	 */
	JQLayoutDiv getPane(JQLayoutArea area);

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */

	JQLayoutDiv<?> getNorth();

	@SuppressWarnings("unchecked")
	@NotNull
	J setNorth(JQLayoutDiv<?> centerDiv);

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */
	@NotNull
	JQLayoutDiv<?> getWest();

	/**
	 * Sets the center pane
	 *
	 * @param westDiv
	 * 		The new center panel
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J setWest(JQLayoutDiv<?> westDiv);

	/**
	 * Returns the south pane
	 *
	 * @return A Layout pane on the center div
	 */

	JQLayoutDiv<?> getSouth();

	/**
	 * Sets the south pane
	 *
	 * @param southDiv
	 * 		The new center panel
	 */

	@SuppressWarnings("unchecked")
	@NotNull
	J setSouth(JQLayoutDiv<?> southDiv);

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */

	@NotNull
	JQLayoutDiv<?> getEast();

	/**
	 * Sets the center pane
	 *
	 * @param eastDiv
	 * 		The new center panel
	 */

	@SuppressWarnings("unchecked")
	J setEast(JQLayoutDiv<?> eastDiv);

	@SuppressWarnings("unchecked")
	@NotNull
	JQLayoutSlideToggleLayoutDivFeature createSlideToggleButton(JQLayoutArea pane);

	@SuppressWarnings("unchecked")
	@NotNull
	JQLayoutAddSlideToggleButtonFeature createAddSlideToggleButton(JQLayoutArea pane, Component pinButton);

	/**
	 * Returns the layout options
	 * <p>
	 *
	 * @return
	 */

	@NotNull
	JQLayoutOptions getOptions();

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
	@SuppressWarnings("unchecked")
	@NotNull
	JQLayoutAddPinButtonFeature createPinButton(Component component, JQLayoutArea pane);

	@SuppressWarnings("unchecked")
	@NotNull
	JQLayoutSlideCloseLayoutDivFeature createSlideCloseFeature(JQLayoutArea pane);

	@SuppressWarnings("unchecked")
	@NotNull
	JQLayoutSlideOpenLayoutDivFeature createSlideOpenFeature(JQLayoutArea pane);

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
	@SuppressWarnings("unchecked")
	@NotNull
	JQLayoutCloseLayoutDivFeature createCloseButton(Component component, JQLayoutArea pane);

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
	@SuppressWarnings("unchecked")
	@NotNull
	JQLayoutOpenLayoutDivFeature createOpenButton(Component component, JQLayoutArea pane);

	/**
	 * Returns the variable ID
	 *
	 * @return
	 */
	@NotNull
	String getVariableID();

	/**
	 * Sets the variable ID. Adds 'lay_' in front and takes all hyphens (-) into underscores (_)
	 *
	 * @param variableID
	 */
	@SuppressWarnings("unchecked")
	J setVariableID(@NotNull String variableID);

	@NotNull
	@SuppressWarnings("unchecked")
	J setFullScreen(boolean fullScreen);
}

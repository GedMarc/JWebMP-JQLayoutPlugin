/*
 * Copyright (C) 2017 GedMarc
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

import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.plugins.jqlayout.JQLayoutDiv;
import com.jwebmp.plugins.jqlayout.JQLayoutOptions;
import com.jwebmp.plugins.jqlayout.enumerations.JQLayoutArea;
import com.jwebmp.plugins.jqlayout.events.*;
import jakarta.validation.constraints.NotNull;

public interface IJQLayout<J extends IJQLayout<J>>
{
	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */
	@NotNull
	JQLayoutDiv<?> getCenter();

	/**
	 * Sets the center pane
	 *
	 * @param centerDiv
	 * 		The new center panel
	 */

	
	@NotNull
	J setCenter(JQLayoutDiv<?> centerDiv);

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
	
	@NotNull
	JQLayoutAddToggleButtonFeature createToggleButton(IComponentHierarchyBase<?,?> component, JQLayoutArea pane);

	/**
	 * Gets the layout div for a pane
	 *
	 * @param area
	 *
	 * @return
	 */
	JQLayoutDiv<?> getPane(JQLayoutArea area);

	/**
	 * Returns the center pane
	 *
	 * @return A Layout pane on the center div
	 */

	JQLayoutDiv<?> getNorth();

	
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

	
	J setEast(JQLayoutDiv<?> eastDiv);

	
	@NotNull
	JQLayoutSlideToggleLayoutDivFeature createSlideToggleButton(JQLayoutArea pane);

	
	@NotNull
	JQLayoutAddSlideToggleButtonFeature createAddSlideToggleButton(JQLayoutArea pane, IComponentHierarchyBase<?,?> pinButton);

	/**
	 * Returns the layout options
	 * <p>
	 *
	 * @return
	 */

	@NotNull
	JQLayoutOptions<?> getOptions();

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
	
	@NotNull
	JQLayoutAddPinButtonFeature createPinButton(IComponentHierarchyBase<?,?> component, JQLayoutArea pane);

	
	@NotNull
	JQLayoutSlideCloseLayoutDivFeature createSlideCloseFeature(JQLayoutArea pane);

	
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
	
	@NotNull
	JQLayoutCloseLayoutDivFeature createCloseButton(IComponentHierarchyBase<?,?> component, JQLayoutArea pane);

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
	
	@NotNull
	JQLayoutOpenLayoutDivFeature createOpenButton(IComponentHierarchyBase<?,?> component, JQLayoutArea pane);

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
	
	J setVariableID(@NotNull String variableID);

	@NotNull
	
	J setFullScreen(boolean fullScreen);
}

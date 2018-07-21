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
package com.jwebmp.plugins.jqlayout.events;

import com.jwebmp.core.Component;
import com.jwebmp.core.Feature;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.jqlayout.JQLayoutDiv;

/**
 * Sets the given component as a button that will toggle the open close state of the layout
 *
 * @author MMagon
 * @version 1.0
 * @since 23 Sep 2013
 */
public class JQLayoutAddToggleButtonFeature
		extends Feature<JavaScriptPart, JQLayoutAddToggleButtonFeature>
{

	private static final long serialVersionUID = 1L;

	private final JQLayoutDiv divToOpen;

	public JQLayoutAddToggleButtonFeature(JQLayoutDiv layoutDiv, Component pinButton)
	{
		super("JWLayoutToggleButtonFeature");
		setComponent(pinButton);
		divToOpen = layoutDiv;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}

	@Override
	public void assignFunctionsToComponent()
	{
		String openDivFunction = divToOpen.getLayout()
		                                  .getVariableID() + ".addToggleBtn('#" + getComponent().getID() + "',\"" + divToOpen.getArea()
		                                                                                                                     .toString()
		                                                                                                                     .toLowerCase() + "\");" + getNewLine();
		addQuery(openDivFunction);
	}
}

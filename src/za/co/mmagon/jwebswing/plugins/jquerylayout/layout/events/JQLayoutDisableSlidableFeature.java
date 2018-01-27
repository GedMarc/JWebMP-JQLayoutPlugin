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
package za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.JQLayoutDiv;

/**
 * Disables sliding for a pane
 *
 * @author MMagon
 * @version 1.0
 * @since 23 Sep 2013
 */
@SuppressWarnings("unused")
public class JQLayoutDisableSlidableFeature extends Feature<JavaScriptPart, JQLayoutDisableSlidableFeature>
{

	private static final long serialVersionUID = 1L;
	/**
	 * The layout div to open
	 */
	private final JQLayoutDiv divToOpen;

	/**
	 * Adds a pin button for the layout side to the given component
	 *
	 * @param layoutDiv
	 * @param pinButton
	 */
	public JQLayoutDisableSlidableFeature(JQLayoutDiv layoutDiv, Component pinButton)
	{
		super("JQLayoutDisableSlidableFeature");
		setComponent(pinButton);
		divToOpen = layoutDiv;
	}

	@Override
	public void assignFunctionsToComponent()
	{
		String openDivFunction = divToOpen.getLayout()
				                         .getVariableID() + ".disableSlidable(\"" + divToOpen.getArea()
						                                                                    .toString()
						                                                                    .toLowerCase() + "\");" + getNewLine();
		addQuery(openDivFunction);
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof JQLayoutDisableSlidableFeature))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		JQLayoutDisableSlidableFeature that = (JQLayoutDisableSlidableFeature) o;

		return divToOpen != null ? divToOpen.equals(that.divToOpen) : that.divToOpen == null;
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (divToOpen != null ? divToOpen.hashCode() : 0);
		return result;
	}
}

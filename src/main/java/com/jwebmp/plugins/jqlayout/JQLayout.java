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
package com.jwebmp.plugins.jqlayout;

import com.jwebmp.Feature;
import com.jwebmp.plugins.ComponentInformation;
import com.jwebmp.plugins.jqlayout.components.BorderLayout;

import javax.validation.constraints.NotNull;

import static com.jwebmp.utilities.StaticStrings.*;

/**
 * This is a Layout Pane and can be applied to any div to turn it into a border layout
 *
 * @author MMagon
 * @version 1.0
 * @since 16 Jul 2013
 */
@ComponentInformation(name = "JQuery UI Layout",
		description = "?The UI Layout plug-in can create any UI look you want - from simple headers or sidebars, to a complex application with toolbars, menus, help-panels, status bars, sub-forms, etc.",
		url = "http://layout.jquery-dev.com/")
public class JQLayout<J extends JQLayout<J>>
		extends Feature<JQLayoutOptions, J>

{
	private static final String NAME = "JQLayout";
	private static final long serialVersionUID = 1L;

	/**
	 * The set of options
	 */
	private JQLayoutOptions<?> options;

	public JQLayout()
	{
		this(null);
	}

	/**
	 * Constructs a new JWLayout Layout Handler with the given parameters
	 * <p>
	 *
	 * @param component
	 * 		The component to apply the Layout Handler To
	 */
	public JQLayout(BorderLayout component)
	{
		super(NAME, component);
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
		if (options == null)
		{
			options = new JQLayoutOptions<>();
		}
		return options;
	}

	/**
	 * Write the layout options
	 */
	@Override
	public void assignFunctionsToComponent()
	{
		String sb = ((BorderLayout) getComponent()).getVariableID() +
		            STRING_EQUALS +
		            getComponent().getJQueryID() +
		            "layout(" +
		            getNewLine() +
		            getOptions() +
		            STRING_CLOSING_BRACKET_SEMICOLON;
		addQuery(sb);
	}

}

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
package com.jwebmp.plugins.jqlayout.enumerations;

import com.jwebmp.core.base.interfaces.ICssClassName;
import com.jwebmp.core.utilities.StaticStrings;

import static com.guicedee.services.jsonrepresentation.json.StaticStrings.CHAR_DASH;
import static com.guicedee.services.jsonrepresentation.json.StaticStrings.CHAR_UNDERSCORE;
import static com.jwebmp.core.utilities.StaticStrings.*;

/**
 * @author MMagon
 * @version 1.0
 * @since 21 Jul 2013
 */
public enum JQLayoutCSSThemeBlockNames
		implements ICssClassName
{
	/**
	 * The Layout Component Content
	 */
	UI_Layout_Content,
	/**
	 * The Layout Component Content
	 */
	UI_Layout_North,
	/**
	 * The Layout Component Content
	 */
	UI_Layout_South,
	/**
	 * The Layout Component Content
	 */
	UI_Layout_East,
	/**
	 * The Layout Component Content
	 */
	UI_Layout_Center,
	/**
	 * The Layout Component Content
	 */
	UI_Layout_West,
	/**
	 * A specific header
	 */
	UI_Layout_Header,
	/**
	 * A specific footer
	 */
	UI_Layout_Footer;

	@Override
	public String toString()
	{
		return name().toLowerCase()
		             .replace(CHAR_UNDERSCORE, CHAR_DASH);
	}

}

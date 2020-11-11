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

package com.jwebmp.plugins.jqlayout.options;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.jqlayout.enumerations.LayoutResponsiveSize;

import jakarta.validation.constraints.NotNull;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * The default responsive options
 *
 * @param <J>
 * 		always this
 *
 * @since 2018/01/27
 */
public class JQLayoutResponsiveOptions<J extends JQLayoutResponsiveOptions<J>>
		extends JavaScriptPart<J>
{
	private Boolean enabled;
	private LayoutResponsiveSize when;

	private Map<LayoutResponsiveSize, Integer> sizes;

	/**
	 * Creates a new responsive object with the given parameters
	 *
	 * @param enabled
	 * 		if this object is enabled
	 * @param when
	 * 		when the object must transform
	 * @param sizes
	 * 		a map of sizes to the trasform
	 * 		<p>
	 * 		default
	 * 		, sizes: {
	 * 		xl: 1140,
	 * 		lg: 992,
	 * 		md: 768,
	 * 		sm: 576,
	 * 		xs: 0
	 * 		}
	 */
	public JQLayoutResponsiveOptions(Boolean enabled, LayoutResponsiveSize when, SortedMap<LayoutResponsiveSize, Integer> sizes)
	{
		this();
		this.enabled = enabled;
		this.when = when;
		this.sizes = sizes;
	}

	/**
	 * Created a new responsive options object
	 * <p>
	 * default sizes
	 * <p>
	 * <p>
	 * default
	 * , sizes: {
	 * xl: 1140,
	 * lg: 992,
	 * md: 768,
	 * sm: 576,
	 * xs: 0
	 * }
	 */

	public JQLayoutResponsiveOptions()
	{
		//No config needed
	}

	/**
	 * Gets if the responsive feature is enabled
	 *
	 * @return
	 */
	public Boolean getEnabled()
	{
		return enabled;
	}

	/**
	 * Sets if the responsive feature is enabled
	 *
	 * @param enabled
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setEnabled(Boolean enabled)
	{
		this.enabled = enabled;
		return (J) this;
	}

	/**
	 * Gets when the sizes of the obejct responds
	 *
	 * @return
	 */
	public LayoutResponsiveSize getWhen()
	{
		return when;
	}

	/**
	 * Sets when the sizes of the object respond
	 *
	 * @param when
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setWhen(LayoutResponsiveSize when)
	{
		this.when = when;
		return (J) this;
	}

	/**
	 * Returns a tree map if wasn't set
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public Map<LayoutResponsiveSize, Integer> getSizes()
	{
		if (sizes == null)
		{
			sizes = new TreeMap<>();
		}
		return sizes;
	}

	/**
	 * Sets the sizes of the object
	 *
	 * @param sizes
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSizes(Map<LayoutResponsiveSize, Integer> sizes)
	{
		this.sizes = sizes;
		return (J) this;
	}
}

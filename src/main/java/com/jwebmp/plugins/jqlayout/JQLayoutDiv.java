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
package com.jwebmp.plugins.jqlayout;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.Component;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.HeaderText;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.children.BodyChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.plugins.jqlayout.components.BorderLayout;
import com.jwebmp.plugins.jqlayout.enumerations.JQLayoutArea;
import com.jwebmp.plugins.jqlayout.enumerations.JQLayoutAttributes;
import com.jwebmp.plugins.jqlayout.enumerations.JQLayoutCSSThemeBlockNames;
import com.jwebmp.plugins.jqlayout.events.JQLayoutAddPinButtonFeature;
import com.jwebmp.plugins.jqlayout.events.JQLayoutAddToggleButtonFeature;
import com.jwebmp.plugins.jqlayout.events.JQLayoutCloseLayoutDivFeature;
import com.jwebmp.plugins.jqlayout.events.JQLayoutOpenLayoutDivFeature;
import com.jwebmp.plugins.jqlayout.interfaces.IJQLayoutDiv;
import com.jwebmp.plugins.jqlayout.interfaces.JQLayoutDivChildren;
import com.jwebmp.plugins.jqlayout.options.JQLayoutDefaultOptions;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import static com.jwebmp.plugins.jqlayout.enumerations.JQLayoutArea.*;

/**
 * This class makes sure only layout DIV's gets added to Layout's Also adds capability of headers and footers
 *
 * @author MMagon
 * @version 1.0
 * @since 16 Jul 2013
 */
public class JQLayoutDiv<J extends JQLayoutDiv<J>>
		extends Div<JQLayoutDivChildren, JQLayoutAttributes, GlobalFeatures, GlobalEvents, J>
		implements BodyChildren<JQLayoutDivChildren, J>, IJQLayoutDiv<J>
{
	/**
	 * The layout area of this particular Layout Div
	 */
	private JQLayoutArea area;
	/**
	 * All the header containers
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<JQLayoutHeaderDiv<?>> headers;
	/**
	 * All the footer containers
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<JQLayoutFooterDiv<?>> footers;
	/**
	 * The main center div
	 */
	private JQLayoutContentDiv<?> contentDiv;
	/**
	 * The layout div
	 */
	@JsonIgnore
	private BorderLayout<?> layout;

	/**
	 * An empty an unconfigured layout div
	 */
	public JQLayoutDiv()
	{
		//No config required
	}

	/**
	 * Constructs a new Border Layout Div
	 * <p>
	 *
	 * @param layout
	 * 		The layout applying to
	 * @param area
	 * 		The area this div is for
	 * @param contentDiv
	 * 		The content div. Never null please
	 */
	public JQLayoutDiv(BorderLayout<?> layout, JQLayoutArea area, JQLayoutContentDiv<?> contentDiv)
	{
		setLayout(layout);
		setContentDiv(contentDiv);
		setArea(area);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void init()
	{
		if (!isInitialized() && !getHeaders().isEmpty())
		{
			for (int i = 0, j = 0; i < getHeaders().size(); i++, j++)
			{
				JQLayoutHeaderDiv<?> get = getHeaders().get(i);
				List list = new ArrayList(getChildren());
				list.add(j, get);
				setChildren(new LinkedHashSet<>(list));
				get.init();
				get.preConfigure();
			}
		}
		if (!isInitialized() && !getFooters().isEmpty())
		{
			for (JQLayoutFooterDiv<?> footer : getFooters())
			{
				add(footer);
			}
		}
		super.init();
	}

	/**
	 * Returns a never empty list of header
	 *
	 * @return
	 */
	@Override
	@NotNull
	public List<JQLayoutHeaderDiv<?>> getHeaders()
	{
		if (headers == null)
		{
			headers = new ArrayList<>();
		}
		return headers;
	}

	/**
	 * Returns the footers listing
	 *
	 * @return
	 */
	@Override
	@NotNull
	public List<JQLayoutFooterDiv<?>> getFooters()
	{
		if (footers == null)
		{
			footers = new ArrayList<>();
		}
		return footers;
	}

	/**
	 * Sets the footer collection
	 *
	 * @param footers
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J setFooters(List<JQLayoutFooterDiv<?>> footers)
	{
		this.footers = footers;
		if (footers != null)
		{
			footers.forEach(next -> next.addClass(JQLayoutCSSThemeBlockNames.UI_Layout_Header));
		}
		return (J) this;
	}

	/**
	 * Sets the headers
	 *
	 * @param headers
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setHeaders(List<JQLayoutHeaderDiv<?>> headers)
	{
		this.headers = headers;
		headers.forEach(this::addHeader);
		return (J) this;
	}

	/**
	 * *
	 * Adds a new header to the div and applies the Widget Header class
	 * <p>
	 *
	 * @param headerDivString
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addHeader(String headerDivString)
	{
		JQLayoutHeaderDiv<?> headerDiv = new JQLayoutHeaderDiv<>();
		headerDiv.add(headerDivString);
		addHeader(headerDiv);
		return (J) this;
	}

	/**
	 * Adds the Div as a header and applies the class Widget Header
	 * <p>
	 *
	 * @param headerDiv
	 */

	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addHeader(JQLayoutHeaderDiv<?> headerDiv)
	{
		getHeaders().add(headerDiv);
		headerDiv.addClass(JQLayoutCSSThemeBlockNames.UI_Layout_Header.toString());
		return (J) this;
	}

	/**
	 * Adds the footer header
	 * <p>
	 *
	 * @param footerHeaderText
	 */

	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addFooter(HeaderText footerHeaderText)
	{
		JQLayoutFooterDiv<?> headerDiv = new JQLayoutFooterDiv<>();
		headerDiv.add(footerHeaderText);
		getFooters().add(headerDiv);
		return (J) this;
	}

	/**
	 * Adds a Pin for this Div
	 * <p>
	 *
	 * @param component
	 *
	 * @return The original component
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addPin(Component component)
	{
		component.addFeature(new JQLayoutAddPinButtonFeature(this, component));
		return (J) this;
	}

	/**
	 * Adds the open event to a component
	 * <p>
	 *
	 * @param button
	 * 		The component to add the open event to
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addToggleButton(Component button)
	{
		button.addFeature(new JQLayoutAddToggleButtonFeature(this, button));
		return (J) this;
	}

	/**
	 * Adds the close event to the component
	 * <p>
	 *
	 * @param button
	 * 		The button to add a close event to
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addCloseButton(Component button)
	{
		button.addFeature(new JQLayoutCloseLayoutDivFeature(this));
		return (J) this;
	}

	/**
	 * Adds the footer to the component
	 * <p>
	 *
	 * @param footerDiv
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addFooter(JQLayoutFooterDiv<?> footerDiv)
	{
		if (footerDiv != null)
		{
			getFooters().add(footerDiv);
		}
		return (J) this;
	}

	/**
	 * Adds the footer
	 * <p>
	 *
	 * @param footerDivString
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addFooter(String footerDivString)
	{
		JQLayoutFooterDiv<?> headerDiv = new JQLayoutFooterDiv<>();
		headerDiv.add(footerDivString);
		getFooters().add(headerDiv);
		return (J) this;
	}

	/**
	 * Adds the header to the layout div
	 * <p>
	 *
	 * @param headerDivString
	 */

	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addHeader(HeaderText headerDivString)
	{
		JQLayoutHeaderDiv<?> headerDiv = new JQLayoutHeaderDiv<>();
		headerDiv.add(headerDivString);
		addHeader(headerDiv);
		return (J) this;
	}

	/**
	 * Adds the open event to a component
	 * <p>
	 *
	 * @param button
	 * 		The component to add the open event to
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J addOpenButton(Component button)
	{
		button.addFeature(new JQLayoutOpenLayoutDivFeature(this));
		return (J) this;
	}

	/**
	 * Removes the footer
	 * <p>
	 *
	 * @param footerDiv
	 */

	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J removeFooter(JQLayoutFooterDiv<?> footerDiv)
	{
		getFooters().remove(footerDiv);
		getChildren().remove(footerDiv);
		return (J) this;
	}

	/**
	 * Removes the header
	 * <p>
	 *
	 * @param headerDiv
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J removeHeader(JQLayoutHeaderDiv<?> headerDiv)
	{
		getHeaders().remove(headerDiv);
		getChildren().remove(headerDiv);
		return (J) this;
	}

	/**
	 * Gets the current assigned area
	 * <p>
	 *
	 * @return
	 */
	@Override
	@NotNull
	public JQLayoutArea getArea()
	{
		if (area == null)
		{
			area = Center;
		}
		return area;
	}

	/**
	 * Returns the current content div
	 * <p>
	 *
	 * @return
	 */
	@Override
	@NotNull
	public JQLayoutContentDiv<?> getContentDiv()
	{
		if (contentDiv == null)
		{
			setContentDiv(new JQLayoutContentDiv<>());
		}
		return contentDiv;
	}

	/**
	 * Returns the layout attached to this layout div
	 * <p>
	 *
	 * @return
	 */
	@Override
	@NotNull
	public BorderLayout<?> getLayout()
	{
		if (layout == null)
		{
			layout = new BorderLayout<>();
		}
		return layout;
	}

	/**
	 * Sets the layout for this div
	 * <p>
	 *
	 * @param layout
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public final J setLayout(@NotNull BorderLayout<?> layout)
	{
		this.layout = layout;
		return (J) this;
	}

	/**
	 * Sets the content div of this layout
	 *
	 * @param contentDiv
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public final J setContentDiv(JQLayoutContentDiv<?> contentDiv)
	{
		if (this.contentDiv != null)
		{
			getChildren().remove(this.contentDiv);
		}
		this.contentDiv = contentDiv;
		if (this.contentDiv != null)
		{
			this.contentDiv.addClass(JQLayoutCSSThemeBlockNames.UI_Layout_Content.toString());
			add(this.contentDiv);
		}
		return (J) this;
	}

	/**
	 * Sets the current assigned area
	 * <p>
	 *
	 * @param area
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public final J setArea(JQLayoutArea area)
	{
		if (area != null)
		{
			removeClass(area.getAreaClass()
			                .toString());
		}
		this.area = area;
		if (this.area != null)
		{
			addClass(this.area.getAreaClass()
			                  .toString());
		}
		return (J) this;
	}

	/**
	 * Returns a clean version of this components options
	 *
	 * @return
	 */
	public IJQLayoutDiv<J> asMe()
	{
		return this;
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
	@NotNull
	public JQLayoutDefaultOptions getOptions()
	{
		switch (getArea())
		{
			case North:
				return getLayout().getOptions()
				                  .getNorth();
			case Center:
				return getLayout().getOptions()
				                  .getCenter();
			case South:
				return getLayout().getOptions()
				                  .getSouth();
			case East:
				return getLayout().getOptions()
				                  .getEast();
			case West:
				return getLayout().getOptions()
				                  .getWest();
			default:
				return getLayout().getOptions()
				                  .getCenter();
		}
	}

}

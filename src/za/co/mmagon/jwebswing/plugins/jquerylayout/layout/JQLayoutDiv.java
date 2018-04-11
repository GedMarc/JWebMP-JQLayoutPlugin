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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.HeaderText;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.BodyChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events.JQLayoutAddPinButtonFeature;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events.JQLayoutAddToggleButtonFeature;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events.JQLayoutCloseLayoutDivFeature;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.events.JQLayoutOpenLayoutDivFeature;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.interfaces.IJQLayoutDiv;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.interfaces.JWLayoutDivChildren;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.options.JQLayoutDefaultOptions;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import static za.co.mmagon.jwebswing.plugins.jquerylayout.layout.JQLayoutCSSThemeBlockNames.UI_Layout_Footer;
import static za.co.mmagon.jwebswing.plugins.jquerylayout.layout.JQLayoutCSSThemeBlockNames.UI_Layout_Header;

/**
 * This class makes sure only layout DIV's gets added to Layout's Also adds capability of headers and footers
 *
 * @author MMagon
 * @version 1.0
 * @since 16 Jul 2013
 */
public class JQLayoutDiv<J extends JQLayoutDiv<J>>
		extends Div<JWLayoutDivChildren, JQLayoutAttributes, GlobalFeatures, GlobalEvents, J>
		implements BodyChildren, GlobalChildren, IJQLayoutDiv
{

	/**
	 * Version 1
	 */
	private static final long serialVersionUID = 1L;

	private static final String UiFooterString = "ui-layout-footer";

	/**
	 * The layout area of this particular Layout Div
	 */
	private JQLayoutArea area;
	/**
	 * All the header containers
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Div> headers;
	/**
	 * All the footer containers
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<Component> footers;
	/**
	 * The main center div
	 */
	private Div<?, ?, ?, ?, ?> contentDiv;
	/**
	 * The layout div
	 */
	@JsonIgnore
	private JQLayout layout;

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
	public JQLayoutDiv(JQLayout layout, JQLayoutArea area, Div contentDiv)
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
				Div get = getHeaders().get(i);
				get.addClass(UI_Layout_Header);
				List list = new ArrayList(getChildren());
				list.add(j, get);
				setChildren(new LinkedHashSet<>(list));
				get.preConfigure();
			}
		}
		if (!isInitialized() && !getFooters().isEmpty())
		{
			for (Component footer : getFooters())
			{
				getChildren().add(footer);
				footer.addClass(UI_Layout_Footer);
				footer.preConfigure();
			}
		}
		super.init();
	}

	/**
	 * Returns a never empty list of header
	 *
	 * @return
	 */
	@NotNull
	public List<Div> getHeaders()
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
	@NotNull
	public List<Component> getFooters()
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
	@NotNull
	@SuppressWarnings("unchecked")
	public J setFooters(List<Component> footers)
	{
		this.footers = footers;
		if (footers != null)
		{
			footers.forEach(next -> next.addClass(UiFooterString));
		}
		return (J) this;
	}

	/**
	 * Sets the headers
	 *
	 * @param headers
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setHeaders(List<Div> headers)
	{
		this.headers = headers;
		headers.forEach(this::addHeader);
		return (J) this;
	}

	/**
	 * Returns a clean version of this components options
	 *
	 * @return
	 */
	public IJQLayoutDiv asMe()
	{
		return this;
	}

	/**
	 * *
	 * Adds a new header to the div and applies the Widget Header class
	 * <p>
	 *
	 * @param headerDivString
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J addHeader(String headerDivString)
	{
		Div headerDiv = new Div();
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

	@SuppressWarnings("unchecked")
	@NotNull
	public J addHeader(Div headerDiv)
	{
		getHeaders().add(headerDiv);
		headerDiv.addClass(UI_Layout_Header.toString());
		return (J) this;
	}

	/**
	 * Adds the footer header
	 * <p>
	 *
	 * @param footerHeaderText
	 */

	@SuppressWarnings("unchecked")
	@NotNull
	public J addFooter(HeaderText footerHeaderText)
	{
		Div headerDiv = new Div();
		headerDiv.add(footerHeaderText);
		headerDiv.addClass(UiFooterString);
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
	@SuppressWarnings("unchecked")
	@NotNull
	public J addFooter(Component footerDiv)
	{
		if (footerDiv != null)
		{
			getFooters().add(footerDiv);
			footerDiv.addClass(UiFooterString);
		}
		return (J) this;
	}

	/**
	 * Adds the footer
	 * <p>
	 *
	 * @param footerDivString
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J addFooter(String footerDivString)
	{
		Div headerDiv = new Div();
		headerDiv.add(footerDivString);
		headerDiv.addClass(UiFooterString);
		getFooters().add(headerDiv);
		return (J) this;
	}

	/**
	 * Adds the header to the layout div
	 * <p>
	 *
	 * @param headerDivString
	 */

	@SuppressWarnings("unchecked")
	@NotNull
	public J addHeader(HeaderText headerDivString)
	{
		Div headerDiv = new Div();
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

	@SuppressWarnings("unchecked")
	@NotNull
	public J removeFooter(Div footerDiv)
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
	@SuppressWarnings("unchecked")
	@NotNull
	public J removeHeader(Div headerDiv)
	{
		getHeaders().remove(headerDiv);
		getChildren().remove(headerDiv);
		return (J) this;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof JQLayoutDiv))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		JQLayoutDiv that = (JQLayoutDiv) o;

		if (getArea() != that.getArea())
		{
			return false;
		}
		if (getHeaders() != null ? !getHeaders().equals(that.getHeaders()) : that.getHeaders() != null)
		{
			return false;
		}
		if (getFooters() != null ? !getFooters().equals(that.getFooters()) : that.getFooters() != null)
		{
			return false;
		}
		if (getContentDiv() != null ? !getContentDiv().equals(that.getContentDiv()) : that.getContentDiv() != null)
		{
			return false;
		}
		return getLayout() != null ? getLayout().equals(that.getLayout()) : that.getLayout() == null;
	}

	/**
	 * Gets the current assigned area
	 * <p>
	 *
	 * @return
	 */
	@NotNull
	public JQLayoutArea getArea()
	{
		return area;
	}

	/**
	 * Returns the current content div
	 * <p>
	 *
	 * @return
	 */
	@NotNull
	public Div<?, ?, ?, ?, ?> getContentDiv()
	{
		if (contentDiv == null)
		{
			setContentDiv(new Div());
		}
		return contentDiv;
	}

	/**
	 * Returns the layout attached to this layout div
	 * <p>
	 *
	 * @return
	 */
	@NotNull
	public JQLayout getLayout()
	{
		return layout;
	}

	/**
	 * Sets the layout for this div
	 * <p>
	 *
	 * @param layout
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public final void setLayout(@NotNull JQLayout layout)
	{
		this.layout = layout;
	}

	/**
	 * Sets the content div of this layout
	 *
	 * @param contentDiv
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public final J setContentDiv(Div contentDiv)
	{
		getChildren().remove(this.contentDiv);
		this.contentDiv = contentDiv;
		if (this.contentDiv != null)
		{
			this.contentDiv.addClass(JQLayoutCSSThemeBlockNames.UI_Layout_Content.toString());
			getChildren().add(this.contentDiv);
		}
		return (J) this;
	}

	/**
	 * Sets the current assigned area
	 * <p>
	 *
	 * @param area
	 */
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

	@Override
	public int hashCode()
	{
		return super.hashCode();
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

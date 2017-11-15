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
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
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

import java.util.ArrayList;
import java.util.List;

/**
 * This class makes sure only layout DIV's gets added to Layout's Also adds capability of headers and footers
 *
 * @author MMagon
 * @version 1.0
 * @since 16 Jul 2013
 */
public class JQLayoutDiv extends Div<JWLayoutDivChildren, NoAttributes, GlobalFeatures, GlobalEvents, JQLayoutDiv>
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
	private Div contentDiv;
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
	public void init()
	{
		if (!isInitialized())
		{
			if (!getHeaders().isEmpty())
			{
				for (int i = getHeaders().size(); i >= 0; i--)
				{
					Div get = getHeaders().get(i);
					getChildren().add(get);
					get.preConfigure();
				}
			}
			if (!getFooters().isEmpty())
			{
				for (Component footer : getFooters())
				{
					getChildren().add(footer);
					footer.preConfigure();
				}
			}
		}
		super.init();
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
	 * Adds the Div as a header and applies the class Widget Header
	 * <p>
	 *
	 * @param headerDiv
	 */
	@Override
	public void addHeader(Div headerDiv)
	{
		getHeaders().add(headerDiv);
		headerDiv.addClass(JQLayoutCSSThemeBlockNames.UI_Layout_Header.toString());
	}

	/**
	 * *
	 * Adds a new header to the div and applies the Widget Header class
	 * <p>
	 *
	 * @param headerDivString
	 */
	public void addHeader(String headerDivString)
	{
		Div headerDiv = new Div();
		headerDiv.add(headerDivString);
		addHeader(headerDiv);
	}

	/**
	 * Adds the header to the layout div
	 * <p>
	 *
	 * @param headerDivString
	 */
	@Override
	public void addHeader(HeaderText headerDivString)
	{
		Div headerDiv = new Div();
		headerDiv.add(headerDivString);
		addHeader(headerDiv);
	}

	/**
	 * Adds a Pin for this Div
	 * <p>
	 *
	 * @param component
	 *
	 * @return The Span
	 */
	@Override
	public Component addPin(Component component)
	{
		component.addFeature(new JQLayoutAddPinButtonFeature(this, component));
		return component;
	}

	/**
	 * Adds the open event to a component
	 * <p>
	 *
	 * @param button
	 * 		The component to add the open event to
	 */
	@Override
	public void addToggleButton(Component button)
	{
		button.addFeature(new JQLayoutAddToggleButtonFeature(this, button));
	}

	/**
	 * Adds the close event to the component
	 * <p>
	 *
	 * @param button
	 * 		The button to add a close event to
	 */
	@Override
	public void addCloseButton(Component button)
	{
		button.addFeature(new JQLayoutCloseLayoutDivFeature(this));
	}

	/**
	 * Adds the footer to the component
	 * <p>
	 *
	 * @param footerDiv
	 */
	@Override
	public void addFooter(Component footerDiv)
	{
		if (footerDiv != null)
		{
			getFooters().add(footerDiv);
			footerDiv.addClass(UiFooterString);
		}
	}

	/**
	 * Adds the footer
	 * <p>
	 *
	 * @param footerDivString
	 */
	@Override
	public void addFooter(String footerDivString)
	{
		Div headerDiv = new Div();
		headerDiv.add(footerDivString);
		headerDiv.addClass(UiFooterString);
		getFooters().add(headerDiv);
	}

	/**
	 * Returns the footers listing
	 *
	 * @return
	 */
	@Override
	public List<Component> getFooters()
	{
		if (footers == null)
		{
			footers = new ArrayList<>();
		}
		return footers;
	}

	/**
	 * Adds the footer header
	 * <p>
	 *
	 * @param footerDivString
	 */
	@Override
	public void addFooter(HeaderText footerDivString)
	{
		Div headerDiv = new Div();
		headerDiv.add(footerDivString);
		headerDiv.addClass(UiFooterString);
		getFooters().add(headerDiv);
	}

	/**
	 * Adds the open event to a component
	 * <p>
	 *
	 * @param button
	 * 		The component to add the open event to
	 */
	@Override
	public void addOpenButton(Component button)
	{
		button.addFeature(new JQLayoutOpenLayoutDivFeature(this));
	}

	/**
	 * Sets the footer collection
	 *
	 * @param footers
	 */
	public void setFooters(List<Component> footers)
	{
		this.footers = footers;
		if (footers != null)
		{
			footers.forEach(next -> next.addClass(UiFooterString));
		}
	}

	/**
	 * Removes the footer
	 * <p>
	 *
	 * @param footerDiv
	 */
	@Override
	public void removeFooter(Div footerDiv)
	{
		getFooters().remove(footerDiv);
		getChildren().remove(footerDiv);
	}

	/**
	 * Removes the header
	 * <p>
	 *
	 * @param headerDiv
	 */
	@Override
	public void removeHeader(Div headerDiv)
	{
		getHeaders().remove(headerDiv);
		getChildren().remove(headerDiv);
	}

	/**
	 * Returns a never empty list of header
	 *
	 * @return
	 */
	public List<Div> getHeaders()
	{
		if (headers == null)
		{
			headers = new ArrayList<>();
		}
		return headers;
	}

	/**
	 * Sets the headers
	 *
	 * @param headers
	 */
	public void setHeaders(List<Div> headers)
	{
		this.headers = headers;
		headers.forEach(this::addHeader);
	}

	/**
	 * Gets the current assigned area
	 * <p>
	 *
	 * @return
	 */
	public JQLayoutArea getArea()
	{
		return area;
	}

	/**
	 * Sets the current assigned area
	 * <p>
	 *
	 * @param area
	 */
	@Override
	public final void setArea(JQLayoutArea area)
	{
		if (area != null)
		{
			removeClass(area.getAreaClass().toString());
		}
		this.area = area;
		if (this.area != null)
		{
			addClass(this.area.getAreaClass().toString());
		}
	}

	/**
	 * Returns the current content div
	 * <p>
	 *
	 * @return
	 */
	@Override
	public Div getContentDiv()
	{
		if (contentDiv == null)
		{
			setContentDiv(new Div());
		}
		return contentDiv;
	}

	/**
	 * Sets the content div of this layout
	 *
	 * @param contentDiv
	 */
	public final void setContentDiv(Div contentDiv)
	{
		getChildren().remove(this.contentDiv);
		this.contentDiv = contentDiv;
		if (this.contentDiv != null)
		{
			this.contentDiv.addClass(JQLayoutCSSThemeBlockNames.UI_Layout_Content.toString());
			getChildren().add(this.contentDiv);
		}
	}

	/**
	 * Returns the layout attached to this layout div
	 * <p>
	 *
	 * @return
	 */
	@Override
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
	@Override
	public final void setLayout(JQLayout layout)
	{
		this.layout = layout;
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

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + (getArea() != null ? getArea().hashCode() : 0);
		result = 31 * result + (getHeaders() != null ? getHeaders().hashCode() : 0);
		result = 31 * result + (getFooters() != null ? getFooters().hashCode() : 0);
		result = 31 * result + (getContentDiv() != null ? getContentDiv().hashCode() : 0);
		result = 31 * result + (getLayout() != null ? getLayout().hashCode() : 0);
		return result;
	}

	@Override
	public JQLayoutDefaultOptions getOptions()
	{
		switch (this.getArea())
		{
			case North:
				return getLayout().getOptions().getNorth();
			case Center:
				return getLayout().getOptions().getCenter();
			case South:
				return getLayout().getOptions().getSouth();
			case East:
				return getLayout().getOptions().getEast();
			case West:
				return getLayout().getOptions().getWest();
			default:
				return getLayout().getOptions().getCenter();
		}
	}


}

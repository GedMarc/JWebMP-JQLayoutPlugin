package com.jwebmp.plugins.jquerylayout.layout.interfaces;

import com.jwebmp.Component;
import com.jwebmp.base.ComponentHierarchyBase;
import com.jwebmp.base.html.Div;
import com.jwebmp.base.html.HeaderText;
import com.jwebmp.base.html.interfaces.AttributeDefinitions;
import com.jwebmp.base.html.interfaces.GlobalChildren;
import com.jwebmp.base.html.interfaces.GlobalFeatures;
import com.jwebmp.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.plugins.jquerylayout.layout.JQLayoutDiv;
import com.jwebmp.plugins.jquerylayout.layout.components.BorderLayout;
import com.jwebmp.plugins.jquerylayout.layout.enumerations.JQLayoutArea;
import com.jwebmp.plugins.jquerylayout.layout.options.JQLayoutDefaultOptions;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface IJQLayoutDiv<J extends JQLayoutDiv<J>>
{

	/**
	 * Returns a never empty list of header
	 *
	 * @return
	 */
	@NotNull
	List<Div> getHeaders();

	/**
	 * Returns the footers listing
	 *
	 * @return
	 */
	@NotNull
	List<ComponentHierarchyBase> getFooters();

	/**
	 * Sets the footer collection
	 *
	 * @param footers
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	J setFooters(List<ComponentHierarchyBase> footers);

	/**
	 * Sets the headers
	 *
	 * @param headers
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J setHeaders(List<Div> headers);

	/**
	 * *
	 * Adds a new header to the div and applies the Widget Header class
	 * <p>
	 *
	 * @param headerDivString
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J addHeader(String headerDivString);

	/**
	 * Adds the Div as a header and applies the class Widget Header
	 * <p>
	 *
	 * @param headerDiv
	 */

	@SuppressWarnings("unchecked")
	@NotNull
	J addHeader(Div headerDiv);

	/**
	 * Adds the footer header
	 * <p>
	 *
	 * @param footerHeaderText
	 */

	@SuppressWarnings("unchecked")
	@NotNull
	J addFooter(HeaderText footerHeaderText);

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
	J addPin(Component component);

	/**
	 * Adds the open event to a component
	 * <p>
	 *
	 * @param button
	 * 		The component to add the open event to
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J addToggleButton(Component button);

	/**
	 * Adds the close event to the component
	 * <p>
	 *
	 * @param button
	 * 		The button to add a close event to
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J addCloseButton(Component button);

	/**
	 * Adds the footer to the component
	 * <p>
	 *
	 * @param footerDiv
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J addFooter(Component footerDiv);

	/**
	 * Adds the footer
	 * <p>
	 *
	 * @param footerDivString
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J addFooter(String footerDivString);

	/**
	 * Adds the header to the layout div
	 * <p>
	 *
	 * @param headerDivString
	 */

	@SuppressWarnings("unchecked")
	@NotNull
	J addHeader(HeaderText headerDivString);

	/**
	 * Adds the open event to a component
	 * <p>
	 *
	 * @param button
	 * 		The component to add the open event to
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J addOpenButton(Component button);

	/**
	 * Removes the footer
	 * <p>
	 *
	 * @param footerDiv
	 */

	@SuppressWarnings("unchecked")
	@NotNull
	J removeFooter(Div footerDiv);

	/**
	 * Removes the header
	 * <p>
	 *
	 * @param headerDiv
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J removeHeader(Div headerDiv);

	/**
	 * Gets the current assigned area
	 * <p>
	 *
	 * @return
	 */
	@NotNull
	JQLayoutArea getArea();

	/**
	 * Returns the current content div
	 * <p>
	 *
	 * @return
	 */
	@NotNull
	<C extends GlobalChildren, A extends Enum & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents> Div<C, A, F, E, ?> getContentDiv();

	/**
	 * Returns the layout attached to this layout div
	 * <p>
	 *
	 * @return
	 */
	@NotNull
	BorderLayout<?> getLayout();

	/**
	 * Sets the layout for this div
	 * <p>
	 *
	 * @param layout
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J setLayout(@NotNull BorderLayout<?> layout);

	/**
	 * Sets the content div of this layout
	 *
	 * @param contentDiv
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J setContentDiv(Div contentDiv);

	/**
	 * Sets the current assigned area
	 * <p>
	 *
	 * @param area
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J setArea(JQLayoutArea area);

	@NotNull
	JQLayoutDefaultOptions getOptions();
}

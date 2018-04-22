/*
 * Copyright (C) 2016 ged_m
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
package com.jwebmp.components.jqueryLayout.layout;

import com.jwebmp.Page;
import com.jwebmp.base.ajax.AjaxResponse;
import com.jwebmp.base.angular.AngularPageConfigurator;
import com.jwebmp.base.html.Button;
import com.jwebmp.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.plugins.jquerylayout.layout.JQLayout;
import com.jwebmp.plugins.jquerylayout.layout.options.LayoutResponsiveSize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.jwebmp.plugins.jquerylayout.layout.JQLayoutArea.East;
import static com.jwebmp.plugins.jquerylayout.layout.JQLayoutArea.West;

/**
 * @author ged_m
 */
public class JQLayoutTest

{

	public JQLayoutTest()
	{
	}

	@Test
	public void testJQLayout()
	{
		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
		Page p = new Page();
		JQLayout layout = new JQLayout(p.getBody());
		p.getOptions()
		 .setDynamicRender(true);
		System.out.println(p.toString(true));

		System.out.println(layout.renderJavascript());

	}

	@Test
	public void testResponsive()
	{
		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
		Page p = new Page();
		JQLayout<?> layout = new JQLayout<>(p.getBody());

		layout.getOptions()
		      .getDefaults()
		      .getResponsive()
		      .setEnabled(true);
		System.out.println(layout.renderJavascript());
	}

	@Test
	public void testResponsiveSizes()
	{
		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
		Page p = new Page();
		JQLayout<?> layout = new JQLayout<>(p.getBody());
		layout.getOptions()
		      .getDefaults()
		      .getResponsive()
		      .getSizes()
		      .put(LayoutResponsiveSize.ExtraLarge, 500);

		System.out.println(layout.renderJavascript());
	}

	@Test
	public void testAjaxResponseAdditions()
	{

		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
		Page p = new Page();
		JQLayout<?> layout = new JQLayout<>(p.getBody());

		Button pin = new Button();
		Button toggle = new Button();

		AjaxResponse ar = new AjaxResponse();
		ar.getFeatures()
		  .add(layout.createPinButton(pin, West));
		System.out.println("Feature Size : " + ar.getFeatures()
		                                         .size());
		ar.getFeatures()
		  .add(layout.createToggleButton(toggle, West));
		System.out.println("Feature Size : " + ar.getFeatures()
		                                         .size());

		System.out.println(ar.toString());

		ar.getFeatures()
		  .add(layout.createPinButton(pin, East));
		ar.getFeatures()
		  .add(layout.createToggleButton(toggle, East));

		System.out.println("Feature Size : " + ar.getFeatures()
		                                         .size());
		System.out.println(ar.toString());

		Assertions.assertEquals(4, ar.getFeatures()
		                             .size());
	}
}

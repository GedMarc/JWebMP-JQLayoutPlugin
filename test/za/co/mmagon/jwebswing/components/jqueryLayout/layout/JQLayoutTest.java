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
package za.co.mmagon.jwebswing.components.jqueryLayout.layout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.base.html.Button;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.JQLayout;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.options.LayoutResponsiveSize;

import static za.co.mmagon.jwebswing.plugins.jquerylayout.layout.JQLayoutArea.East;
import static za.co.mmagon.jwebswing.plugins.jquerylayout.layout.JQLayoutArea.West;

/**
 * @author ged_m
 */
public class JQLayoutTest extends BaseTestClass
{

	public JQLayoutTest()
	{
	}

	@Test
	public void testJQLayout()
	{
		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
		Page p = getPage();
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

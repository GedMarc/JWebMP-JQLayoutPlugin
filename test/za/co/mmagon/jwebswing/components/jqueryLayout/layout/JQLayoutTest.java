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

import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.angular.AngularPageConfigurator;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.JQLayout;
import za.co.mmagon.jwebswing.plugins.jquerylayout.layout.options.LayoutResponsiveSize;

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
		JQueryPageConfigurator.setRequired(true);
		AngularPageConfigurator.setRequired(false);
		Page p = getPage();
		JQLayout layout = new JQLayout(p.getBody());
		System.out.println(p.toString(true));
		System.out.println(layout.renderJavascript());

	}

	@Test
	public void testResponsive()
	{
		JQueryPageConfigurator.setRequired(true);
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
		JQueryPageConfigurator.setRequired(true);
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
}

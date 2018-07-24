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

import com.jwebmp.core.Page;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.core.services.IPageConfigurator;

/**
 * The page configuration for UI Layout enablement
 *
 * @author GedMarc
 * @since 27 Feb 2017
 */
@PluginInformation(pluginName = "JQuery UI Layout",
		pluginUniqueName = "jquery-layout",
		pluginDescription = "The UI Layout plug-in can create any UI look you want - from simple headers or sidebars, to a complex application with toolbars, menus, help-panels, status bars, sub-forms, etc.",
		pluginVersion = "1.6.3",
		pluginDependancyUniqueIDs = "jquery,jquery-easing",
		pluginCategories = "jquery, layouts,border layout, jwebswing",
		pluginSubtitle = "The Ultimate Page Layout Manager",
		pluginGitUrl = "https://github.com/GedMarc/JWebSwing-JQLayoutPlugin",
		pluginSourceUrl = "https://github.com/GedMarc/layout",
		pluginWikiUrl = "https://github.com/GedMarc/JWebSwing-JQLayoutPlugin/wiki",
		pluginOriginalHomepage = "http://layout.jquery-dev.com/",
		pluginDownloadUrl = "https://sourceforge.net/projects/jwebswing/files/plugins/JQLayoutPlugin.jar/download",
		pluginIconUrl = "bower_components/jquery-layout-latest-1-5/borderlayout.gif",
		pluginIconImageUrl = "bower_components/jquery-layout-latest-1-5/borderlayout.gif",
		pluginLastUpdatedDate = "2017/03/04")
public class JQLayoutPageConfigurator
		implements IPageConfigurator
{
	/**
	 * Configures the page
	 */
	public JQLayoutPageConfigurator()
	{
		//Nothing Needed
	}

	@Override
	@SuppressWarnings("unchecked")
	public Page configure(Page page)
	{
			JQueryPageConfigurator.setRequired(true);
			AngularPageConfigurator.setRequired(true);
			page.getBody()
			    .getJavascriptReferences()
			    .add(JQLayoutReferencePool.JQueryLayout.getJavaScriptReference());
			page.getBody()
			    .getCssReferences()
			    .add(JQLayoutReferencePool.JQueryLayout.getCssReference());
		return page;
	}
}

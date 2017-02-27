/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package za.co.mmagon.jwebswing.plugins.jquerylayout.layout;

import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.PageConfigurator;
import za.co.mmagon.jwebswing.plugins.PluginInformation;

/**
 *
 * @author GedMarc
 * @since 27 Feb 2017
 *
 */
@PluginInformation(pluginName = "JQuery UI Layout", pluginUniqueName = "jquery-layout",
        pluginDescription = "The UI Layout plug-in can create any UI look you want - from simple headers or sidebars, to a complex application with toolbars, menus, help-panels, status bars, sub-forms, etc.",
        pluginVersion = "1.5.13",
        pluginDependancyUniqueIDs = "", pluginCategories = "jquery, layouts,border layout, jwebswing",
        pluginSubtitle = "The Ultimate Page Layout Manager",
        pluginGitUrl = "https://github.com/GedMarc/JWebSwing-JQLayoutPlugin",
        pluginSourceUrl = "https://github.com/GedMarc/layout",
        pluginWikiUrl = "https://github.com/GedMarc/JWebSwing-JQLayoutPlugin/wiki",
        pluginOriginalHomepage = "http://layout.jquery-dev.com/")
public class JQLayoutPageConfigurator extends PageConfigurator
{

    private static final long serialVersionUID = 1L;

    public JQLayoutPageConfigurator()
    {

    }

    @Override
    public Page configure(Page page)
    {
        if (!page.isConfigured())
        {

        }

        return page;
    }
}

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

import java.util.logging.*;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.plugins.ComponentInformation;
import za.co.mmagon.jwebswing.plugins.jquery.JQueryPageConfigurator;
import za.co.mmagon.logger.LogFactory;

/**
 * This class is essentially the Border Layout. Each child div controls it's own settings, access via getRegionLayoutDiv()
 *
 * @author MMagon
 * @since 16 Jul 2013
 * @version 1.0
 */
@ComponentInformation(name = "JQuery UI Layout", description = "?The UI Layout plug-in can create any UI look you want - from simple headers or sidebars, to a complex application with toolbars, menus, help-panels, status bars, sub-forms, etc.",
                      url = "http://layout.jquery-dev.com/")
public class JQLayout extends Feature<JQLayoutOptions, JQLayout> implements IJQLayout
{

    private static final Logger log = LogFactory.getInstance().getLogger("JWLayout");
    private static final long serialVersionUID = 1L;

    /**
     * The variable associated with this layout
     */
    private String variableID;
    /**
     * The set of options
     */
    private JQLayoutOptions options;
    /**
     * The center div
     */
    private JQLayoutDiv center;
    /**
     * The north div
     */
    private JQLayoutDiv north;
    /**
     * The east div
     */
    private JQLayoutDiv east;
    /**
     * The west div
     */
    private JQLayoutDiv west;
    /**
     * The south div
     */
    private JQLayoutDiv south;

    /**
     * Returns a clean version of this components options
     *
     * @return
     */
    public IJQLayout asMe()
    {
        return this;
    }

    /**
     * Constructs a new JWLayout Layout Handler with the given parameters
     * <p>
     * @param component The component to apply the Layout Handler To
     */
    public JQLayout(ComponentHierarchyBase component)
    {
        super("JQLayout");
        setComponent(component);
        getComponent().addFeature(this);
        setVariableID(component.getID());
        getComponent().addAttribute(GlobalAttributes.JWType, "layout");
        getCenter();
    }

    /**
     * Configures the feature
     */
    @Override
    public void preConfigure()
    {
        if (!isInitialized())
        {
            init();
        }
        if (!isConfigured())
        {
            JQueryPageConfigurator.setRequired((Component) getComponent(), true);
        }
        super.preConfigure();
    }

    /**
     * Write the layout options
     */
    @Override
    public void assignFunctionsToComponent()
    {
        StringBuilder sb = new StringBuilder("var lay_"
                + getComponent().getID()
                + " = "
                + getComponent().getJQueryID()
                + "layout(" + getNewLine());
        sb.append(getOptions());
        sb.append(");");
        addQuery(sb.toString());
    }

    /**
     * Sets the variable ID. Adds 'lay_' in front and takes all hyphens (-) into underscores (_)
     *
     * @param variableID
     */
    @Override
    public final void setVariableID(String variableID)
    {
        this.variableID = "lay_" + variableID.replace('-', '_');
        getComponent().addVariable(this.variableID);
    }

    /**
     * Returns the variable ID
     *
     * @return
     */
    @Override
    public String getVariableID()
    {
        return variableID;
    }

    /**
     * Returns the layout options
     * <p>
     * @return
     */
    @Override
    public JQLayoutOptions getOptions()
    {
        if (options == null)
        {
            options = new JQLayoutOptions();
        }

        return options;
    }

    /**
     * Returns the center pane
     *
     * @return A Layout pane on the center div
     */
    @Override
    public JQLayoutDiv getCenter()
    {
        if (this.center == null)
        {
            setCenter(new JQLayoutDiv(this, JQLayoutArea.Center, new Div()));
        }
        return this.center;
    }

    /**
     * Sets the center pane
     *
     * @param centerDiv The new center panel
     */
    @Override
    public void setCenter(JQLayoutDiv centerDiv)
    {
        getComponent().remove(this.center);
        this.center = centerDiv;
        if (this.center != null)
        {
            getComponent().add(this.center);
        }
    }

    /**
     * Returns the center pane
     *
     * @return A Layout pane on the center div
     */
    @Override
    public JQLayoutDiv getNorth()
    {
        if (this.north == null)
        {
            setNorth(new JQLayoutDiv(this, JQLayoutArea.North, new Div()));
        }
        return this.north;
    }

    /**
     * Sets the north pane
     *
     * @param centerDiv The new center panel
     */
    @Override
    public void setNorth(JQLayoutDiv centerDiv)
    {
        getComponent().remove(this.north);
        this.north = centerDiv;
        if (this.north != null)
        {
            getComponent().add(this.north);
        }
    }

    /**
     * Returns the south pane
     *
     * @return A Layout pane on the center div
     */
    @Override
    public JQLayoutDiv getSouth()
    {
        if (this.south == null)
        {
            setSouth(new JQLayoutDiv(this, JQLayoutArea.South, new Div()));
        }
        return this.south;
    }

    /**
     * Sets the south pane
     *
     * @param southDiv The new center panel
     */
    @Override
    public void setSouth(JQLayoutDiv southDiv)
    {
        getComponent().remove(this.south);
        this.south = southDiv;
        if (this.south != null)
        {
            getComponent().add(this.south);
        }
    }

    /**
     * Returns the center pane
     *
     * @return A Layout pane on the center div
     */
    @Override
    public JQLayoutDiv getWest()
    {
        if (this.west == null)
        {
            setWest(new JQLayoutDiv(this, JQLayoutArea.West, new Div()));
        }
        return this.west;
    }

    /**
     * Sets the center pane
     *
     * @param westDiv The new center panel
     */
    @Override
    public void setWest(JQLayoutDiv westDiv)
    {
        getComponent().remove(this.west);
        this.west = westDiv;
        if (this.west != null)
        {
            getComponent().add(this.west);
        }
    }

    /**
     * Returns the center pane
     *
     * @return A Layout pane on the center div
     */
    @Override
    public JQLayoutDiv getEast()
    {
        if (this.east == null)
        {
            setEast(new JQLayoutDiv(this, JQLayoutArea.East, new Div()));
        }
        return this.east;
    }

    /**
     * Sets the center pane
     *
     * @param eastDiv The new center panel
     */
    @Override
    public void setEast(JQLayoutDiv eastDiv)
    {
        getComponent().remove(this.east);
        this.east = eastDiv;
        if (this.east != null)
        {
            getComponent().add(this.east);
        }
    }
}

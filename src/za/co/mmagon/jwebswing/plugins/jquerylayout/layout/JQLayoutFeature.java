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
import java.util.logging.*;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.logger.LogFactory;

/**
 * This class builds the JQuery needed for the Layout component
 *
 * @author MMagon
 * @since 2013/07/16
 */
public class JQLayoutFeature extends Feature<JQLayoutOptions, JQLayoutFeature>
{

    private static final Logger log = LogFactory.getInstance().getLogger("JWLayout Feature");
    private static final long serialVersionUID = 1L;
    private String layoutID;
    private String variableID;
    @JsonIgnore
    private final JQLayout myComponent;
    private final JQLayoutOptions options = new JQLayoutOptions();

    public JQLayoutFeature(JQLayout onComponent)
    {
        super("BorderLayoutFeature");
        myComponent = onComponent;
        setComponent(myComponent.getComponent());
        setVariableID(myComponent.getComponent());
    }

    @Override
    public void assignFunctionsToComponent()
    {
        //Config for the layout options from the divs
        StringBuilder sb = new StringBuilder(variableID + " = $('#" + this.layoutID + "').layout(");
        sb.append(getOptions());
        sb.append(");");
        addQuery(sb.toString());
        //addQuery("resizeLayouts();" + getNewLine());
    }

    /**
     * Returns the JavaScript variable ID associated with the layout
     *
     * @return The JavaScript variable ID
     */
    public String getVariableID()
    {
        return variableID;
    }

    /**
     * Component to apply the layout to
     *
     * @param layoutID
     */
    public void setLayoutID(ComponentHierarchyBase layoutID)
    {
        setComponent(layoutID);
        this.layoutID = layoutID.getID() == null ? "null" : layoutID.getID();
    }

    /**
     * Component to apply for. Sets the layout ID as well
     *
     * @param layoutComponent
     */
    public final void setVariableID(ComponentHierarchyBase layoutComponent)
    {
        layoutComponent.removeVariable(variableID);
        setLayoutID(layoutComponent);
        setComponent(layoutComponent);
        variableID = "lay_" + getLayoutID().replace('-', '_');
        layoutComponent.addVariable(variableID);
    }

    public void setVariableID(String componentID)
    {
        variableID = "lay_" + componentID.replace('-', '_');
        this.layoutID = componentID;

        setVariableID(getComponent());
    }

    public String getLayoutID()
    {
        return layoutID;
    }

    /**
     * Returns the layout options
     * <p>
     * @return
     */
    @Override
    public JQLayoutOptions getOptions()
    {
        return this.options;
    }
}

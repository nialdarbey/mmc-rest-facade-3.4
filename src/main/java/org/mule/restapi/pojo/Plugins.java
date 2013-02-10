package org.mule.restapi.pojo;

import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Plugins
{
    private List<Plugin> plugins;

    public List<Plugin> getPlugins()
    {
        return plugins;
    }

    public void setPlugins(List<Plugin> plugins)
    {
        this.plugins = plugins;
    }

}

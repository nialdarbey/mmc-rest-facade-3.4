package org.mule.restapi.pojo;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Plugin
{
    private String name;
    private boolean enabled;
//    private Map<String, String> properties;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    @Override
    public String toString()
    {
        return "Plugin{" +
                "name='" + name + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    //    public Map<String, String> getProperties()
//    {
//        return properties;
//    }
//
//    public void setProperties(Map<String, String> properties)
//    {
//        this.properties = properties;
//    }
}

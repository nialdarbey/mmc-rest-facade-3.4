/**
 * Mule Rest Module
 *
 * Copyright 2011-2012 (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * This software is protected under international copyright law. All use of this software is
 * subject to MuleSoft's Master Subscription Agreement (or other master license agreement)
 * separately entered into in writing between you and MuleSoft. If such an agreement is not
 * in place, you may not use the software.
 */

package org.mule.modules.rest.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.mule.api.annotations.ContainsTransformerMethods;
import org.mule.api.annotations.Transformer;

import com.fasterxml.jackson.databind.ObjectMapper;


@ContainsTransformerMethods
@XmlRootElement
@JsonAutoDetect
public class Teams {
    private List<Team> teams;

    @XmlElement(name = "teams")
    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }


    @Transformer(resultMimeType = "application/json")
    public String toJson(Teams teams) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(teams);
    }

    @Transformer(resultMimeType = "text/xml")
    public String toXml(Teams teams) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(getClass());

        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        m.marshal(teams, boas);

        return new String(boas.toByteArray());
    }
}
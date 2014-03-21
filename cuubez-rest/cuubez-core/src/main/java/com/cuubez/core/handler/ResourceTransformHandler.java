package com.cuubez.core.handler;


import com.cuubez.core.context.MessageContext;
import com.cuubez.core.engine.transform.Transformer;
import com.cuubez.core.engine.transform.json.JSONTransformer;
import com.cuubez.core.engine.transform.xml.XMLTransformer;

import javax.ws.rs.core.MediaType;

public class ResourceTransformHandler implements ResponseHandler {


    @Override
    public void handle(MessageContext messageContext) {


        if (MediaType.APPLICATION_XML.equals(messageContext.getResponseContext().getMediaType())) {

            Transformer transformer = new XMLTransformer();
            String output = transformer.marshal(messageContext.getResponseContext().getReturnObject());
            messageContext.getResponseContext().setContent(output);

        } else if (MediaType.APPLICATION_JSON.equals(messageContext.getResponseContext().getMediaType())) {

            Transformer transformer = new JSONTransformer();
            String output = transformer.marshal(messageContext.getResponseContext().getReturnObject());
            messageContext.getResponseContext().setContent(output);

        }

    }
}

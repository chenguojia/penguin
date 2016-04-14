package com.cardvalue.penguin.util;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by guojia.chen on 2015-12-30 13:56.
 *
 * @Description:
 */
public class XMLConverter {

    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public Marshaller getMarshaller() {
        return marshaller;
    }

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public String convertFromObjectToXML(Object object) throws IOException {
        StringWriter ss = null;
        try {
            ss = new StringWriter();
            getMarshaller().marshal(object, new StreamResult(ss));
            return ss.toString();
        } finally {
            if (ss != null) {
                ss.close();
            }
        }
    }

    public Object convertFromXMLToObject(String xml) throws IOException {
        StringReader sr = null;
        try {
            sr = new StringReader(xml);
            return getUnmarshaller().unmarshal(new StreamSource(sr));
        } finally {
            if (sr != null) {
                sr.close();
            }
        }
    }

}

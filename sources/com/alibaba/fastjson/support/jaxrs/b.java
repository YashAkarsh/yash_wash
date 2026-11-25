package com.alibaba.fastjson.support.jaxrs;

import java.util.Map;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import org.glassfish.jersey.CommonProperties;
import org.glassfish.jersey.internal.util.PropertiesHelper;

/* JADX INFO: loaded from: classes.dex */
public class b implements Feature {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f13199a = b.class.getSimpleName();

    public boolean a(FeatureContext featureContext) {
        Configuration configuration = featureContext.getConfiguration();
        Map properties = configuration.getProperties();
        RuntimeType runtimeType = configuration.getRuntimeType();
        String str = f13199a;
        if (!str.equalsIgnoreCase((String) CommonProperties.getValue(properties, runtimeType, "jersey.config.jsonFeature", str, String.class))) {
            return false;
        }
        featureContext.property(PropertiesHelper.getPropertyNameForRuntime("jersey.config.jsonFeature", configuration.getRuntimeType()), str);
        if (!configuration.isRegistered(c.class)) {
            featureContext.register(c.class, new Class[]{MessageBodyReader.class, MessageBodyWriter.class});
        }
        return true;
    }
}

package com.alibaba.fastjson.support.jaxrs;

import javax.annotation.Priority;
import javax.ws.rs.core.FeatureContext;
import org.glassfish.jersey.internal.spi.AutoDiscoverable;

/* JADX INFO: loaded from: classes.dex */
@Priority(1999)
public class a implements AutoDiscoverable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f13198a = true;

    public void a(FeatureContext featureContext) {
        if (featureContext.getConfiguration().isRegistered(b.class) || !f13198a) {
            return;
        }
        featureContext.register(b.class);
    }
}

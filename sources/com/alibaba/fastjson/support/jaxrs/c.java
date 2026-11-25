package com.alibaba.fastjson.support.jaxrs;

import com.alibaba.fastjson.d;
import com.alibaba.fastjson.serializer.h1;
import com.alibaba.fastjson.serializer.k1;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;

/* JADX INFO: loaded from: classes.dex */
@Produces({"*/*"})
@Provider
@Consumes({"*/*"})
public class c implements MessageBodyReader<Object>, MessageBodyWriter<Object> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Class<?>[] f13200i = {InputStream.class, Reader.class};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Class<?>[] f13201j = {InputStream.class, OutputStream.class, Writer.class, StreamingOutput.class, Response.class};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    protected Charset f13202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    protected k1[] f13203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    protected h1[] f13204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    protected String f13205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Context
    protected Providers f13206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.alibaba.fastjson.support.config.a f13207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Class<?>[] f13208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f13209h;

    public c() {
        this.f13202a = Charset.forName("UTF-8");
        this.f13203b = new k1[0];
        this.f13204c = new h1[0];
        this.f13207f = new com.alibaba.fastjson.support.config.a();
        this.f13208g = null;
    }

    @Deprecated
    public Charset a() {
        return this.f13207f.a();
    }

    @Deprecated
    public String b() {
        return this.f13207f.c();
    }

    public com.alibaba.fastjson.support.config.a c() {
        return this.f13207f;
    }

    @Deprecated
    public k1[] d() {
        return this.f13207f.h();
    }

    @Deprecated
    public h1[] e() {
        return this.f13207f.g();
    }

    public long f(Object obj, Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType) {
        return -1L;
    }

    protected boolean g(MediaType mediaType) {
        if (mediaType == null) {
            return true;
        }
        String subtype = mediaType.getSubtype();
        return "json".equalsIgnoreCase(subtype) || subtype.endsWith("+json") || "javascript".equals(subtype) || "x-javascript".equals(subtype) || "x-json".equals(subtype) || "x-www-form-urlencoded".equalsIgnoreCase(subtype) || subtype.endsWith("x-www-form-urlencoded");
    }

    protected boolean h(Class<?> cls, Class<?>[] clsArr) {
        if (cls == null) {
            return false;
        }
        for (Class<?> cls2 : clsArr) {
            if (cls2.isAssignableFrom(cls)) {
                return false;
            }
        }
        return true;
    }

    public boolean i(Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType) {
        if (g(mediaType) && h(cls, f13200i)) {
            return j(cls, annotationArr);
        }
        return false;
    }

    protected boolean j(Class<?> cls, Annotation[] annotationArr) {
        if (cls == null) {
            return false;
        }
        Class<?>[] clsArr = this.f13208g;
        if (clsArr == null) {
            return true;
        }
        for (Class<?> cls2 : clsArr) {
            if (cls2 == cls) {
                return true;
            }
        }
        return false;
    }

    public boolean k(Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType) {
        if (g(mediaType) && h(cls, f13201j)) {
            return j(cls, annotationArr);
        }
        return false;
    }

    protected com.alibaba.fastjson.support.config.a l(Class<?> cls, MediaType mediaType) {
        Providers providers = this.f13206e;
        if (providers != null) {
            ContextResolver contextResolver = providers.getContextResolver(com.alibaba.fastjson.support.config.a.class, mediaType);
            if (contextResolver == null) {
                contextResolver = this.f13206e.getContextResolver(com.alibaba.fastjson.support.config.a.class, (MediaType) null);
            }
            if (contextResolver != null) {
                return (com.alibaba.fastjson.support.config.a) contextResolver.getContext(cls);
            }
        }
        return this.f13207f;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.ws.rs.WebApplicationException */
    public Object m(Class<Object> cls, Type type, Annotation[] annotationArr, MediaType mediaType, MultivaluedMap<String, String> multivaluedMap, InputStream inputStream) throws WebApplicationException, IOException {
        try {
            com.alibaba.fastjson.support.config.a aVarL = l(cls, mediaType);
            return com.alibaba.fastjson.a.L(inputStream, aVarL.a(), type, aVarL.d());
        } catch (d e8) {
            throw new WebApplicationException("JSON parse error: " + e8.getMessage(), e8);
        }
    }

    @Deprecated
    public void n(Charset charset) {
        this.f13207f.j(charset);
    }

    @Deprecated
    public void o(String str) {
        this.f13207f.l(str);
    }

    public void p(com.alibaba.fastjson.support.config.a aVar) {
        this.f13207f = aVar;
    }

    @Deprecated
    public void q(k1... k1VarArr) {
        this.f13207f.q(k1VarArr);
    }

    @Deprecated
    public void r(h1... h1VarArr) {
        this.f13207f.p(h1VarArr);
    }

    public c s(boolean z7) {
        this.f13209h = z7;
        return this;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.ws.rs.WebApplicationException */
    public void t(Object obj, Class<?> cls, Type type, Annotation[] annotationArr, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws WebApplicationException, IOException {
        k1[] k1VarArr;
        com.alibaba.fastjson.support.config.a aVarL = l(cls, mediaType);
        k1[] k1VarArrH = aVarL.h();
        if (this.f13209h) {
            if (k1VarArrH == null) {
                k1VarArr = new k1[]{k1.PrettyFormat};
            } else {
                ArrayList arrayList = new ArrayList(Arrays.asList(k1VarArrH));
                arrayList.add(k1.PrettyFormat);
                k1VarArr = (k1[]) arrayList.toArray(k1VarArrH);
            }
            aVarL.q(k1VarArr);
        }
        try {
            com.alibaba.fastjson.a.Q0(outputStream, aVarL.a(), obj, aVarL.f(), aVarL.g(), aVarL.c(), com.alibaba.fastjson.a.f12533g, aVarL.h());
            outputStream.flush();
        } catch (d e8) {
            throw new WebApplicationException("Could not write JSON: " + e8.getMessage(), e8);
        }
    }

    public c(Class<?>[] clsArr) {
        this.f13202a = Charset.forName("UTF-8");
        this.f13203b = new k1[0];
        this.f13204c = new h1[0];
        this.f13207f = new com.alibaba.fastjson.support.config.a();
        this.f13208g = clsArr;
    }

    @Deprecated
    public c(String str) {
        this.f13202a = Charset.forName("UTF-8");
        this.f13203b = new k1[0];
        this.f13204c = new h1[0];
        com.alibaba.fastjson.support.config.a aVar = new com.alibaba.fastjson.support.config.a();
        this.f13207f = aVar;
        this.f13208g = null;
        aVar.j(Charset.forName(str));
    }
}

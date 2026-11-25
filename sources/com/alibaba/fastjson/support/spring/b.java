package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.serializer.h1;
import com.alibaba.fastjson.serializer.k1;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StringUtils;

/* JADX INFO: loaded from: classes.dex */
public class b extends AbstractHttpMessageConverter<Object> implements GenericHttpMessageConverter<Object> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final MediaType f13222f = new MediaType("application", "javascript");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Charset f13223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    protected k1[] f13224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    protected h1[] f13225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    protected String f13226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.alibaba.fastjson.support.config.a f13227e;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static boolean f13228a;

        static {
            try {
                Class.forName("org.springframework.core.ResolvableType");
                f13228a = true;
            } catch (ClassNotFoundException unused) {
                f13228a = false;
            }
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Type c(Type type, Class<?> cls) {
            if (cls == null) {
                return type;
            }
            ResolvableType resolvableTypeForType = ResolvableType.forType(type);
            if (type instanceof TypeVariable) {
                ResolvableType resolvableTypeE = e((TypeVariable) type, ResolvableType.forClass(cls));
                return resolvableTypeE != ResolvableType.NONE ? resolvableTypeE.resolve() : type;
            }
            if (!(type instanceof ParameterizedType) || !resolvableTypeForType.hasUnresolvableGenerics()) {
                return type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class[] clsArr = new Class[parameterizedType.getActualTypeArguments().length];
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i7 = 0; i7 < actualTypeArguments.length; i7++) {
                Type type2 = actualTypeArguments[i7];
                if (type2 instanceof TypeVariable) {
                    ResolvableType resolvableTypeE2 = e((TypeVariable) type2, ResolvableType.forClass(cls));
                    if (resolvableTypeE2 != ResolvableType.NONE) {
                        clsArr[i7] = resolvableTypeE2.resolve();
                    } else {
                        clsArr[i7] = ResolvableType.forType(type2).resolve();
                    }
                } else {
                    clsArr[i7] = ResolvableType.forType(type2).resolve();
                }
            }
            return ResolvableType.forClassWithGenerics(resolvableTypeForType.getRawClass(), clsArr).getType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean d() {
            return f13228a;
        }

        private static ResolvableType e(TypeVariable<?> typeVariable, ResolvableType resolvableType) {
            if (resolvableType.hasGenerics()) {
                ResolvableType resolvableTypeForType = ResolvableType.forType(typeVariable, resolvableType);
                if (resolvableTypeForType.resolve() != null) {
                    return resolvableTypeForType;
                }
            }
            ResolvableType superType = resolvableType.getSuperType();
            if (superType != ResolvableType.NONE) {
                ResolvableType resolvableTypeE = e(typeVariable, superType);
                if (resolvableTypeE.resolve() != null) {
                    return resolvableTypeE;
                }
            }
            for (ResolvableType resolvableType2 : resolvableType.getInterfaces()) {
                ResolvableType resolvableTypeE2 = e(typeVariable, resolvableType2);
                if (resolvableTypeE2.resolve() != null) {
                    return resolvableTypeE2;
                }
            }
            return ResolvableType.NONE;
        }
    }

    public b() {
        super(MediaType.ALL);
        this.f13223a = Charset.forName("UTF-8");
        this.f13224b = new k1[0];
        this.f13225c = new h1[0];
        this.f13227e = new com.alibaba.fastjson.support.config.a();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.springframework.http.converter.HttpMessageNotReadableException */
    private Object l(Type type, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        try {
            return com.alibaba.fastjson.a.L(httpInputMessage.getBody(), this.f13227e.a(), type, this.f13227e.d());
        } catch (com.alibaba.fastjson.d e8) {
            throw new HttpMessageNotReadableException("JSON parse error: " + e8.getMessage(), e8);
        } catch (IOException e9) {
            throw new HttpMessageNotReadableException("I/O error while reading input message", e9);
        }
    }

    private Object r(Object obj) {
        return (obj == null || !"com.fasterxml.jackson.databind.node.ObjectNode".equals(obj.getClass().getName())) ? obj : obj.toString();
    }

    @Deprecated
    public void a(h1 h1Var) {
        if (h1Var == null) {
            return;
        }
        int length = this.f13227e.g().length;
        int i7 = length + 1;
        h1[] h1VarArr = new h1[i7];
        System.arraycopy(this.f13227e.g(), 0, h1VarArr, 0, length);
        h1VarArr[i7 - 1] = h1Var;
        this.f13227e.p(h1VarArr);
    }

    public boolean b(Type type, Class<?> cls, MediaType mediaType) {
        return super.canRead(cls, mediaType);
    }

    public boolean c(Type type, Class<?> cls, MediaType mediaType) {
        return super.canWrite(cls, mediaType);
    }

    @Deprecated
    public Charset d() {
        return this.f13227e.a();
    }

    @Deprecated
    public String e() {
        return this.f13227e.c();
    }

    public com.alibaba.fastjson.support.config.a f() {
        return this.f13227e;
    }

    @Deprecated
    public k1[] g() {
        return this.f13227e.h();
    }

    @Deprecated
    public h1[] h() {
        return this.f13227e.g();
    }

    protected Type i(Type type, Class<?> cls) {
        return a.d() ? a.c(type, cls) : type;
    }

    public Object j(Type type, Class<?> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return l(i(type, cls), httpInputMessage);
    }

    protected Object k(Class<? extends Object> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return l(i(cls, null), httpInputMessage);
    }

    @Deprecated
    public void m(Charset charset) {
        this.f13227e.j(charset);
    }

    @Deprecated
    public void n(String str) {
        this.f13227e.l(str);
    }

    public void o(com.alibaba.fastjson.support.config.a aVar) {
        this.f13227e = aVar;
    }

    @Deprecated
    public void p(k1... k1VarArr) {
        this.f13227e.q(k1VarArr);
    }

    @Deprecated
    public void q(h1... h1VarArr) {
        this.f13227e.p(h1VarArr);
    }

    protected boolean s(Class<?> cls) {
        return true;
    }

    public void t(Object obj, Type type, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        super.write(obj, mediaType, httpOutputMessage);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004b  */
    protected void u(Object obj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                HttpHeaders headers = httpOutputMessage.getHeaders();
                ArrayList arrayList = new ArrayList(Arrays.asList(this.f13227e.g()));
                Object objR = r(obj);
                if (objR instanceof com.alibaba.fastjson.support.spring.a) {
                    com.alibaba.fastjson.support.spring.a aVar = (com.alibaba.fastjson.support.spring.a) objR;
                    arrayList.addAll(aVar.a().d());
                    objR = aVar.b();
                }
                Object obj2 = objR;
                boolean z7 = true;
                if (obj2 instanceof l) {
                    if (StringUtils.isEmpty(((l) obj2).b())) {
                        z7 = false;
                    }
                } else if (!(obj2 instanceof com.alibaba.fastjson.f)) {
                    z7 = false;
                }
                boolean z8 = z7;
                int iQ0 = com.alibaba.fastjson.a.Q0(byteArrayOutputStream, this.f13227e.a(), obj2, this.f13227e.f(), (h1[]) arrayList.toArray(new h1[arrayList.size()]), this.f13227e.c(), com.alibaba.fastjson.a.f12533g, this.f13227e.h());
                if (z8) {
                    headers.setContentType(f13222f);
                }
                if (this.f13227e.i()) {
                    headers.setContentLength(iQ0);
                }
                byteArrayOutputStream.writeTo(httpOutputMessage.getBody());
                byteArrayOutputStream.close();
            } catch (com.alibaba.fastjson.d e8) {
                throw new HttpMessageNotWritableException("Could not write JSON: " + e8.getMessage(), e8);
            }
        } catch (Throwable th) {
            byteArrayOutputStream.close();
            throw th;
        }
    }
}

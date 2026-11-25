package com.haier.library.json.serializer;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x f26859c = new x();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i3.b<t> f26860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f26861b = com.haier.library.json.a.f26646c;

    public x() {
        i3.b<t> bVar = new i3.b<>(1024);
        this.f26860a = bVar;
        bVar.b(Boolean.class, f.f26820a);
        q qVar = q.f26852a;
        bVar.b(Character.class, qVar);
        bVar.b(Byte.class, k.f26830a);
        bVar.b(Short.class, k.f26830a);
        bVar.b(Integer.class, k.f26830a);
        bVar.b(Long.class, k.f26830a);
        s sVar = s.f26853b;
        bVar.b(Float.class, sVar);
        bVar.b(Double.class, sVar);
        bVar.b(Number.class, sVar);
        e eVar = e.f26819a;
        bVar.b(BigDecimal.class, eVar);
        bVar.b(BigInteger.class, eVar);
        bVar.b(String.class, b0.f26813a);
        bVar.b(Object[].class, b.f26812a);
        bVar.b(Class.class, qVar);
        bVar.b(SimpleDateFormat.class, qVar);
        bVar.b(Locale.class, qVar);
        bVar.b(Currency.class, qVar);
        bVar.b(TimeZone.class, qVar);
        bVar.b(UUID.class, qVar);
        bVar.b(URI.class, qVar);
        bVar.b(URL.class, qVar);
        bVar.b(Pattern.class, qVar);
        bVar.b(Charset.class, qVar);
    }

    public static final x b() {
        return f26859c;
    }

    public t a(Class<?> cls) {
        Class<? super Object> superclass;
        boolean z7;
        t tVarA = this.f26860a.a(cls);
        if (tVarA != null) {
            return tVarA;
        }
        if (Map.class.isAssignableFrom(cls)) {
            this.f26860a.b(cls, new p());
        } else if (List.class.isAssignableFrom(cls)) {
            this.f26860a.b(cls, new o());
        } else if (Collection.class.isAssignableFrom(cls)) {
            this.f26860a.b(cls, g.f26821a);
        } else if (Date.class.isAssignableFrom(cls)) {
            this.f26860a.b(cls, h.f26822a);
        } else if (com.haier.library.json.c.class.isAssignableFrom(cls) || l.class.isAssignableFrom(cls) || com.haier.library.json.f.class.isAssignableFrom(cls)) {
            this.f26860a.b(cls, q.f26852a);
        } else if (cls.isEnum() || !((superclass = cls.getSuperclass()) == null || superclass == Object.class || !superclass.isEnum())) {
            this.f26860a.b(cls, new i());
        } else if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            this.f26860a.b(cls, new c(componentType, a(componentType)));
        } else if (Throwable.class.isAssignableFrom(cls)) {
            n nVar = new n(cls);
            nVar.f26850c |= a0.WriteClassName.f26811a;
            this.f26860a.b(cls, nVar);
        } else if (TimeZone.class.isAssignableFrom(cls) || Charset.class.isAssignableFrom(cls) || Enumeration.class.isAssignableFrom(cls)) {
            this.f26860a.b(cls, q.f26852a);
        } else if (Calendar.class.isAssignableFrom(cls)) {
            this.f26860a.b(cls, h.f26822a);
        } else {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            boolean z8 = false;
            int i7 = 0;
            while (true) {
                if (i7 >= length) {
                    z7 = false;
                    break;
                }
                Class<?> cls2 = interfaces[i7];
                z7 = true;
                if (cls2.getName().equals("net.sf.cglib.proxy.Factory") || cls2.getName().equals("org.springframework.cglib.proxy.Factory")) {
                    z7 = false;
                    z8 = true;
                    break;
                }
                if (cls2.getName().equals("javassist.util.proxy.ProxyObject")) {
                    break;
                }
                i7++;
            }
            if (z8 || z7) {
                t tVarA2 = a(cls.getSuperclass());
                this.f26860a.b(cls, tVarA2);
                return tVarA2;
            }
            this.f26860a.b(cls, new n(cls));
        }
        return this.f26860a.a(cls);
    }

    public String c() {
        return this.f26861b;
    }

    public boolean d(Type type, t tVar) {
        return this.f26860a.b(type, tVar);
    }

    public t e(Class<?> cls) {
        return f(cls, cls.getModifiers(), false, true, true, true);
    }

    public t f(Class<?> cls, int i7, boolean z7, boolean z8, boolean z9, boolean z10) {
        t tVarA = this.f26860a.a(cls);
        if (tVarA != null) {
            return tVarA;
        }
        n nVar = new n(cls, i7, null, z7, z8, z9, z10);
        this.f26860a.b(cls, nVar);
        return nVar;
    }

    public void g(String str) {
        this.f26861b = str;
    }
}

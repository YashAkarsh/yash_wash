package com.haier.library.json.parser;

import com.haier.library.json.serializer.b0;
import com.haier.library.json.serializer.q;
import com.haier.library.json.serializer.s;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static m f26768d = new m();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i3.b<h3.f> f26769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f26770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ClassLoader f26771c;

    public m() {
        i3.b<h3.f> bVar = new i3.b<>(1024);
        this.f26769a = bVar;
        this.f26770b = new o(16384);
        q qVar = q.f26852a;
        bVar.b(SimpleDateFormat.class, qVar);
        com.haier.library.json.serializer.h hVar = com.haier.library.json.serializer.h.f26822a;
        bVar.b(Date.class, hVar);
        bVar.b(Calendar.class, hVar);
        bVar.b(Map.class, k.f26763a);
        bVar.b(HashMap.class, k.f26763a);
        bVar.b(LinkedHashMap.class, k.f26763a);
        bVar.b(TreeMap.class, k.f26763a);
        bVar.b(ConcurrentMap.class, k.f26763a);
        bVar.b(ConcurrentHashMap.class, k.f26763a);
        com.haier.library.json.serializer.g gVar = com.haier.library.json.serializer.g.f26821a;
        bVar.b(Collection.class, gVar);
        bVar.b(List.class, gVar);
        bVar.b(ArrayList.class, gVar);
        i iVar = i.f26759a;
        bVar.b(Object.class, iVar);
        bVar.b(String.class, b0.f26813a);
        bVar.b(Character.TYPE, qVar);
        bVar.b(Character.class, qVar);
        Class cls = Byte.TYPE;
        s sVar = s.f26853b;
        bVar.b(cls, sVar);
        bVar.b(Byte.class, sVar);
        bVar.b(Short.TYPE, sVar);
        bVar.b(Short.class, sVar);
        bVar.b(Integer.TYPE, com.haier.library.json.serializer.k.f26830a);
        bVar.b(Integer.class, com.haier.library.json.serializer.k.f26830a);
        bVar.b(Long.TYPE, com.haier.library.json.serializer.k.f26830a);
        bVar.b(Long.class, com.haier.library.json.serializer.k.f26830a);
        com.haier.library.json.serializer.e eVar = com.haier.library.json.serializer.e.f26819a;
        bVar.b(BigInteger.class, eVar);
        bVar.b(BigDecimal.class, eVar);
        bVar.b(Float.TYPE, sVar);
        bVar.b(Float.class, sVar);
        bVar.b(Double.TYPE, sVar);
        bVar.b(Double.class, sVar);
        Class cls2 = Boolean.TYPE;
        com.haier.library.json.serializer.f fVar = com.haier.library.json.serializer.f.f26820a;
        bVar.b(cls2, fVar);
        bVar.b(Boolean.class, fVar);
        bVar.b(Class.class, qVar);
        com.haier.library.json.serializer.b bVar2 = com.haier.library.json.serializer.b.f26812a;
        bVar.b(char[].class, bVar2);
        bVar.b(Object[].class, bVar2);
        bVar.b(UUID.class, qVar);
        bVar.b(TimeZone.class, qVar);
        bVar.b(Locale.class, qVar);
        bVar.b(Currency.class, qVar);
        bVar.b(URI.class, qVar);
        bVar.b(URL.class, qVar);
        bVar.b(Pattern.class, qVar);
        bVar.b(Charset.class, qVar);
        bVar.b(Number.class, sVar);
        bVar.b(StackTraceElement.class, qVar);
        bVar.b(Serializable.class, iVar);
        bVar.b(Cloneable.class, iVar);
        bVar.b(Comparable.class, iVar);
        bVar.b(Closeable.class, iVar);
    }

    public static m d() {
        return f26768d;
    }

    public static boolean e(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == Date.class || cls == java.sql.Date.class || cls == Time.class || cls == Timestamp.class;
    }

    public h3.d a(m mVar, Class<?> cls, i3.a aVar) {
        Class<?> cls2 = aVar.f34167g;
        return (cls2 == List.class || cls2 == ArrayList.class || (cls2.isArray() && !cls2.getComponentType().isPrimitive())) ? new j(mVar, cls, aVar) : new a(mVar, cls, aVar);
    }

    public h3.f b(Class<?> cls, Type type) {
        h3.f pVar;
        g3.d dVar;
        Class<?> clsMappingTo;
        h3.f fVarA = this.f26769a.a(type);
        if (fVarA != null) {
            return fVarA;
        }
        if (type == null) {
            type = cls;
        }
        h3.f fVarA2 = this.f26769a.a(type);
        if (fVarA2 != null) {
            return fVarA2;
        }
        if (!e(cls) && (dVar = (g3.d) cls.getAnnotation(g3.d.class)) != null && (clsMappingTo = dVar.mappingTo()) != Void.class) {
            return b(clsMappingTo, clsMappingTo);
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable) || (type instanceof ParameterizedType)) {
            fVarA2 = this.f26769a.a(cls);
        }
        if (fVarA2 != null) {
            return fVarA2;
        }
        h3.f fVarA3 = this.f26769a.a(type);
        if (fVarA3 != null) {
            return fVarA3;
        }
        if (cls.isEnum()) {
            pVar = new c(cls);
        } else if (cls.isArray()) {
            pVar = com.haier.library.json.serializer.b.f26812a;
        } else if (cls == Set.class || cls == HashSet.class || cls == Collection.class || cls == List.class || cls == ArrayList.class || Collection.class.isAssignableFrom(cls)) {
            pVar = com.haier.library.json.serializer.g.f26821a;
        } else if (Map.class.isAssignableFrom(cls)) {
            pVar = k.f26763a;
        } else {
            pVar = Throwable.class.isAssignableFrom(cls) ? new p(this, cls) : new g(this, cls, type);
        }
        f(type, pVar);
        return pVar;
    }

    public h3.f c(Type type) {
        h3.f fVarA = this.f26769a.a(type);
        if (fVarA != null) {
            return fVarA;
        }
        if (type instanceof Class) {
            return b((Class) type, type);
        }
        if (!(type instanceof ParameterizedType)) {
            return i.f26759a;
        }
        Type rawType = ((ParameterizedType) type).getRawType();
        return rawType instanceof Class ? b((Class) rawType, type) : c(rawType);
    }

    public void f(Type type, h3.f fVar) {
        this.f26769a.b(type, fVar);
    }

    public h3.f g(Class<?> cls) {
        return h(cls, cls.getModifiers(), false, true, true, true);
    }

    public h3.f h(Class<?> cls, int i7, boolean z7, boolean z8, boolean z9, boolean z10) {
        h3.f fVarA = this.f26769a.a(cls);
        if (fVarA != null) {
            return fVarA;
        }
        g gVar = new g(this, cls, cls, h.b(cls, i7, cls, z7, z8, z9, z10));
        f(cls, gVar);
        return gVar;
    }
}

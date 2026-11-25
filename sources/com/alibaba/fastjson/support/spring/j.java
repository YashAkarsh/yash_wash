package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.serializer.k1;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/* JADX INFO: loaded from: classes.dex */
public class j implements RedisSerializer<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.alibaba.fastjson.parser.j f13247a;

    static {
        com.alibaba.fastjson.parser.j jVar = new com.alibaba.fastjson.parser.j();
        f13247a = jVar;
        jVar.A(true);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.springframework.data.redis.serializer.SerializationException */
    public Object a(byte[] bArr) throws SerializationException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            return com.alibaba.fastjson.a.Y(new String(bArr, com.alibaba.fastjson.util.f.f13318e), Object.class, f13247a, new com.alibaba.fastjson.parser.c[0]);
        } catch (Exception e8) {
            throw new SerializationException("Could not deserialize: " + e8.getMessage(), e8);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.springframework.data.redis.serializer.SerializationException */
    public byte[] b(Object obj) throws SerializationException {
        if (obj == null) {
            return new byte[0];
        }
        try {
            return com.alibaba.fastjson.a.x0(obj, k1.WriteClassName);
        } catch (Exception e8) {
            throw new SerializationException("Could not serialize: " + e8.getMessage(), e8);
        }
    }
}

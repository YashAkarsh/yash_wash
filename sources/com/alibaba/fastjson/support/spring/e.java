package com.alibaba.fastjson.support.spring;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/* JADX INFO: loaded from: classes.dex */
public class e<T> implements RedisSerializer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.alibaba.fastjson.support.config.a f13242a = new com.alibaba.fastjson.support.config.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class<T> f13243b;

    public e(Class<T> cls) {
        this.f13243b = cls;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.springframework.data.redis.serializer.SerializationException */
    public T a(byte[] bArr) throws SerializationException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            return (T) com.alibaba.fastjson.a.d0(bArr, this.f13243b, this.f13242a.d());
        } catch (Exception e8) {
            throw new SerializationException("Could not deserialize: " + e8.getMessage(), e8);
        }
    }

    public com.alibaba.fastjson.support.config.a b() {
        return this.f13242a;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.springframework.data.redis.serializer.SerializationException */
    public byte[] c(T t7) throws SerializationException {
        if (t7 == null) {
            return new byte[0];
        }
        try {
            return com.alibaba.fastjson.a.t0(t7, this.f13242a.f(), this.f13242a.h());
        } catch (Exception e8) {
            throw new SerializationException("Could not serialize: " + e8.getMessage(), e8);
        }
    }

    public void d(com.alibaba.fastjson.support.config.a aVar) {
        this.f13242a = aVar;
    }
}

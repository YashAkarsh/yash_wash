package com.alibaba.fastjson.support.spring;

import java.io.IOException;
import java.lang.reflect.Type;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class g extends b {
    @Override // com.alibaba.fastjson.support.spring.b
    public boolean b(Type type, Class<?> cls, MediaType mediaType) {
        return super.b(type, cls, mediaType);
    }

    @Override // com.alibaba.fastjson.support.spring.b
    public boolean c(Type type, Class<?> cls, MediaType mediaType) {
        return super.c(type, cls, mediaType);
    }

    @Override // com.alibaba.fastjson.support.spring.b
    public Object j(Type type, Class<?> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return super.j(type, cls, httpInputMessage);
    }

    @Override // com.alibaba.fastjson.support.spring.b
    protected Object k(Class<?> cls, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return super.k(cls, httpInputMessage);
    }

    @Override // com.alibaba.fastjson.support.spring.b
    protected boolean s(Class<?> cls) {
        return super.s(cls);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.springframework.http.converter.HttpMessageNotWritableException */
    @Override // com.alibaba.fastjson.support.spring.b
    public void t(Object obj, Type type, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        super.t(obj, type, mediaType, httpOutputMessage);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.springframework.http.converter.HttpMessageNotWritableException */
    @Override // com.alibaba.fastjson.support.spring.b
    protected void u(Object obj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        super.u(obj, httpOutputMessage);
    }
}

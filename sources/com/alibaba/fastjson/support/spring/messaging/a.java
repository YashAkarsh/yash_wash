package com.alibaba.fastjson.support.spring.messaging;

import java.nio.charset.Charset;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.AbstractMessageConverter;
import org.springframework.util.MimeType;

/* JADX INFO: loaded from: classes.dex */
public class a extends AbstractMessageConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.alibaba.fastjson.support.config.a f13255a;

    public a() {
        super(new MimeType("application", "json", Charset.forName("UTF-8")));
        this.f13255a = new com.alibaba.fastjson.support.config.a();
    }

    protected boolean a(Message<?> message, Class<?> cls) {
        return g(cls);
    }

    protected boolean b(Object obj, MessageHeaders messageHeaders) {
        return g(obj.getClass());
    }

    protected Object c(Message<?> message, Class<?> cls, Object obj) {
        Object payload = message.getPayload();
        if (payload instanceof byte[]) {
            byte[] bArr = (byte[]) payload;
            return com.alibaba.fastjson.a.b0(bArr, 0, bArr.length, this.f13255a.a(), cls, this.f13255a.d());
        }
        if (payload instanceof String) {
            return com.alibaba.fastjson.a.P((String) payload, cls, this.f13255a.d());
        }
        return null;
    }

    protected Object d(Object obj, MessageHeaders messageHeaders, Object obj2) {
        return com.alibaba.fastjson.a.C0(obj, this.f13255a.f(), this.f13255a.g(), this.f13255a.h());
    }

    public com.alibaba.fastjson.support.config.a e() {
        return this.f13255a;
    }

    public void f(com.alibaba.fastjson.support.config.a aVar) {
        this.f13255a = aVar;
    }

    protected boolean g(Class<?> cls) {
        return true;
    }
}

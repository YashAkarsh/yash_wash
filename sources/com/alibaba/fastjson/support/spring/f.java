package com.alibaba.fastjson.support.spring;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/* JADX INFO: loaded from: classes.dex */
@ControllerAdvice
@Order
public class f implements ResponseBodyAdvice<Object> {
    private a d(Object obj) {
        return obj instanceof a ? (a) obj : new a(obj);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a b(Object obj, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> cls, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        a aVarD = d(obj);
        c(aVarD, mediaType, methodParameter, serverHttpRequest, serverHttpResponse);
        return aVarD;
    }

    protected void c(a aVar, MediaType mediaType, MethodParameter methodParameter, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        f0.b bVar = (f0.b) methodParameter.getMethodAnnotation(f0.b.class);
        f0.a[] aVarArrInclude = bVar.include();
        f0.a[] aVarArrExclude = bVar.exclude();
        m mVar = new m();
        for (f0.a aVar2 : aVarArrInclude) {
            mVar.b(aVar2.clazz(), aVar2.props());
        }
        for (f0.a aVar3 : aVarArrExclude) {
            mVar.b(aVar3.clazz(), new String[0]).k(aVar3.props());
        }
        aVar.c(mVar);
    }

    public boolean e(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> cls) {
        return b.class.isAssignableFrom(cls) && methodParameter.hasMethodAnnotation(f0.b.class);
    }
}

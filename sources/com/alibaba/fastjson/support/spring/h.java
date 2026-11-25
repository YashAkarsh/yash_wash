package com.alibaba.fastjson.support.spring;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/* JADX INFO: loaded from: classes.dex */
@ControllerAdvice
@Deprecated
@Order(Integer.MIN_VALUE)
public class h implements ResponseBodyAdvice<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f13244b = Pattern.compile("[0-9A-Za-z_\\.]*");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f13245c = {"callback", "jsonp"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f13246a;

    public h() {
        this.f13246a = f13245c;
    }

    public Object a(Object obj, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> cls, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        l lVarD = d(obj);
        b(lVarD, mediaType, methodParameter, serverHttpRequest, serverHttpResponse);
        return lVarD;
    }

    public void b(l lVar, MediaType mediaType, MethodParameter methodParameter, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        HttpServletRequest servletRequest = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest();
        for (String str : this.f13246a) {
            String parameter = servletRequest.getParameter(str);
            if (parameter != null && e(parameter)) {
                lVar.d(parameter);
                return;
            }
        }
    }

    protected MediaType c(MediaType mediaType, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return new MediaType("application", "javascript");
    }

    protected l d(Object obj) {
        return obj instanceof l ? (l) obj : new l(obj);
    }

    protected boolean e(String str) {
        return f13244b.matcher(str).matches();
    }

    public boolean f(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> cls) {
        return b.class.isAssignableFrom(cls);
    }

    public h(String... strArr) {
        Assert.isTrue(!ObjectUtils.isEmpty(strArr), "At least one query param name is required");
        this.f13246a = strArr;
    }
}

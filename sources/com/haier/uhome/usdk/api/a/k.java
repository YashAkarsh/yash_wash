package com.haier.uhome.usdk.api.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30405a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f30406b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f30407c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f30408d = 4;

    int a() default 1;
}

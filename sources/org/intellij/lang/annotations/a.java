package org.intellij.lang.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface a {

    /* JADX INFO: renamed from: a7, reason: collision with root package name */
    @a7.c
    public static final String f39744a7 = "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

    /* JADX INFO: renamed from: b7, reason: collision with root package name */
    @a7.c
    public static final String f39745b7 = "this";

    /* JADX INFO: renamed from: c7, reason: collision with root package name */
    @a7.c
    public static final String f39746c7 = "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

    /* JADX INFO: renamed from: d7, reason: collision with root package name */
    @a7.c
    public static final String f39747d7 = "The return value of this method";

    /* JADX INFO: renamed from: e7, reason: collision with root package name */
    @a7.c
    public static final String f39748e7 = "this";

    String source() default "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

    boolean sourceIsContainer() default false;

    String target() default "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

    boolean targetIsContainer() default false;
}

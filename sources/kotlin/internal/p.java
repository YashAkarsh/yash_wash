package kotlin.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.g1;
import kotlin.jvm.internal.n1;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@g1(version = "1.2")
@Retention(RetentionPolicy.SOURCE)
@y4.f(allowedTargets = {y4.b.CLASS, y4.b.FUNCTION, y4.b.PROPERTY, y4.b.CONSTRUCTOR, y4.b.TYPEALIAS})
@Repeatable(a.class)
@y4.d
@y4.e(y4.a.SOURCE)
public @interface p {

    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @n1
    @y4.f(allowedTargets = {y4.b.CLASS, y4.b.FUNCTION, y4.b.PROPERTY, y4.b.CONSTRUCTOR, y4.b.TYPEALIAS})
    @Retention(RetentionPolicy.SOURCE)
    @y4.e(y4.a.SOURCE)
    public @interface a {
        p[] value();
    }

    int errorCode() default -1;

    kotlin.m level() default kotlin.m.ERROR;

    String message() default "";

    String version();

    q versionKind() default q.LANGUAGE_VERSION;
}

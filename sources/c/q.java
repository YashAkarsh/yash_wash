package c;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f11495e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f11496f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f11497g = 2;

    int unit() default 1;
}

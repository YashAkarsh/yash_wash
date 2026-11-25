package t6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import v6.c0;
import v6.t;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@t
@v6.c(qualifier = l.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface f {
    String[] expression();

    boolean result();

    @c0("value")
    int targetValue() default 0;
}

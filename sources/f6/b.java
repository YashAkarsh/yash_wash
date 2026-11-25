package f6;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import v6.t;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@t
@v6.c(qualifier = h.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface b {
    String[] expression();

    boolean result();
}

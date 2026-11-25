package c6;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@v6.t
@v6.c(qualifier = h.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface b {
    String[] expression();

    @v6.v
    @v6.c0(androidx.constraintlayout.core.motion.utils.w.c.R)
    String[] offset() default {};

    boolean result();

    @v6.v
    @v6.c0("value")
    String[] targetValue();
}

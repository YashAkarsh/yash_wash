package c6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@v6.h0({g.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface h {
    @v6.v
    String[] offset() default {};

    @v6.v
    String[] value();
}

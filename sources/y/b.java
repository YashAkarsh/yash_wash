package y;

import c.m0;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface b {

    @Target({})
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
        int mask() default 0;

        @m0
        String name();

        int value();
    }

    @m0
    a[] intMapping() default {};

    @m0
    String value();
}

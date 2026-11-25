package f6;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import v6.h0;
import v6.j0;
import v6.k0;
import v6.s;
import v6.v;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@v6.f({k0.PARAMETER})
@v6.e({k0.EXCEPTION_PARAMETER, k0.UPPER_BOUND})
@s(typeNames = {String.class}, types = {j0.BOOLEAN, j0.BYTE, j0.CHAR, j0.DOUBLE, j0.FLOAT, j0.INT, j0.LONG, j0.SHORT})
@h0({f.class})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@v6.h
public @interface d {
    @v
    String[] value() default {};
}

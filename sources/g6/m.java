package g6;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import v6.h0;
import v6.k0;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@v6.e({k0.LOCAL_VARIABLE, k0.RESOURCE_VARIABLE})
@h0({})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface m {
    Class<?> value() default Object.class;
}

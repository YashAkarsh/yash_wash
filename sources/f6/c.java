package f6;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import v6.h0;
import v6.i0;
import v6.k0;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE_USE})
@i0({k0.RECEIVER, k0.PARAMETER, k0.RETURN})
@h0({f.class})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface c {
    int value() default -1;
}

package g6;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import v6.h0;
import v6.v;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@h0({o.class})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface d {
    @v
    String[] value();
}

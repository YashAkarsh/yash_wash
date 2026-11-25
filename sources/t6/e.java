package t6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import v6.h0;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@h0({q.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface e {
    double[] value();
}

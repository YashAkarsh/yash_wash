package b6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import v6.h0;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@h0({h.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface f {
    String value();
}

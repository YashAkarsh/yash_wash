package c6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@v6.h0({m.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface k {
    @v6.v
    String[] value();
}

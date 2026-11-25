package c6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@v6.h0({h.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface i {
    @v6.v
    String[] value();
}

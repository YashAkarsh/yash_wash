package androidx.versionedparcelable;

import c.x0;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.FIELD})
@x0({x0.a.LIBRARY_GROUP_PREFIX})
@Retention(RetentionPolicy.SOURCE)
public @interface b {
    String defaultValue() default "";

    int value();
}

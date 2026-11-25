package org.junit.experimental.theories;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.PARAMETER})
@f(org.junit.experimental.theories.internal.f.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface c {
    String value();
}

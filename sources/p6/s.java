package p6;

import java.lang.annotation.Annotation;

/* JADX INFO: loaded from: classes3.dex */
public @interface s {
    m prefix() default m.one;

    Class<? extends Annotation> quantity();
}

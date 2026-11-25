package v6;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.METHOD})
@t
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface l {
    String[] expression();

    Class<? extends Annotation> qualifier();

    boolean result();
}

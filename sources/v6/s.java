package v6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface s {
    w[] literals() default {};

    String[] stringPatterns() default {};

    Class<?>[] typeNames() default {};

    j0[] types() default {};
}

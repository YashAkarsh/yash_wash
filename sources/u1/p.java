package u1;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface p {
    String allowedOnPath() default "";

    String checkerName() default "RestrictedApi";

    String explanation();

    String link();

    Class<? extends Annotation>[] whitelistAnnotations() default {};

    Class<? extends Annotation>[] whitelistWithWarningAnnotations() default {};
}

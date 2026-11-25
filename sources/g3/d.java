package g3;

import com.haier.library.json.serializer.a0;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface d {
    boolean alphabetic() default true;

    String[] ignores() default {};

    Class<?> mappingTo() default Void.class;

    String[] orders() default {};

    com.haier.library.json.parser.d[] parseFeatures() default {};

    Class<?>[] seeAlso() default {};

    a0[] serialzeFeatures() default {};

    String typeName() default "";
}

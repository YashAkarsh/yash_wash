package g3;

import com.haier.library.json.serializer.a0;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface b {
    boolean deserialize() default true;

    String format() default "";

    String name() default "";

    int ordinal() default 0;

    com.haier.library.json.parser.d[] parseFeatures() default {};

    boolean serialize() default true;

    a0[] serialzeFeatures() default {};
}

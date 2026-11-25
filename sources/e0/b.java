package e0;

import com.alibaba.fastjson.serializer.k1;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface b {
    String[] alternateNames() default {};

    boolean deserialize() default true;

    Class<?> deserializeUsing() default Void.class;

    String format() default "";

    boolean jsonDirect() default false;

    String label() default "";

    String name() default "";

    int ordinal() default 0;

    com.alibaba.fastjson.parser.c[] parseFeatures() default {};

    boolean serialize() default true;

    Class<?> serializeUsing() default Void.class;

    k1[] serialzeFeatures() default {};

    boolean unwrapped() default false;
}

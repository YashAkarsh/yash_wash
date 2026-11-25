package e0;

import com.alibaba.fastjson.m;
import com.alibaba.fastjson.serializer.k1;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface d {
    boolean alphabetic() default true;

    boolean asm() default true;

    Class<?> builder() default Void.class;

    Class<?> deserializer() default Void.class;

    String[] ignores() default {};

    String[] includes() default {};

    Class<?> mappingTo() default Void.class;

    m naming() default m.CamelCase;

    String[] orders() default {};

    com.alibaba.fastjson.parser.c[] parseFeatures() default {};

    Class<?>[] seeAlso() default {};

    boolean serializeEnumAsJavaBean() default false;

    Class<?> serializer() default Void.class;

    k1[] serialzeFeatures() default {};

    String typeKey() default "";

    String typeName() default "";
}

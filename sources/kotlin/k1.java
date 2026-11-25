package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@y4.f(allowedTargets = {y4.b.CLASS, y4.b.ANNOTATION_CLASS, y4.b.TYPE_PARAMETER, y4.b.PROPERTY, y4.b.FIELD, y4.b.LOCAL_VARIABLE, y4.b.VALUE_PARAMETER, y4.b.CONSTRUCTOR, y4.b.FUNCTION, y4.b.PROPERTY_GETTER, y4.b.PROPERTY_SETTER, y4.b.TYPE, y4.b.EXPRESSION, y4.b.FILE, y4.b.TYPEALIAS})
@Retention(RetentionPolicy.SOURCE)
@y4.e(y4.a.SOURCE)
public @interface k1 {
    String[] names();
}

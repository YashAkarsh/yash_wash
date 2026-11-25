package kotlin;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes2.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
@g1(version = "1.2")
@k(message = "Please use OptIn instead.", replaceWith = @b1(expression = "OptIn(*markerClass)", imports = {"kotlin.OptIn"}))
@l(errorSince = i2.a.f34096f, warningSince = "1.4")
@Retention(RetentionPolicy.SOURCE)
@y4.f(allowedTargets = {y4.b.CLASS, y4.b.PROPERTY, y4.b.LOCAL_VARIABLE, y4.b.VALUE_PARAMETER, y4.b.CONSTRUCTOR, y4.b.FUNCTION, y4.b.PROPERTY_GETTER, y4.b.PROPERTY_SETTER, y4.b.EXPRESSION, y4.b.FILE, y4.b.TYPEALIAS})
@y4.e(y4.a.SOURCE)
public @interface p2 {
    Class<? extends Annotation>[] markerClass();
}

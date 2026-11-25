package d;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.b1;
import kotlin.k;
import y4.e;
import y4.f;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
@k(message = "This annotation has been replaced by `@OptIn`", replaceWith = @b1(expression = "OptIn", imports = {"androidx.annotation.OptIn"}))
@f(allowedTargets = {y4.b.CLASS, y4.b.PROPERTY, y4.b.LOCAL_VARIABLE, y4.b.VALUE_PARAMETER, y4.b.CONSTRUCTOR, y4.b.FUNCTION, y4.b.PROPERTY_GETTER, y4.b.PROPERTY_SETTER, y4.b.FILE, y4.b.TYPEALIAS})
@Retention(RetentionPolicy.CLASS)
@e(y4.a.BINARY)
public @interface c {
    Class<? extends Annotation>[] markerClass();
}

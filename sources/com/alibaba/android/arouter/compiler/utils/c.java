package com.alibaba.android.arouter.compiler.utils;

import com.alibaba.android.arouter.facade.enums.TypeKind;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Types f12434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Elements f12435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TypeMirror f12436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TypeMirror f12437d;

    public c(Types types, Elements elements) {
        this.f12434a = types;
        this.f12435b = elements;
        this.f12436c = elements.getTypeElement(a.f12424r).asType();
        this.f12437d = this.f12435b.getTypeElement(a.C).asType();
    }

    public int a(Element element) {
        TypeMirror typeMirrorAsType = element.asType();
        if (typeMirrorAsType.getKind().isPrimitive()) {
            return element.asType().getKind().ordinal();
        }
        String string = typeMirrorAsType.toString();
        string.hashCode();
        switch (string) {
            case "java.lang.Integer":
                return TypeKind.INT.ordinal();
            case "java.lang.Float":
                return TypeKind.FLOAT.ordinal();
            case "java.lang.Short":
                return TypeKind.SHORT.ordinal();
            case "java.lang.Character":
                return TypeKind.CHAR.ordinal();
            case "java.lang.Boolean":
                return TypeKind.BOOLEAN.ordinal();
            case "java.lang.Byte":
                return TypeKind.BYTE.ordinal();
            case "java.lang.Long":
                return TypeKind.LONG.ordinal();
            case "java.lang.Double":
                return TypeKind.DOUBLE.ordinal();
            case "java.lang.String":
                return TypeKind.STRING.ordinal();
            default:
                if (this.f12434a.isSubtype(typeMirrorAsType, this.f12436c)) {
                    return TypeKind.PARCELABLE.ordinal();
                }
                return this.f12434a.isSubtype(typeMirrorAsType, this.f12437d) ? TypeKind.SERIALIZABLE.ordinal() : TypeKind.OBJECT.ordinal();
        }
    }
}

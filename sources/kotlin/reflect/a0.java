package kotlin.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.l0;
import kotlin.k0;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.s
final class a0 implements TypeVariable<GenericDeclaration>, y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final t f35067a;

    public a0(@a7.d t typeParameter) {
        l0.p(typeParameter, "typeParameter");
        this.f35067a = typeParameter;
    }

    @a7.d
    public final Annotation[] a() {
        return new Annotation[0];
    }

    @a7.e
    public final <T extends Annotation> T b(@a7.d Class<T> annotationClass) {
        l0.p(annotationClass, "annotationClass");
        return null;
    }

    @a7.d
    public final Annotation[] c() {
        return new Annotation[0];
    }

    @a7.d
    public final Annotation[] d() {
        return new Annotation[0];
    }

    public boolean equals(@a7.e Object obj) {
        if (obj instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) obj;
            if (l0.g(getName(), typeVariable.getName()) && l0.g(getGenericDeclaration(), typeVariable.getGenericDeclaration())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    @a7.d
    public Type[] getBounds() {
        List<s> upperBounds = this.f35067a.getUpperBounds();
        ArrayList arrayList = new ArrayList(kotlin.collections.z.Z(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(b0.c((s) it.next(), true));
        }
        Object[] array = arrayList.toArray(new Type[0]);
        l0.n(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Type[]) array;
    }

    @Override // java.lang.reflect.TypeVariable
    @a7.d
    public GenericDeclaration getGenericDeclaration() {
        throw new k0("An operation is not implemented: " + ("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.f35067a));
    }

    @Override // java.lang.reflect.TypeVariable
    @a7.d
    public String getName() {
        return this.f35067a.getName();
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.y
    @a7.d
    public String getTypeName() {
        return getName();
    }

    public int hashCode() {
        return getName().hashCode() ^ getGenericDeclaration().hashCode();
    }

    @a7.d
    public String toString() {
        return getTypeName();
    }
}

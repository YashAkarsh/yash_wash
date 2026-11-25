package com.google.auto.common;

import java.util.List;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor6;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.common.base.l<AnnotationValue> f19202a = new a();

    static class a extends com.google.common.base.l<AnnotationValue> {

        /* JADX INFO: renamed from: com.google.auto.common.b$a$a, reason: collision with other inner class name */
        class C0215a extends SimpleAnnotationValueVisitor6<Boolean, AnnotationValue> {

            /* JADX INFO: renamed from: com.google.auto.common.b$a$a$a, reason: collision with other inner class name */
            class C0216a extends SimpleAnnotationValueVisitor6<Object, Void> {
                C0216a() {
                }

                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public Object a(Object obj, Void r7) {
                    return obj;
                }
            }

            /* JADX INFO: renamed from: com.google.auto.common.b$a$a$b, reason: collision with other inner class name */
            class C0217b extends SimpleAnnotationValueVisitor6<Boolean, AnnotationMirror> {
                C0217b() {
                }

                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean b(Object obj, AnnotationMirror annotationMirror) {
                    return Boolean.FALSE;
                }

                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public Boolean d(AnnotationMirror annotationMirror, AnnotationMirror annotationMirror2) {
                    return Boolean.valueOf(com.google.auto.common.a.a().d(annotationMirror2, annotationMirror));
                }
            }

            /* JADX INFO: renamed from: com.google.auto.common.b$a$a$c */
            class c extends SimpleAnnotationValueVisitor6<Boolean, List<? extends AnnotationValue>> {
                c() {
                }

                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean b(Object obj, List<? extends AnnotationValue> list) {
                    return Boolean.FALSE;
                }

                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public Boolean d(List<? extends AnnotationValue> list, List<? extends AnnotationValue> list2) {
                    return Boolean.valueOf(b.a().i().d(list2, list));
                }
            }

            /* JADX INFO: renamed from: com.google.auto.common.b$a$a$d */
            class d extends SimpleAnnotationValueVisitor6<Boolean, TypeMirror> {
                d() {
                }

                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean b(Object obj, TypeMirror typeMirror) {
                    return Boolean.FALSE;
                }

                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public Boolean d(TypeMirror typeMirror, TypeMirror typeMirror2) {
                    return Boolean.valueOf(n.w().d(typeMirror2, typeMirror));
                }
            }

            C0215a() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean b(Object obj, AnnotationValue annotationValue) {
                return Boolean.valueOf(obj.equals(annotationValue.accept(new C0216a(), (Object) null)));
            }

            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean d(AnnotationMirror annotationMirror, AnnotationValue annotationValue) {
                return (Boolean) annotationValue.accept(new C0217b(), annotationMirror);
            }

            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Boolean f(List<? extends AnnotationValue> list, AnnotationValue annotationValue) {
                return (Boolean) annotationValue.accept(new c(), list);
            }

            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public Boolean h(TypeMirror typeMirror, AnnotationValue annotationValue) {
                return (Boolean) annotationValue.accept(new d(), typeMirror);
            }
        }

        /* JADX INFO: renamed from: com.google.auto.common.b$a$b, reason: collision with other inner class name */
        class C0218b extends SimpleAnnotationValueVisitor6<Integer, Void> {
            C0218b() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer b(Object obj, Void r7) {
                return Integer.valueOf(obj.hashCode());
            }

            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer d(AnnotationMirror annotationMirror, Void r7) {
                return Integer.valueOf(com.google.auto.common.a.a().f(annotationMirror));
            }

            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Integer f(List<? extends AnnotationValue> list, Void r7) {
                return Integer.valueOf(b.a().i().f(list));
            }

            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public Integer h(TypeMirror typeMirror, Void r7) {
                return Integer.valueOf(n.w().f(typeMirror));
            }
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.l
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean a(AnnotationValue annotationValue, AnnotationValue annotationValue2) {
            return ((Boolean) annotationValue.accept(new C0215a(), annotationValue2)).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.l
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public int b(AnnotationValue annotationValue) {
            return ((Integer) annotationValue.accept(new C0218b(), (Object) null)).intValue();
        }
    }

    private b() {
    }

    public static com.google.common.base.l<AnnotationValue> a() {
        return f19202a;
    }
}

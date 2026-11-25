package com.google.auto.service.processor;

import com.google.auto.common.m;
import com.google.auto.common.n;
import com.google.common.collect.af;
import com.google.common.collect.p6;
import com.google.common.collect.tc;
import com.google.common.collect.u8;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Stream;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedOptions;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor8;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

/* JADX INFO: loaded from: classes.dex */
@SupportedOptions({"debug", "verify"})
public class c extends AbstractProcessor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @s1.d
    static final String f19280b = "No service interfaces provided for element!";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private tc<String, String> f19281a = p6.V();

    class a extends SimpleAnnotationValueVisitor8<u8<DeclaredType>, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Stream b(AnnotationValue annotationValue) {
            return ((u8) annotationValue.accept(this, (Object) null)).stream();
        }

        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public u8<DeclaredType> d(List<? extends AnnotationValue> list, Void r7) {
            return (u8) list.stream().flatMap(new Function() { // from class: com.google.auto.service.processor.b
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return this.f19279a.b((AnnotationValue) obj);
                }
            }).collect(u8.L());
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public u8<DeclaredType> f(TypeMirror typeMirror, Void r7) {
            return u8.B(n.g(typeMirror));
        }
    }

    private boolean a(TypeElement typeElement, TypeElement typeElement2) {
        String str = (String) this.processingEnv.getOptions().get("verify");
        if (str == null || !Boolean.valueOf(str).booleanValue()) {
            return true;
        }
        return this.processingEnv.getTypeUtils().isSubtype(typeElement.asType(), typeElement2.asType());
    }

    private void b(String str, Element element, AnnotationMirror annotationMirror) {
        this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, str, element, annotationMirror);
    }

    private void c(String str) {
        this.processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "FATAL ERROR: " + str);
    }

    private void d() throws Throwable {
        Filer filer = this.processingEnv.getFiler();
        for (String str : this.f19281a.keySet()) {
            String str2 = "META-INF/services/" + str;
            k("Working on resource file: " + str2);
            try {
                TreeSet treeSetE = af.E();
                try {
                    FileObject resource = filer.getResource(StandardLocation.CLASS_OUTPUT, "", str2);
                    k("Looking for existing resource file at " + resource.toUri());
                    Set<String> setB = d.b(resource.openInputStream());
                    k("Existing service entries: " + setB);
                    treeSetE.addAll(setB);
                } catch (IOException unused) {
                    k("Resource file did not already exist.");
                }
                HashSet hashSet = new HashSet(this.f19281a.get(str));
                if (treeSetE.containsAll(hashSet)) {
                    k("No new service entries being added.");
                    return;
                }
                treeSetE.addAll(hashSet);
                k("New service file contents: " + treeSetE);
                FileObject fileObjectCreateResource = filer.createResource(StandardLocation.CLASS_OUTPUT, "", str2, new Element[0]);
                OutputStream outputStreamOpenOutputStream = fileObjectCreateResource.openOutputStream();
                d.c(treeSetE, outputStreamOpenOutputStream);
                outputStreamOpenOutputStream.close();
                k("Wrote to: " + fileObjectCreateResource.toUri());
            } catch (IOException e8) {
                c("Unable to create " + str2 + ", " + e8);
                return;
            }
        }
    }

    private String e(TypeElement typeElement) {
        return f(typeElement, typeElement.getSimpleName().toString());
    }

    private String f(TypeElement typeElement, String str) {
        PackageElement enclosingElement = typeElement.getEnclosingElement();
        if (!(enclosingElement instanceof PackageElement)) {
            TypeElement typeElement2 = (TypeElement) enclosingElement;
            return f(typeElement2, typeElement2.getSimpleName() + "$" + str);
        }
        PackageElement packageElement = enclosingElement;
        if (packageElement.isUnnamed()) {
            return str;
        }
        return packageElement.getQualifiedName() + com.alibaba.android.arouter.utils.b.f12515h + str;
    }

    private u8<DeclaredType> j(AnnotationMirror annotationMirror) {
        return (u8) com.google.auto.common.a.d(annotationMirror, "value").accept(new a(), (Object) null);
    }

    private void k(String str) {
        if (this.processingEnv.getOptions().containsKey("debug")) {
            this.processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, str);
        }
    }

    private void m(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Set<Element> elementsAnnotatedWith = roundEnvironment.getElementsAnnotatedWith(r1.a.class);
        k(set.toString());
        k(elementsAnnotatedWith.toString());
        for (Element element : elementsAnnotatedWith) {
            TypeElement typeElement = (TypeElement) element;
            AnnotationMirror annotationMirrorE = m.e(element, r1.a.class).e();
            u8<DeclaredType> u8VarJ = j(annotationMirrorE);
            if (u8VarJ.isEmpty()) {
                b(f19280b, element, annotationMirrorE);
            } else {
                Iterator<DeclaredType> it = u8VarJ.iterator();
                while (it.hasNext()) {
                    TypeElement typeElementO = n.o(it.next());
                    k("provider interface: " + typeElementO.getQualifiedName());
                    k("provider implementer: " + typeElement.getQualifiedName());
                    if (a(typeElement, typeElementO)) {
                        this.f19281a.put(e(typeElementO), e(typeElement));
                    } else {
                        b("ServiceProviders must implement their service provider interface. " + typeElement.getQualifiedName() + " does not implement " + typeElementO.getQualifiedName(), element, annotationMirrorE);
                    }
                }
            }
        }
    }

    private boolean n(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) throws Throwable {
        if (roundEnvironment.processingOver()) {
            d();
            return true;
        }
        m(set, roundEnvironment);
        return true;
    }

    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public u8<String> h() {
        return u8.B(r1.a.class.getName());
    }

    public SourceVersion i() {
        return SourceVersion.latestSupported();
    }

    public boolean l(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        try {
            return n(set, roundEnvironment);
        } catch (Exception e8) {
            StringWriter stringWriter = new StringWriter();
            e8.printStackTrace(new PrintWriter(stringWriter));
            c(stringWriter.toString());
            return true;
        }
    }
}

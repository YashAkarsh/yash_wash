package com.alibaba.android.arouter.compiler.processor;

import androidx.constraintlayout.core.motion.utils.w;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.enums.TypeKind;
import com.squareup.javapoet.d;
import com.squareup.javapoet.f;
import com.squareup.javapoet.j;
import com.squareup.javapoet.k;
import com.squareup.javapoet.m;
import com.squareup.javapoet.o;
import com.squareup.javapoet.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedOptions;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes.dex */
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes({com.alibaba.android.arouter.compiler.utils.a.U})
@r1.a(Processor.class)
@SupportedOptions({com.alibaba.android.arouter.compiler.utils.a.P})
public class a extends AbstractProcessor {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final com.squareup.javapoet.c f12379g = com.squareup.javapoet.c.x("com.alibaba.android.arouter.launcher", "ARouter", new String[0]);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final com.squareup.javapoet.c f12380h = com.squareup.javapoet.c.x("android.util", "Log", new String[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Filer f12381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.alibaba.android.arouter.compiler.utils.b f12382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Types f12383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.alibaba.android.arouter.compiler.utils.c f12384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Elements f12385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<TypeElement, List<Element>> f12386f = new HashMap();

    private String a(Element element) {
        return this.f12384d.a(element) == TypeKind.SERIALIZABLE.ordinal() ? d.a().b("($T) ", o.j(element.asType())).i().toString() : "";
    }

    private String b(String str, String str2, int i7, boolean z7) {
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        if (i7 == TypeKind.BOOLEAN.ordinal()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            if (z7) {
                str10 = "getBooleanExtra($S, " + str + ")";
            } else {
                str10 = "getBoolean($S)";
            }
            sb.append(str10);
            return sb.toString();
        }
        if (i7 == TypeKind.BYTE.ordinal()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            if (z7) {
                str9 = "getByteExtra($S, " + str + ")";
            } else {
                str9 = "getByte($S)";
            }
            sb2.append(str9);
            return sb2.toString();
        }
        if (i7 == TypeKind.SHORT.ordinal()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str2);
            if (z7) {
                str8 = "getShortExtra($S, " + str + ")";
            } else {
                str8 = "getShort($S)";
            }
            sb3.append(str8);
            return sb3.toString();
        }
        if (i7 == TypeKind.INT.ordinal()) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str2);
            if (z7) {
                str7 = "getIntExtra($S, " + str + ")";
            } else {
                str7 = "getInt($S)";
            }
            sb4.append(str7);
            return sb4.toString();
        }
        if (i7 == TypeKind.LONG.ordinal()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str2);
            if (z7) {
                str6 = "getLongExtra($S, " + str + ")";
            } else {
                str6 = "getLong($S)";
            }
            sb5.append(str6);
            return sb5.toString();
        }
        if (i7 == TypeKind.CHAR.ordinal()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str2);
            if (z7) {
                str5 = "getCharExtra($S, " + str + ")";
            } else {
                str5 = "getChar($S)";
            }
            sb6.append(str5);
            return sb6.toString();
        }
        if (i7 == TypeKind.FLOAT.ordinal()) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str2);
            if (z7) {
                str4 = "getFloatExtra($S, " + str + ")";
            } else {
                str4 = "getFloat($S)";
            }
            sb7.append(str4);
            return sb7.toString();
        }
        if (i7 == TypeKind.DOUBLE.ordinal()) {
            StringBuilder sb8 = new StringBuilder();
            sb8.append(str2);
            if (z7) {
                str3 = "getDoubleExtra($S, " + str + ")";
            } else {
                str3 = "getDouble($S)";
            }
            sb8.append(str3);
            return sb8.toString();
        }
        if (i7 == TypeKind.STRING.ordinal()) {
            StringBuilder sb9 = new StringBuilder();
            sb9.append(str2);
            sb9.append(z7 ? "getStringExtra($S)" : "getString($S)");
            return sb9.toString();
        }
        if (i7 == TypeKind.SERIALIZABLE.ordinal()) {
            StringBuilder sb10 = new StringBuilder();
            sb10.append(str2);
            sb10.append(z7 ? "getSerializableExtra($S)" : "getSerializable($S)");
            return sb10.toString();
        }
        if (i7 == TypeKind.PARCELABLE.ordinal()) {
            StringBuilder sb11 = new StringBuilder();
            sb11.append(str2);
            sb11.append(z7 ? "getParcelableExtra($S)" : "getParcelable($S)");
            return sb11.toString();
        }
        if (i7 != TypeKind.OBJECT.ordinal()) {
            return str2;
        }
        StringBuilder sb12 = new StringBuilder();
        sb12.append("serializationService.parseObject(substitute.");
        sb12.append(z7 ? "getIntent()." : "getArguments().");
        sb12.append(z7 ? "getStringExtra($S)" : "getString($S)");
        sb12.append(", new com.alibaba.android.arouter.facade.model.TypeWrapper<$T>(){}.getType())");
        return sb12.toString();
    }

    private void c(Set<? extends Element> set) throws IllegalAccessException {
        if (CollectionUtils.isNotEmpty(set)) {
            for (Element element : set) {
                TypeElement enclosingElement = element.getEnclosingElement();
                if (element.getModifiers().contains(Modifier.PRIVATE)) {
                    throw new IllegalAccessException("The inject fields CAN NOT BE 'private'!!! please check field [" + element.getSimpleName() + "] in class [" + enclosingElement.getQualifiedName() + "]");
                }
                if (this.f12386f.containsKey(enclosingElement)) {
                    this.f12386f.get(enclosingElement).add(element);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(element);
                    this.f12386f.put(enclosingElement, arrayList);
                }
            }
            this.f12382b.d("categories finished.");
        }
    }

    private void d() throws Exception {
        Iterator<Element> it;
        String str;
        String str2;
        p.b bVar;
        String str3;
        boolean z7;
        char c8;
        TypeElement typeElement = this.f12385e.getTypeElement(com.alibaba.android.arouter.compiler.utils.a.M);
        TypeElement typeElement2 = this.f12385e.getTypeElement(com.alibaba.android.arouter.compiler.utils.a.N);
        TypeMirror typeMirrorAsType = this.f12385e.getTypeElement(com.alibaba.android.arouter.compiler.utils.a.G).asType();
        TypeMirror typeMirrorAsType2 = this.f12385e.getTypeElement(com.alibaba.android.arouter.compiler.utils.a.f12420n).asType();
        TypeMirror typeMirrorAsType3 = this.f12385e.getTypeElement(com.alibaba.android.arouter.compiler.utils.a.f12421o).asType();
        TypeMirror typeMirrorAsType4 = this.f12385e.getTypeElement(com.alibaba.android.arouter.compiler.utils.a.f12422p).asType();
        int i7 = 0;
        m mVarJ = m.a(o.f33380m, w.a.M, new Modifier[0]).j();
        if (MapUtils.isNotEmpty(this.f12386f)) {
            Iterator<Map.Entry<TypeElement, List<Element>>> it2 = this.f12386f.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry<TypeElement, List<Element>> next = it2.next();
                k.b bVarQ = k.f(com.alibaba.android.arouter.compiler.utils.a.f12412f).q(Override.class);
                Modifier[] modifierArr = new Modifier[1];
                modifierArr[i7] = Modifier.PUBLIC;
                k.b bVarA = bVarQ.z(modifierArr).A(mVarJ);
                TypeElement key = next.getKey();
                List<Element> value = next.getValue();
                String string = key.getQualifiedName().toString();
                String strSubstring = string.substring(i7, string.lastIndexOf(com.alibaba.android.arouter.utils.b.f12515h));
                String str4 = key.getSimpleName() + "$$ARouter$$Autowired";
                com.alibaba.android.arouter.compiler.utils.b bVar2 = this.f12382b;
                StringBuilder sb = new StringBuilder();
                m mVar = mVarJ;
                sb.append(">>> Start process ");
                sb.append(value.size());
                sb.append(" field in ");
                sb.append(key.getSimpleName());
                sb.append(" ... <<<");
                bVar2.d(sb.toString());
                Iterator<Map.Entry<TypeElement, List<Element>>> it3 = it2;
                p.b bVarF = p.e(str4).C(com.alibaba.android.arouter.compiler.utils.a.f12410d, new Object[0]).I(com.squareup.javapoet.c.y(typeElement)).F(Modifier.PUBLIC);
                TypeElement typeElement3 = typeElement;
                bVarF.x(f.a(o.j(typeElement2.asType()), "serializationService", Modifier.PRIVATE).n());
                bVarA.E("serializationService = $T.getInstance().navigation($T.class)", f12379g, com.squareup.javapoet.c.y(typeElement2));
                bVarA.E("$T substitute = ($T)target", com.squareup.javapoet.c.y(key), com.squareup.javapoet.c.y(key));
                Iterator<Element> it4 = value.iterator();
                while (it4.hasNext()) {
                    Element next2 = it4.next();
                    Autowired autowired = (Autowired) next2.getAnnotation(Autowired.class);
                    String string2 = next2.getSimpleName().toString();
                    TypeElement typeElement4 = typeElement2;
                    TypeMirror typeMirror = typeMirrorAsType;
                    if (this.f12383c.isSubtype(next2.asType(), typeMirrorAsType)) {
                        it = it4;
                        if ("".equals(autowired.name())) {
                            bVarA.E("substitute." + string2 + " = $T.getInstance().navigation($T.class)", f12379g, o.j(next2.asType()));
                        } else {
                            bVarA.E("substitute." + string2 + " = ($T)$T.getInstance().build($S).navigation()", o.j(next2.asType()), f12379g, autowired.name());
                        }
                        if (autowired.required()) {
                            bVarA.H("if (substitute." + string2 + " == null)", new Object[0]);
                            bVarA.E("throw new RuntimeException(\"The field '" + string2 + "' is null, in class '\" + $T.class.getName() + \"!\")", com.squareup.javapoet.c.y(key));
                            bVarA.L();
                        }
                        bVar = bVarF;
                        str = str4;
                        str2 = strSubstring;
                    } else {
                        it = it4;
                        String str5 = "substitute." + string2;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("substitute.");
                        sb2.append(string2);
                        str = str4;
                        sb2.append(" = ");
                        str2 = strSubstring;
                        sb2.append(a(next2));
                        sb2.append("substitute.");
                        String string3 = sb2.toString();
                        bVar = bVarF;
                        if (this.f12383c.isSubtype(key.asType(), typeMirrorAsType2)) {
                            str3 = string3 + "getIntent().";
                            z7 = true;
                        } else {
                            if (!this.f12383c.isSubtype(key.asType(), typeMirrorAsType3) && !this.f12383c.isSubtype(key.asType(), typeMirrorAsType4)) {
                                throw new IllegalAccessException("The field [" + string2 + "] need autowired from intent, its parent must be activity or fragment!");
                            }
                            str3 = string3 + "getArguments().";
                            z7 = false;
                        }
                        String strB = b(str5, str3, this.f12384d.a(next2), z7);
                        if (strB.startsWith("serializationService.")) {
                            bVarA.H("if (null != serializationService)", new Object[0]);
                            String str6 = "substitute." + string2 + " = " + strB;
                            Object[] objArr = new Object[2];
                            objArr[0] = StringUtils.isEmpty(autowired.name()) ? string2 : autowired.name();
                            objArr[1] = o.j(next2.asType());
                            bVarA.E(str6, objArr);
                            bVarA.N("else", new Object[0]);
                            bVarA.E("$T.e(\"ARouter::\", \"You want automatic inject the field '" + string2 + "' in class '$T' , then you should implement 'SerializationService' to support object auto inject!\")", f12380h, com.squareup.javapoet.c.y(key));
                            bVarA.L();
                        } else {
                            Object[] objArr2 = new Object[1];
                            objArr2[0] = StringUtils.isEmpty(autowired.name()) ? string2 : autowired.name();
                            bVarA.E(strB, objArr2);
                        }
                        if (autowired.required() && !next2.asType().getKind().isPrimitive()) {
                            bVarA.H("if (null == substitute." + string2 + ")", new Object[0]);
                            c8 = 2;
                            bVarA.E("$T.e(\"ARouter::\", \"The field '" + string2 + "' is null, in class '\" + $T.class.getName() + \"!\")", f12380h, com.squareup.javapoet.c.y(key));
                            bVarA.L();
                        }
                        typeElement2 = typeElement4;
                        typeMirrorAsType = typeMirror;
                        it4 = it;
                        str4 = str;
                        strSubstring = str2;
                        bVarF = bVar;
                    }
                    c8 = 2;
                    typeElement2 = typeElement4;
                    typeMirrorAsType = typeMirror;
                    it4 = it;
                    str4 = str;
                    strSubstring = str2;
                    bVarF = bVar;
                }
                p.b bVar3 = bVarF;
                bVar3.D(bVarA.I());
                j.a(strSubstring, bVar3.P()).m().h(this.f12381a);
                this.f12382b.d(">>> " + key.getSimpleName() + " has been processed, " + str4 + " has been generated. <<<");
                i7 = 0;
                mVarJ = mVar;
                it2 = it3;
                typeElement = typeElement3;
                typeElement2 = typeElement2;
                typeMirrorAsType = typeMirrorAsType;
            }
            this.f12382b.d(">>> Autowired processor stop. <<<");
        }
    }

    public synchronized void e(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        this.f12381a = this.processingEnv.getFiler();
        this.f12383c = this.processingEnv.getTypeUtils();
        Elements elementUtils = this.processingEnv.getElementUtils();
        this.f12385e = elementUtils;
        this.f12384d = new com.alibaba.android.arouter.compiler.utils.c(this.f12383c, elementUtils);
        com.alibaba.android.arouter.compiler.utils.b bVar = new com.alibaba.android.arouter.compiler.utils.b(this.processingEnv.getMessager());
        this.f12382b = bVar;
        bVar.d(">>> AutowiredProcessor init. <<<");
    }

    public boolean f(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if (!CollectionUtils.isNotEmpty(set)) {
            return false;
        }
        try {
            this.f12382b.d(">>> Found autowired field, start... <<<");
            c(roundEnvironment.getElementsAnnotatedWith(Autowired.class));
            d();
            return true;
        } catch (Exception e8) {
            this.f12382b.b(e8);
            return true;
        }
    }
}

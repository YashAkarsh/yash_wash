package com.google.auto.common;

import com.google.common.base.e0;
import com.google.common.collect.td;
import java.util.Set;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;

/* JADX INFO: loaded from: classes.dex */
public enum w {
    PRIVATE,
    DEFAULT,
    PROTECTED,
    PUBLIC;


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ElementKind f19277e = (ElementKind) com.google.common.base.k.c(ElementKind.class, "MODULE").k();

    public static w a(Element element) {
        e0.E(element);
        w wVar = PUBLIC;
        while (element != null) {
            wVar = (w) td.A().x(wVar, b(element));
            element = element.getEnclosingElement();
        }
        return wVar;
    }

    public static w b(Element element) {
        e0.E(element);
        if (element.getKind().equals(ElementKind.PACKAGE) || element.getKind().equals(f19277e)) {
            return PUBLIC;
        }
        Set modifiers = element.getModifiers();
        if (modifiers.contains(Modifier.PRIVATE)) {
            return PRIVATE;
        }
        if (modifiers.contains(Modifier.PROTECTED)) {
            return PROTECTED;
        }
        return modifiers.contains(Modifier.PUBLIC) ? PUBLIC : DEFAULT;
    }
}

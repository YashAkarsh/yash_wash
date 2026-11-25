package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.test.internal.runner.listener.InstrumentationResultPrinter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class<?>[] f10817b = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final androidx.collection.a<String, Constructor<?>> f10818c = new androidx.collection.a<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10819a;

    private x(@c.m0 Context context) {
        this.f10819a = context;
    }

    private Object a(AttributeSet attributeSet, Class<?> cls, String str) {
        Object objNewInstance;
        Class<? extends U> clsAsSubclass;
        String attributeValue = attributeSet.getAttributeValue(null, InstrumentationResultPrinter.f10179m);
        if (attributeValue == null) {
            throw new InflateException(str + " tag must have a 'class' attribute");
        }
        try {
            androidx.collection.a<String, Constructor<?>> aVar = f10818c;
            synchronized (aVar) {
                Constructor<?> constructor = aVar.get(attributeValue);
                if (constructor == null && (clsAsSubclass = Class.forName(attributeValue, false, this.f10819a.getClassLoader()).asSubclass(cls)) != 0) {
                    constructor = clsAsSubclass.getConstructor(f10817b);
                    constructor.setAccessible(true);
                    aVar.put(attributeValue, constructor);
                }
                objNewInstance = constructor.newInstance(this.f10819a, attributeSet);
            }
            return objNewInstance;
        } catch (Exception e8) {
            throw new InflateException("Could not instantiate " + cls + " class " + attributeValue, e8);
        }
    }

    private Transition b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) throws XmlPullParserException, IOException {
        Transition transitionSet;
        int depth = xmlPullParser.getDepth();
        TransitionSet transitionSet2 = transition instanceof TransitionSet ? (TransitionSet) transition : null;
        loop0: while (true) {
            transitionSet = null;
            while (true) {
                int next = xmlPullParser.next();
                if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                    break loop0;
                }
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    if ("fade".equals(name)) {
                        transitionSet = new Fade(this.f10819a, attributeSet);
                    } else if ("changeBounds".equals(name)) {
                        transitionSet = new ChangeBounds(this.f10819a, attributeSet);
                    } else if ("slide".equals(name)) {
                        transitionSet = new Slide(this.f10819a, attributeSet);
                    } else if ("explode".equals(name)) {
                        transitionSet = new Explode(this.f10819a, attributeSet);
                    } else if ("changeImageTransform".equals(name)) {
                        transitionSet = new ChangeImageTransform(this.f10819a, attributeSet);
                    } else if ("changeTransform".equals(name)) {
                        transitionSet = new ChangeTransform(this.f10819a, attributeSet);
                    } else if ("changeClipBounds".equals(name)) {
                        transitionSet = new ChangeClipBounds(this.f10819a, attributeSet);
                    } else if (androidx.constraintlayout.core.motion.utils.w.h.f3148f.equals(name)) {
                        transitionSet = new AutoTransition(this.f10819a, attributeSet);
                    } else if ("changeScroll".equals(name)) {
                        transitionSet = new ChangeScroll(this.f10819a, attributeSet);
                    } else if ("transitionSet".equals(name)) {
                        transitionSet = new TransitionSet(this.f10819a, attributeSet);
                    } else if ("transition".equals(name)) {
                        transitionSet = (Transition) a(attributeSet, Transition.class, "transition");
                    } else if ("targets".equals(name)) {
                        e(xmlPullParser, attributeSet, transition);
                    } else if ("arcMotion".equals(name)) {
                        if (transition == null) {
                            throw new RuntimeException("Invalid use of arcMotion element");
                        }
                        transition.x0(new ArcMotion(this.f10819a, attributeSet));
                    } else if ("pathMotion".equals(name)) {
                        if (transition == null) {
                            throw new RuntimeException("Invalid use of pathMotion element");
                        }
                        transition.x0((PathMotion) a(attributeSet, PathMotion.class, "pathMotion"));
                    } else {
                        if (!"patternPathMotion".equals(name)) {
                            throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                        }
                        if (transition == null) {
                            throw new RuntimeException("Invalid use of patternPathMotion element");
                        }
                        transition.x0(new PatternPathMotion(this.f10819a, attributeSet));
                    }
                    if (transitionSet == null) {
                        continue;
                    } else {
                        if (!xmlPullParser.isEmptyElementTag()) {
                            b(xmlPullParser, attributeSet, transitionSet);
                        }
                        if (transitionSet2 != null) {
                            break;
                        }
                        if (transition != null) {
                            throw new InflateException("Could not add transition to another transition.");
                        }
                    }
                }
            }
            transitionSet2.I0(transitionSet);
        }
        return transitionSet;
    }

    private z c(XmlPullParser xmlPullParser, AttributeSet attributeSet, ViewGroup viewGroup) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        z zVar = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("transitionManager")) {
                    zVar = new z();
                } else {
                    if (!name.equals("transition") || zVar == null) {
                        throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                    }
                    h(attributeSet, xmlPullParser, viewGroup, zVar);
                }
            }
        }
        return zVar;
    }

    public static x d(Context context) {
        return new x(context);
    }

    @SuppressLint({"RestrictedApi"})
    private void e(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                if (!xmlPullParser.getName().equals(androidx.constraintlayout.core.motion.utils.w.a.M)) {
                    throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                }
                TypedArray typedArrayObtainStyledAttributes = this.f10819a.obtainStyledAttributes(attributeSet, w.f10782a);
                int iL = androidx.core.content.res.q.l(typedArrayObtainStyledAttributes, xmlPullParser, "targetId", 1, 0);
                if (iL != 0) {
                    transition.b(iL);
                } else {
                    int iL2 = androidx.core.content.res.q.l(typedArrayObtainStyledAttributes, xmlPullParser, "excludeId", 2, 0);
                    if (iL2 != 0) {
                        transition.z(iL2, true);
                    } else {
                        String strM = androidx.core.content.res.q.m(typedArrayObtainStyledAttributes, xmlPullParser, "targetName", 4);
                        if (strM != null) {
                            transition.e(strM);
                        } else {
                            String strM2 = androidx.core.content.res.q.m(typedArrayObtainStyledAttributes, xmlPullParser, "excludeName", 5);
                            if (strM2 != null) {
                                transition.C(strM2, true);
                            } else {
                                String strM3 = androidx.core.content.res.q.m(typedArrayObtainStyledAttributes, xmlPullParser, "excludeClass", 3);
                                if (strM3 != null) {
                                    try {
                                        transition.B(Class.forName(strM3), true);
                                    } catch (ClassNotFoundException e8) {
                                        typedArrayObtainStyledAttributes.recycle();
                                        throw new RuntimeException("Could not create " + strM3, e8);
                                    }
                                } else {
                                    String strM4 = androidx.core.content.res.q.m(typedArrayObtainStyledAttributes, xmlPullParser, "targetClass", 0);
                                    if (strM4 != null) {
                                        transition.d(Class.forName(strM4));
                                    }
                                }
                            }
                        }
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    @SuppressLint({"RestrictedApi"})
    private void h(AttributeSet attributeSet, XmlPullParser xmlPullParser, ViewGroup viewGroup, z zVar) throws Resources.NotFoundException {
        Transition transitionF;
        TypedArray typedArrayObtainStyledAttributes = this.f10819a.obtainStyledAttributes(attributeSet, w.f10783b);
        int iL = androidx.core.content.res.q.l(typedArrayObtainStyledAttributes, xmlPullParser, "transition", 2, -1);
        int iL2 = androidx.core.content.res.q.l(typedArrayObtainStyledAttributes, xmlPullParser, "fromScene", 0, -1);
        u uVarD = iL2 < 0 ? null : u.d(viewGroup, iL2, this.f10819a);
        int iL3 = androidx.core.content.res.q.l(typedArrayObtainStyledAttributes, xmlPullParser, "toScene", 1, -1);
        u uVarD2 = iL3 >= 0 ? u.d(viewGroup, iL3, this.f10819a) : null;
        if (iL >= 0 && (transitionF = f(iL)) != null) {
            if (uVarD2 == null) {
                throw new RuntimeException("No toScene for transition ID " + iL);
            }
            if (uVarD == null) {
                zVar.l(uVarD2, transitionF);
            } else {
                zVar.k(uVarD, uVarD2, transitionF);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public Transition f(int i7) {
        XmlResourceParser xml = this.f10819a.getResources().getXml(i7);
        try {
            try {
                Transition transitionB = b(xml, Xml.asAttributeSet(xml), null);
                xml.close();
                return transitionB;
            } catch (IOException e8) {
                throw new InflateException(xml.getPositionDescription() + ": " + e8.getMessage(), e8);
            } catch (XmlPullParserException e9) {
                throw new InflateException(e9.getMessage(), e9);
            }
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    public z g(int i7, ViewGroup viewGroup) {
        XmlResourceParser xml = this.f10819a.getResources().getXml(i7);
        try {
            try {
                z zVarC = c(xml, Xml.asAttributeSet(xml), viewGroup);
                xml.close();
                return zVarC;
            } catch (IOException e8) {
                InflateException inflateException = new InflateException(xml.getPositionDescription() + ": " + e8.getMessage());
                inflateException.initCause(e8);
                throw inflateException;
            } catch (XmlPullParserException e9) {
                InflateException inflateException2 = new InflateException(e9.getMessage());
                inflateException2.initCause(e9);
                throw inflateException2;
            }
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }
}

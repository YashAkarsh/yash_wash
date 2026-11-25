package com.facebook.appevents.codeless.internal;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.core.view.t1;
import c.o0;
import c.x0;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ViewHierarchy {
    private static final String CLASS_RCTROOTVIEW = "com.facebook.react.ReactRootView";
    private static final String CLASS_RCTTEXTVIEW = "com.facebook.react.views.view.ReactTextView";
    private static final String CLASS_RCTVIEWGROUP = "com.facebook.react.views.view.ReactViewGroup";
    private static final String CLASS_TOUCHTARGETHELPER = "com.facebook.react.uimanager.TouchTargetHelper";
    private static final int ICON_MAX_EDGE_LENGTH = 44;
    private static final String METHOD_FIND_TOUCHTARGET_VIEW = "findTouchTargetView";
    private static final String TAG = "com.facebook.appevents.codeless.internal.ViewHierarchy";
    private static WeakReference<View> RCTRootViewReference = new WeakReference<>(null);

    @o0
    private static Method methodFindTouchTargetView = null;

    @o0
    @x0({x0.a.GROUP_ID})
    public static View findRCTRootView(View view) {
        while (view != null) {
            if (isRCTRootView(view)) {
                return view;
            }
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
        return null;
    }

    @x0({x0.a.GROUP_ID})
    public static List<View> getChildrenOfView(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                arrayList.add(viewGroup.getChildAt(i7));
            }
        }
        return arrayList;
    }

    @x0({x0.a.GROUP_ID})
    public static int getClassTypeBitmask(View view) {
        int i7 = view instanceof ImageView ? 2 : 0;
        if (view.isClickable()) {
            i7 |= 32;
        }
        if (isAdapterViewItem(view)) {
            i7 |= 512;
        }
        if (view instanceof TextView) {
            int i8 = i7 | 1024 | 1;
            if (view instanceof Button) {
                i8 |= 4;
                if (view instanceof Switch) {
                    i8 |= 8192;
                } else if (view instanceof CheckBox) {
                    i8 |= 32768;
                }
            }
            return view instanceof EditText ? i8 | 2048 : i8;
        }
        if ((view instanceof Spinner) || (view instanceof DatePicker)) {
            return i7 | 4096;
        }
        if (view instanceof RatingBar) {
            return i7 | 65536;
        }
        if (view instanceof RadioGroup) {
            return i7 | 16384;
        }
        return ((view instanceof ViewGroup) && isRCTButton(view, RCTRootViewReference.get())) ? i7 | 64 : i7;
    }

    @x0({x0.a.GROUP_ID})
    public static JSONObject getDictionaryOfView(View view) {
        if (view.getClass().getName().equals(CLASS_RCTROOTVIEW)) {
            RCTRootViewReference = new WeakReference<>(view);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            updateBasicInfoOfView(view, jSONObject);
            JSONArray jSONArray = new JSONArray();
            List<View> childrenOfView = getChildrenOfView(view);
            for (int i7 = 0; i7 < childrenOfView.size(); i7++) {
                jSONArray.put(getDictionaryOfView(childrenOfView.get(i7)));
            }
            jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, jSONArray);
        } catch (JSONException e8) {
            Log.e(TAG, "Failed to create JSONObject for view.", e8);
        }
        return jSONObject;
    }

    private static JSONObject getDimensionOfView(View view) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, view.getTop());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, view.getLeft());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, view.getWidth());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, view.getHeight());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_X_KEY, view.getScrollX());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_Y_KEY, view.getScrollY());
            jSONObject.put("visibility", view.getVisibility());
        } catch (JSONException e8) {
            Log.e(TAG, "Failed to create JSONObject for dimension.", e8);
        }
        return jSONObject;
    }

    @o0
    @x0({x0.a.GROUP_ID})
    public static View.OnClickListener getExistingOnClickListener(View view) {
        Field declaredField;
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return (View.OnClickListener) declaredField.get(obj);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        }
    }

    @o0
    @x0({x0.a.GROUP_ID})
    public static View.OnTouchListener getExistingOnTouchListener(View view) {
        Field declaredField;
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return (View.OnTouchListener) declaredField.get(obj);
        } catch (ClassNotFoundException e8) {
            Utility.logd(TAG, e8);
            return null;
        } catch (IllegalAccessException e9) {
            Utility.logd(TAG, e9);
            return null;
        } catch (NoSuchFieldException e10) {
            Utility.logd(TAG, e10);
            return null;
        }
    }

    @x0({x0.a.GROUP_ID})
    public static String getHintOfView(View view) {
        CharSequence hint;
        if (view instanceof EditText) {
            hint = ((EditText) view).getHint();
        } else {
            hint = view instanceof TextView ? ((TextView) view).getHint() : null;
        }
        return hint == null ? "" : hint.toString();
    }

    @o0
    @x0({x0.a.GROUP_ID})
    public static ViewGroup getParentOfView(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            return (ViewGroup) parent;
        }
        return null;
    }

    @x0({x0.a.GROUP_ID})
    public static String getTextOfView(View view) {
        CharSequence charSequenceValueOf;
        CharSequence text;
        Object selectedItem;
        if (view instanceof TextView) {
            charSequenceValueOf = ((TextView) view).getText();
            if (view instanceof Switch) {
                text = ((Switch) view).isChecked() ? "1" : "0";
                charSequenceValueOf = text;
            }
        } else if (view instanceof Spinner) {
            Spinner spinner = (Spinner) view;
            if (spinner.getCount() <= 0 || (selectedItem = spinner.getSelectedItem()) == null) {
                charSequenceValueOf = null;
            } else {
                text = selectedItem.toString();
                charSequenceValueOf = text;
            }
        } else {
            int i7 = 0;
            if (view instanceof DatePicker) {
                DatePicker datePicker = (DatePicker) view;
                charSequenceValueOf = String.format("%04d-%02d-%02d", Integer.valueOf(datePicker.getYear()), Integer.valueOf(datePicker.getMonth()), Integer.valueOf(datePicker.getDayOfMonth()));
            } else if (view instanceof TimePicker) {
                TimePicker timePicker = (TimePicker) view;
                charSequenceValueOf = String.format("%02d:%02d", Integer.valueOf(timePicker.getCurrentHour().intValue()), Integer.valueOf(timePicker.getCurrentMinute().intValue()));
            } else {
                if (view instanceof RadioGroup) {
                    RadioGroup radioGroup = (RadioGroup) view;
                    int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                    int childCount = radioGroup.getChildCount();
                    while (true) {
                        if (i7 < childCount) {
                            View childAt = radioGroup.getChildAt(i7);
                            if (childAt.getId() == checkedRadioButtonId && (childAt instanceof RadioButton)) {
                                text = ((RadioButton) childAt).getText();
                                charSequenceValueOf = text;
                            } else {
                                i7++;
                            }
                        }
                    }
                } else if (view instanceof RatingBar) {
                    charSequenceValueOf = String.valueOf(((RatingBar) view).getRating());
                }
                charSequenceValueOf = null;
            }
        }
        return charSequenceValueOf == null ? "" : charSequenceValueOf.toString();
    }

    @o0
    @x0({x0.a.GROUP_ID})
    public static View getTouchReactView(float[] fArr, @o0 View view) {
        View view2;
        initTouchTargetHelperMethods();
        Method method = methodFindTouchTargetView;
        if (method != null && view != null) {
            try {
                View view3 = (View) method.invoke(null, fArr, view);
                if (view3 == null || view3.getId() <= 0 || (view2 = (View) view3.getParent()) == null) {
                    return null;
                }
                return view2;
            } catch (IllegalAccessException e8) {
                Utility.logd(TAG, e8);
            } catch (InvocationTargetException e9) {
                Utility.logd(TAG, e9);
            }
        }
        return null;
    }

    private static float[] getViewLocationOnScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new float[]{iArr[0], iArr[1]};
    }

    private static void initTouchTargetHelperMethods() {
        if (methodFindTouchTargetView != null) {
            return;
        }
        try {
            Method declaredMethod = Class.forName(CLASS_TOUCHTARGETHELPER).getDeclaredMethod(METHOD_FIND_TOUCHTARGET_VIEW, float[].class, ViewGroup.class);
            methodFindTouchTargetView = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (ClassNotFoundException e8) {
            Utility.logd(TAG, e8);
        } catch (NoSuchMethodException e9) {
            Utility.logd(TAG, e9);
        }
    }

    private static boolean isAdapterViewItem(View view) {
        ViewParent parent = view.getParent();
        return (parent instanceof AdapterView) || (parent instanceof t1);
    }

    @x0({x0.a.GROUP_ID})
    public static boolean isRCTButton(View view, @o0 View view2) {
        View touchReactView;
        return view.getClass().getName().equals(CLASS_RCTVIEWGROUP) && (touchReactView = getTouchReactView(getViewLocationOnScreen(view), view2)) != null && touchReactView.getId() == view.getId();
    }

    @x0({x0.a.GROUP_ID})
    public static boolean isRCTRootView(View view) {
        return view.getClass().getName().equals(CLASS_RCTROOTVIEW);
    }

    @x0({x0.a.GROUP_ID})
    public static boolean isRCTTextView(View view) {
        return view.getClass().getName().equals(CLASS_RCTTEXTVIEW);
    }

    @x0({x0.a.GROUP_ID})
    public static boolean isRCTViewGroup(View view) {
        return view.getClass().getName().equals(CLASS_RCTVIEWGROUP);
    }

    public static void setOnClickListener(View view, View.OnClickListener onClickListener) {
        Field declaredField;
        Field declaredField2;
        Object obj = null;
        try {
            try {
                declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
                try {
                    declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
                } catch (ClassNotFoundException | NoSuchFieldException unused) {
                    declaredField2 = null;
                }
            } catch (Exception unused2) {
                return;
            }
        } catch (ClassNotFoundException | NoSuchFieldException unused3) {
            declaredField = null;
        }
        if (declaredField == null || declaredField2 == null) {
            view.setOnClickListener(onClickListener);
            return;
        }
        declaredField.setAccessible(true);
        declaredField2.setAccessible(true);
        try {
            declaredField.setAccessible(true);
            obj = declaredField.get(view);
        } catch (IllegalAccessException unused4) {
        }
        if (obj == null) {
            view.setOnClickListener(onClickListener);
        } else {
            declaredField2.set(obj, onClickListener);
        }
    }

    @x0({x0.a.GROUP_ID})
    public static void updateAppearanceOfView(View view, JSONObject jSONObject, float f8) {
        Bitmap bitmap;
        TextView textView;
        Typeface typeface;
        try {
            JSONObject jSONObject2 = new JSONObject();
            if ((view instanceof TextView) && (typeface = (textView = (TextView) view).getTypeface()) != null) {
                jSONObject2.put(ViewHierarchyConstants.TEXT_SIZE, textView.getTextSize());
                jSONObject2.put(ViewHierarchyConstants.TEXT_IS_BOLD, typeface.isBold());
                jSONObject2.put(ViewHierarchyConstants.TEXT_IS_ITALIC, typeface.isItalic());
                jSONObject.put(ViewHierarchyConstants.TEXT_STYLE, jSONObject2);
            }
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if (!(drawable instanceof BitmapDrawable) || view.getHeight() / f8 > 44.0f || view.getWidth() / f8 > 44.0f || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null) {
                    return;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                jSONObject.put(ViewHierarchyConstants.ICON_BITMAP, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
            }
        } catch (JSONException e8) {
            Utility.logd(TAG, e8);
        }
    }

    @x0({x0.a.GROUP_ID})
    public static void updateBasicInfoOfView(View view, JSONObject jSONObject) {
        try {
            String textOfView = getTextOfView(view);
            String hintOfView = getHintOfView(view);
            Object tag = view.getTag();
            CharSequence contentDescription = view.getContentDescription();
            jSONObject.put(ViewHierarchyConstants.CLASS_NAME_KEY, view.getClass().getCanonicalName());
            jSONObject.put(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY, getClassTypeBitmask(view));
            jSONObject.put("id", view.getId());
            if (SensitiveUserDataUtils.isSensitiveUserData(view)) {
                jSONObject.put(ViewHierarchyConstants.TEXT_KEY, "");
                jSONObject.put(ViewHierarchyConstants.IS_USER_INPUT_KEY, true);
            } else {
                jSONObject.put(ViewHierarchyConstants.TEXT_KEY, Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(textOfView), ""));
            }
            jSONObject.put(ViewHierarchyConstants.HINT_KEY, Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(hintOfView), ""));
            if (tag != null) {
                jSONObject.put(ViewHierarchyConstants.TAG_KEY, Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(tag.toString()), ""));
            }
            if (contentDescription != null) {
                jSONObject.put("description", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(contentDescription.toString()), ""));
            }
            jSONObject.put("dimension", getDimensionOfView(view));
        } catch (JSONException e8) {
            Utility.logd(TAG, e8);
        }
    }
}

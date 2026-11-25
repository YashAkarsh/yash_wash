package com.facebook.appevents.codeless.internal;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class SensitiveUserDataUtils {
    private static boolean isCreditCard(TextView textView) {
        String strReplaceAll = ViewHierarchy.getTextOfView(textView).replaceAll("\\s", "");
        int length = strReplaceAll.length();
        if (length < 12 || length > 19) {
            return false;
        }
        int i7 = 0;
        boolean z7 = false;
        for (int i8 = length - 1; i8 >= 0; i8--) {
            char cCharAt = strReplaceAll.charAt(i8);
            if (cCharAt < '0' || cCharAt > '9') {
                return false;
            }
            int i9 = cCharAt - '0';
            if (z7 && (i9 = i9 * 2) > 9) {
                i9 = (i9 % 10) + 1;
            }
            i7 += i9;
            z7 = !z7;
        }
        return i7 % 10 == 0;
    }

    private static boolean isEmail(TextView textView) {
        if (textView.getInputType() == 32) {
            return true;
        }
        String textOfView = ViewHierarchy.getTextOfView(textView);
        if (textOfView == null || textOfView.length() == 0) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(textOfView).matches();
    }

    private static boolean isPassword(TextView textView) {
        if (textView.getInputType() == 128) {
            return true;
        }
        return textView.getTransformationMethod() instanceof PasswordTransformationMethod;
    }

    private static boolean isPersonName(TextView textView) {
        return textView.getInputType() == 96;
    }

    private static boolean isPhoneNumber(TextView textView) {
        return textView.getInputType() == 3;
    }

    private static boolean isPostalAddress(TextView textView) {
        return textView.getInputType() == 112;
    }

    public static boolean isSensitiveUserData(View view) {
        if (!(view instanceof TextView)) {
            return false;
        }
        TextView textView = (TextView) view;
        return isPassword(textView) || isCreditCard(textView) || isPersonName(textView) || isPostalAddress(textView) || isPhoneNumber(textView) || isEmail(textView);
    }
}

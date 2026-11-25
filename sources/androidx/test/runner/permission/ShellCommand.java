package androidx.test.runner.permission;

import c.g1;

/* JADX INFO: loaded from: classes.dex */
@g1
public abstract class ShellCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10508a = "@%-_+:,./";

    static String b(String word) {
        int length = word.length();
        if (length == 0) {
            return "''";
        }
        for (int i7 = 0; i7 < length; i7++) {
            char cCharAt = word.charAt(i7);
            if (!Character.isLetterOrDigit(cCharAt) && f10508a.indexOf(cCharAt) == -1) {
                String strReplace = word.replace("'", "'\\''");
                StringBuilder sb = new StringBuilder(String.valueOf(strReplace).length() + 2);
                sb.append("'");
                sb.append(strReplace);
                sb.append("'");
                return sb.toString();
            }
        }
        return word;
    }

    abstract void a() throws Exception;
}

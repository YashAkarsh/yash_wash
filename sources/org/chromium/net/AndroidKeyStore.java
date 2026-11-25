package org.chromium.net;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("net::android")
public class AndroidKeyStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38988a = "AndroidKeyStore";

    @CalledByNative
    private static byte[] encryptWithPrivateKey(PrivateKey privateKey, String str, byte[] bArr) {
        try {
            Cipher cipher = Cipher.getInstance(str);
            try {
                cipher.init(1, privateKey);
                return cipher.doFinal(bArr);
            } catch (Exception e8) {
                org.chromium.base.t.j(f38988a, "Exception while encrypting input with " + str + " and " + privateKey.getAlgorithm() + " private key (" + privateKey.getClass().getName() + "): " + e8, new Object[0]);
                return null;
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e9) {
            org.chromium.base.t.j(f38988a, "Cipher " + str + " not supported: " + e9, new Object[0]);
            return null;
        }
    }

    @CalledByNative
    private static String getPrivateKeyClassName(PrivateKey privateKey) {
        return privateKey.getClass().getName();
    }

    @CalledByNative
    private static boolean privateKeySupportsCipher(PrivateKey privateKey, String str) {
        try {
            Cipher.getInstance(str).init(1, privateKey);
            return true;
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        } catch (Exception e8) {
            org.chromium.base.t.j(f38988a, "Exception while checking support for " + str + ": " + e8, new Object[0]);
            return false;
        }
    }

    @CalledByNative
    private static boolean privateKeySupportsSignature(PrivateKey privateKey, String str) {
        try {
            Signature.getInstance(str).initSign(privateKey);
            return true;
        } catch (InvalidKeyException | NoSuchAlgorithmException unused) {
            return false;
        } catch (Exception e8) {
            org.chromium.base.t.j(f38988a, "Exception while checking support for " + str + ": " + e8, new Object[0]);
            return false;
        }
    }

    @CalledByNative
    private static byte[] signWithPrivateKey(PrivateKey privateKey, String str, byte[] bArr) {
        try {
            Signature signature = Signature.getInstance(str);
            try {
                signature.initSign(privateKey);
                signature.update(bArr);
                return signature.sign();
            } catch (Exception e8) {
                org.chromium.base.t.j(f38988a, "Exception while signing message with " + str + " and " + privateKey.getAlgorithm() + " private key (" + privateKey.getClass().getName() + "): " + e8, new Object[0]);
                return null;
            }
        } catch (NoSuchAlgorithmException e9) {
            org.chromium.base.t.j(f38988a, "Signature algorithm " + str + " not supported: " + e9, new Object[0]);
            return null;
        }
    }
}

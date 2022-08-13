package com.samuliak.test.utils;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;


public class AesCryptUtils {

    private final IvParameterSpec ivspec = new IvParameterSpec(new byte[]{0, 0, 5, 0, 9, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0});

    private Cipher eCipher;
    private Cipher dCipher;

    public AesCryptUtils(String secretKey, String salt) throws Exception {
        eCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        eCipher.init(Cipher.ENCRYPT_MODE, initSecretKey(secretKey, salt), ivspec);

        dCipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        dCipher.init(Cipher.DECRYPT_MODE, initSecretKey(secretKey, salt), ivspec);
    }

    public String encrypt(String strToEncrypt) {
        try {
            return Base64.getEncoder()
                    .encodeToString(eCipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e);
        }
        return null;
    }

    public String decrypt(String strToDecrypt) {
        try {

            return new String(dCipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e);
        }
        return null;
    }

    private SecretKeySpec initSecretKey(String secretKey, String salt) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);

        return new SecretKeySpec(tmp.getEncoded(), "AES");
    }

}

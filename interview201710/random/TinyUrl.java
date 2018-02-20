// TinyURL is a URL shortening service where you enter a URL such as
// https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

// Design the encode and decode methods for the TinyURL service.
// There is no restriction on how your encode/decode algorithm should work.
// You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

import java.security.SecureRandom;
import java.math.BigInteger;
import java.util.*;

public class TinyUrl {

    public static HashMap<String, String> map = new HashMap<String, String>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String encode = "";
        do {
            encode = generateRandomHexToken(10);
        } while(map.containsKey(encode));
        map.put(encode, longUrl);

        return "http://tinyurl.com/" + encode;
    }

    public static String generateRandomHexToken(int byteLength) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[byteLength];
        secureRandom.nextBytes(token);
        return new BigInteger(1, token).toString(16); //hex encoding
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}

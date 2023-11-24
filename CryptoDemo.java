abstract class Cryptography {
    public abstract String encode(String plainText);
    public abstract String decode(String cipherText);
}

class CeaserCipher extends Cryptography {
    private int key;

    CeaserCipher(int key){
        this.key = key;
    }

    @Override    
    public String encode(String plainText){
        String cipherText = "";
        for(int i = 0; i < plainText.length(); i++){
            char c = plainText.charAt(i);
            if(!Character.isLetter(c)){
                cipherText += c;
                continue;
            }
            if(Character.isUpperCase(c)){
                c += key;
                if(c > 'Z'){
                    c -= 26;
                }
            } else {
                c += key;
                if(c > 'z'){
                    c -= 26;
                }
            }
            cipherText += c;
        }
        return cipherText;
    }

    @Override
    public String decode(String cipherText){
        String plainText = "";
        for(int i = 0; i < cipherText.length(); i++){
            char c = cipherText.charAt(i);
            if(!Character.isLetter(c)){
                plainText += c;
                continue;
            }
            if(Character.isUpperCase(c)){
                c -= key;
                if(c < 'A'){
                    c += 26;
                }
            } else {
                c -= key;
                if(c < 'a'){
                    c += 26;
                }
            }
            plainText += c;
        }
        return plainText;
    }
}

class TranspositionCipher extends Cryptography {
    private int key;

    TranspositionCipher(int key){
        this.key = key;
    }

    @Override
    public String encode(String plainText){
        String cipherText = "";
        String keyString = Integer.toString(key);
        if(plainText.length() % keyString.length() != 0){
            int padding = keyString.length() - plainText.length() % keyString.length();
            for(int i = 0; i < padding; i++){
                plainText += " ";
            }
        }
        for(int i = 0;i < plainText.length() / keyString.length();i++) {
            for(int j =0;j<keyString.length();j++) {
                char ch = (String.valueOf(key)).charAt(j);
                int index = Integer.parseInt(String.valueOf(ch)) - 1;
                char c = plainText.charAt(i * keyString.length() + index);
                cipherText += c;
            }
        }
        return cipherText;
    }

    @Override
    public String decode(String cipherText){
        String plainText = "";
        String keyString = Integer.toString(key);
        char[] keyArray = keyString.toCharArray();
        char[] decodeKeyArray = new char[keyArray.length];
        for(int i = 0; i < keyArray.length; i++) {
            decodeKeyArray[i] = (char)(i + '1');
        }
        for(int i = 0; i < keyArray.length - 1; i++) {
            for(int j = 0; j < keyArray.length - i - 1; j++) {
                if(keyArray[j] > keyArray[j + 1]) {
                    char temp = keyArray[j];
                    keyArray[j] = keyArray[j + 1];
                    keyArray[j + 1] = temp;
                    temp = decodeKeyArray[j];
                    decodeKeyArray[j] = decodeKeyArray[j + 1];
                    decodeKeyArray[j + 1] = temp;
                }
            }
        }
        String decodeKeyString = new String(decodeKeyArray);
        if(cipherText.length() % decodeKeyString.length() != 0){
            int padding = decodeKeyString.length() - cipherText.length() % decodeKeyString.length();
            for(int i = 0; i < padding; i++){
                cipherText += " ";
            }
        }
        for(int i = 0;i < cipherText.length() / decodeKeyString.length();i++) {
            for(int j =0;j<decodeKeyString.length();j++) {
                char ch = (String.valueOf(decodeKeyString)).charAt(j);
                int index = Integer.parseInt(String.valueOf(ch)) - 1;
                char c = cipherText.charAt(i * decodeKeyString.length() + index);
                plainText += c;
            }
        }
        return plainText;
    }
}

public class CryptoDemo {
    public static void main(String[] args) {
        Cryptography ceaserCipher = new CeaserCipher(3);
        Cryptography transpositionCipher = new TranspositionCipher(312);

        String plainText = "Hello World";
        String cipherText = ceaserCipher.encode(plainText);
        System.out.println(cipherText);
        System.out.println(ceaserCipher.decode(cipherText));

        cipherText = transpositionCipher.encode(plainText);
        System.out.println(cipherText);
        System.out.println(transpositionCipher.decode(cipherText));
    }
}
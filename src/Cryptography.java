interface Cryptography {
    String encrypt(String srcData, int key);
    String encrypt(String srcData, String key);
    String decrypt(String resData, int key);
}

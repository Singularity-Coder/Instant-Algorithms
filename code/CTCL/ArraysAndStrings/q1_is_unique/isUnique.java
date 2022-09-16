package stringsArrays;

// Ask if ASCII or unicode string is the input
// https://www.techtarget.com/whatis/definition/ASCII-American-Standard-Code-for-Information-Interchange#:~:text=ASCII%20(American%20Standard%20Code%20for%20Information%20Interchange)%20is%20the%20most,additional%20characters%20and%20control%20codes.
// https://www.log2base2.com/storage/how-characters-are-stored-in-memory.html
// ASCII - american standard code for info interchange
// ASCII in 8 bit encoding takes 8 bits or 1 byte. It can also fit in 7 bits
// Standard ASCII ENCODED data - has 128 alphabetic, numeric, special chars and control codes
// ASCII encoding is beased on char encoding used for telegraphs
// Standard ASCII has upper, lowercase letter A to Z, numerals 0 to 9, punctuation symbols obsolete control chars,
// [ , !, ", #, $, %, &, ', (, ), *, +, ,, -, ., /, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, :, ;, <, =, >, ?, @, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, [, \, ], ^, _, `, a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, {, |, }, ~]
// ASCII chars can be represented in Decimal, Hexadecimal, octal. Famouse is Decimal as each char has a number to it. like A is 65
// To store a char value, computer will allocate 1 byte(8 bit) memory
// upper case A ascii value is 65 which will be converted to binary form 100001. Because computr only knows binary system. Then 100001 will be stored in 8 bit memeroy
// Each memory location in the storage accepts either a 1 or 0. So 100001 will be stored in 6 memory locations.

// https://www.tutorialspoint.com/What-is-Java-Unicode-System#:~:text=Unicode%20is%20a%2016%2Dbit,known%20languages%20of%20the%20world.&text=ASCII%20%2D%20for%20the%20United%20States,1%20for%20Western%20European%20Language.
// Unicode is a 16 bit character encoding - can represent all well known lang chars
// Diff char encoding standards - ASCII for US, ISO 8859-1 for western Europe, KOI-8 for Russian, GBI8030 and BIG5 for chinese
// Every character occupies some memory in computer
// Each char is represented by 2 bytes to avoid collision with other lang and similar chars
// Unicode chars can be 4 or 5 bytes as well.
// Integers are whole numbers which will be stored in computer using 4 bytes or 32 bits. 1 byte is 8 bits. So 8 * 4 = 32. So a number can be represented in 32 bits of binary format
// https://www.log2base2.com/storage/how-integers-are-stored-in-memory.html
// 65 in binary is 1000001. For + nums most significant bit will be 0 while - nums MSB wil be 1
// The way it stored in memory is from left to right. So there are 32 slots. and the last 7 slots are taken up by 1000001. The rest will be 0.
// So it will look like 00000000000000000000000001000001
// Data is stored in the form of electric signals
// Bit is the basic unit of memory. At a time it can either be on or off. Bits are generally reperesented using electric voltage
// Voltage presence represents bit is on ON state and its abscence is OFF state
// OFF state is considered 0 and ON state is 1
// Computer memory is the colecton of several bits. Group of 8 bits are called a byte

// TODO
// Convert char to binary string and vice-versa
// Convert char to byte string and vice-versa
// Convert binary string to char or string - "01001000 01100101 01101100 01101100 01101111" is Hello

public class UniqueChars {

    public boolean isUniqueCharsType1(String str) {
        System.out.println("Char at 1: " + "appo".charAt(1));
//        if (str.length() > 256) return false; // Because extended ASCII chars do not exceed 256
        if (str.length() > 128) return false; // Because standard ASCII chars do not exceed 128
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int charValue = str.charAt(i); // Note that this is an int implicit cast. So this acts as index
            System.out.println("value in char arr: " + char_set[charValue]);
            if (char_set[charValue]) return false;
            char_set[charValue] = true;
        }
        return true;
    }

    // TODO didnt understand
    /* Assumes only letters a through z. */
    public static boolean isUniqueCharsType2(String str) {
        if (str.length() > 26) { // Only 26 characters
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

    // input: "Hell o"
    public void convertStringToBinary(String input) {
        for (char c : input.toCharArray()) {
            System.out.println(Integer.toBinaryString(c)); // How does it work internally?
        }

        // Result:
        // 1001000
        // 1100101
        // 1101100
        // 1101100
        // 100000
        // 1101111
    }

    // Do not confuse with byte value and its storage capacity. Byte can store 8 bits. Its value in java can be btw -128 to 127. The value is an integer number. An int can store from approx - 2 billion to 2 billion number value (-2^31) to (2^31 - 1)
    // https://stackoverflow.com/questions/12310017/how-to-convert-a-byte-to-its-binary-string-representation
    // input: "a".getBytes(StandardCharsets.UTF_8)
    // Integer can be converted to byte by casting int to byte: byte b = (byte) 128
    // byte in java is an 8-bit signed 2's complement integer. its min value is -128 (2^8) and max value is 127
    public void convertByteArrayToBinary(byte[] byteArr) {
        // 1 byte has 8 bits - https://mkyong.com/java/java-convert-string-to-binary/
        for (byte b : byteArr) {
            // & 0xFF converts a signed byte to an unsigned integer. For example, -129, like you said, is represented by 11111111111111111111111110000001. In this case, you basically want the first (least significant) 8 bits, so you AND (&) it with 0xFF (00000000000000000000000011111111), effectively cleaning the 1's to the left that we don't care about, leaving out just 10000001
            String byteInBinary = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            System.out.println(byteInBinary);
        }
    }
}

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it

        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {
//
//            // Press Ctrl+D to start debugging your code. We have set one breakpoint
//            // for you, but you can always add more by pressing Cmd+F8.
//            System.out.println("i = " + i);
//        }
            hello();
    }

    public static final void hello() {
        // Binary literals in Java use the 0b prefix
        int READ_PERMISSION = 0b001;
        int WRITE_PERMISSION = 0b010;
        int EXECUTE_PERMISSION = 0b100;

        // Bitwise OR and AND
        int userPermissions = READ_PERMISSION | EXECUTE_PERMISSION; // 0b011 = 3

        // Bitwise AND
        boolean canReadBitwise = (userPermissions & READ_PERMISSION) == READ_PERMISSION;
        boolean canWriteBitwise = (userPermissions & WRITE_PERMISSION) == WRITE_PERMISSION;
        boolean canExecuteBitwise = (userPermissions & EXECUTE_PERMISSION) == EXECUTE_PERMISSION;

        // Logical OR and AND
        int userPermissionsLogical = READ_PERMISSION | WRITE_PERMISSION;

        // Logical OR
        boolean canReadLogical = userPermissionsLogical == READ_PERMISSION || userPermissionsLogical == WRITE_PERMISSION;
        boolean canWriteLogical = userPermissionsLogical == WRITE_PERMISSION || userPermissionsLogical == READ_PERMISSION;
        boolean canExecuteLogical = userPermissionsLogical == EXECUTE_PERMISSION || userPermissionsLogical == READ_PERMISSION || userPermissionsLogical == WRITE_PERMISSION;

        System.out.println("Bitwise - User Permissions: " + Integer.toBinaryString(userPermissions));
        System.out.println("Bitwise - Can Read: " + canReadBitwise);
        System.out.println("Bitwise - Can Write: " + canWriteBitwise);
        System.out.println("Bitwise - Can Execute: " + canExecuteBitwise);

        System.out.println("Logical - User Permissions: " + Integer.toBinaryString(userPermissionsLogical));
        System.out.println("Logical - Can Read: " + canReadLogical);
        System.out.println("Logical - Can Write: " + canWriteLogical);
        System.out.println("Logical - Can Execute: " + canExecuteLogical);
    }
}
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        deepCopy();
    }

    // Deep Copy - means copying value - when you clone a 1D array u copy the values
    // This is like allocating new memory. So changes to copy will not affect the original
    // This applies to all objects that are instanitated with the new keyword
    // These are slow and expensive operation as new memory is allocated
    public static void deepCopy() {
        final Ranger ranger1 = new Ranger(); // Create new instance of Ranger class and is allocated separate memory
        final Ranger ranger2 = new Ranger(); // This is another instance with a different memory location
        ranger2.x = 15; // So changing the reference variable of ranger2 object will not impact ranger1 since both have separate memories allocated
        System.out.println("ranger1 - x value: " + ranger1.x + " Hashcode: " + ranger1.hashCode());
        System.out.println("ranger2 - x value: " + ranger2.x + " Hashcode: " + ranger2.hashCode());
    }

    // Shallow Copy - means copying references - when u clone 2D array u copy the reference
    // So changes done to the copy will affect the original. This applies to all objects that are assigned
    // These are fast and cheap operations
    public static void shallowCopy() {
        final Ranger ranger1 = new Ranger(); // Create new instance of Ranger class
        final Ranger ranger2 = ranger1; // This will copy reference of ranger1 but not the value
        ranger2.x = 15;
        System.out.println("ranger1 - x value: " + ranger1.x + " Hashcode: " + ranger1.hashCode());
        System.out.println("ranger2 - x value: " + ranger2.x + " Hashcode: " + ranger2.hashCode());
    }

    static class Ranger {
        int x = 3; // Instance variable of class Ranger
    }
}
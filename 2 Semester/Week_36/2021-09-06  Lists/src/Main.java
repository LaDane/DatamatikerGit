import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Node node = new Node("Mie");
        Node node1 = new Node("Viktor");

        node1.nextNode = node;
        System.out.println("Next node is : "+ node1.nextNode.name);

        Integer[] integers = {1, 23, 54, 133, 51, 73};
        Set<Integer> integerSet = new LinkedHashSet<>(Arrays.asList(integers));
        for (Integer integer : integerSet) {
            System.out.println(integer);
        }
    }
}

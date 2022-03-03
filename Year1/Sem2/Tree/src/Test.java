import java.util.Random;

public class Test {

    public static void main(String[] args) {


        SearchTree<Integer> searchTree = new SearchTree<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            searchTree.add(random.nextInt(20));
        }
//        BTreePrinter.printNode(searchTree.root);
//        for (int i = 0; i < 20; i++) {
//            int x = random.nextInt(20);
//            if (searchTree.remove(x)) {
//                System.out.println(x);
//                BTreePrinter.printNode(searchTree.root);
//            }
//        }

        BTreePrinter.printNode(searchTree.root);
        for (int i = 0; i <10 ; i++) {
            int value = searchTree.root.value;
            searchTree.delete(value); 
            System.out.println(value+" ");
            BTreePrinter.printNode(searchTree.root);
        }
        }

}

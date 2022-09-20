import java.util.LinkedList;

public class BFS_Algorithm {

    static LinkedList<nodes> data = new LinkedList<>();
    static int dataLength = 0;


    public static int getSteps(int start, int end) {

        if (start > end) {
            return -1;
        }
        if (start == end) {
            return 0;
        }
 
        data.add(new nodes(start, start,1 , "Orgin"));
        dataLength++;

        int value = shortestWay(end, 1);
        if (value >0) {
            System.out.println(getPath());
        }
        return value;
    }

    public static String getPath() {
        String path = " ";
        int value = data.getLast().value;
        for (int i = data.size() - 1; i >= 0; i--) {
            if (data.get(i).value == value) {
                path = data.get(i).operation + " " + path;
                value = data.get(i).oldValue;
            }
        }
        return path;
    }

    private static int shortestWay(int end, int parent) {


        int count=dataLength;
        for (int i = dataLength-1; i>=0 ; i--) {

            if (data.get(i).parent == parent) {

                int input=data.get(i).value;
                if (input + 3 == end) {
                    data.add(new nodes(input, input + 3, parent + 1, "+"));
                    return parent++;
                } else if(input +3<end) {
                    data.add(new nodes(input, input  + 3, parent + 1, "+"));
                    dataLength++;
                }

                if (input * 4 == end) {
                    data.add(new nodes(input, input  * 4, parent + 1, "*"));
                    return parent++;
                } else if(input*4<end){
                    data.add(new nodes(input, input  * 4, parent + 1, "*"));
                    dataLength++;
                }

            }
            break;
        }

        if(count==dataLength)return -1;
        return shortestWay(end, parent + 1);
    }

    static class nodes {

        int parent;
        int oldValue;
        int value;
        String operation;

        public nodes(int oldValue, int value, int parent, String operation) {
            this.parent = parent;
            this.oldValue = oldValue;
            this.value = value;
            this.operation = operation;
        }

    }
}

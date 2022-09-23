import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InputException {

        ArrayList<Integer> indexes1 = new ArrayList<>();
        ArrayList<Integer> indexes2 = new ArrayList<>();
        StringBuffer string = new StringBuffer(args[0]);

        for (int i = 0; i < string.length(); i++){
            if (string.charAt(i) == '('){
                indexes1.add(i);
            }
            if (string.charAt(i) == ')'){
                indexes2.add(i);
            }
        }

        if (indexes1.get(0) > indexes2.get(0) || indexes1.size() != indexes2.size()){
            throw new InputException("Input is not correct");
        }

        for (int index = 0; index < indexes1.size(); index++){
            int count = 0;
            int indexNew = 0;
            for (Integer integer : indexes1) {
                if (integer < indexes2.get(0)) {
                    count++;
                    indexNew++;
                }
            }

            if (count == 1){
                string.delete(indexes1.get(indexNew - 1), indexes2.get(indexNew - 1) + 1);
                int diff = indexes2.get(indexNew - 1) - indexes1.get(indexNew - 1) + 1;
                for(int i = 0; i < indexes1.size(); i++){
                    indexes1.set(i, indexes1.get(i) - diff);
                    indexes2.set(i, indexes2.get(i) - diff);
                }
                indexes1.remove(0);
                indexes2.remove(0);
                index = 0;
            }

            if (count / 2 > 0){
                indexes1.remove(0);
                indexes2.remove(count - 1);
                index = 0;
            }
        }
        if (indexes1.size() == 1){
            string.delete(indexes1.get(0), indexes2.get(0) + 1);
            indexes1.remove(0);
            indexes2.remove(0);
        }
        System.out.println(string);
        System.out.println(indexes1.size());
    }
}
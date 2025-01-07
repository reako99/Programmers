import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    StringBuilder sbHead = new StringBuilder();
    StringBuilder sbNumber = new StringBuilder();
    StringBuilder sbTail = new StringBuilder();
    public String[] solution(String[] files) {
        List<File> list = new LinkedList<>();
        for (String str: files){
            File file = new File(str);
            list.add(file);
        }

        List<File> sortedList = list.stream().sorted(Comparator.comparing(File::getHead).thenComparingInt(File::getNumber)).collect(Collectors.toList());
        String[] answer = new String[list.size()];
        for(int i = 0 ; i < list.size(); i++) {
            answer[i] = sortedList.get(i).filename;
        }

        return answer;
    }
    
    public class File{
        String filename;
        String HEAD;
        String NUMBER;
        String TAIL;

        public File(String filename){
            this.filename = filename;

            boolean isNumber = false;
            boolean isHead = true;
            boolean isTail = false;
            for(int i = 0 ; i < filename.length(); i++){
                if(filename.charAt(i)<='9'&&filename.charAt(i)>='0'){
                    if(isHead){
                        isHead = false;
                        isNumber = true;
                    }
                }else if(isNumber){
                    isNumber = false;
                    isTail = true;
                }
                if(isHead) sbHead.append(filename.charAt(i));
                if(isNumber) sbNumber.append(filename.charAt(i));
                if(isTail) sbTail.append(filename.charAt(i));
            }
            this.HEAD = sbHead.toString().toUpperCase();
            this.NUMBER = sbNumber.toString().toUpperCase();
            this.TAIL = sbTail.toString().toUpperCase();
            sbHead.delete(0, sbHead.length());
            sbNumber.delete(0, sbNumber.length());
            sbTail.delete(0, sbTail.length());
        }

        public String getHead(){
            return this.HEAD;
        }
        public int getNumber(){
            return Integer.parseInt(this.NUMBER);
        }
        public String getTail(){
            return this.TAIL;
        }
    }
}
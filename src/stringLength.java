

class stringLength{
  public static void main(String[] args){
    
    // note to use Java assertions, the `-ea`flag must be on in the JRE
    //   this can be done in your IDE's settings
    // These examples, from the assignment do not count towards your 10. 
    
    // Testing a mix of length and alpha sorting
    String[] test1 = {"DeBlasio","Gastelum","Flores","Alvorado","Berkowitz"};
    String[] test1correct = {"Flores","Alvorado","DeBlasio","Gastelum","Berkowitz"};
    mergeSortLengths(test1);
    for(int i=0; i<test1.length; i++) assert(test1[i].equals(test1correct[i]));
    
    // Testing only alpha sorting
    String[] test2 = {"AAAAA","BBBB","CCC","DD","E"};
    String[] test2correct = {"E", "DD", "CCC","BBBB","AAAAA"};
    mergeSortLengths(test2);
    for(int i=0; i<test2.length; i++) assert(test2[i].equals(test2correct[i]));

    // testing not there 
    String[] test3 = {"a","aaa","aaaaa"};
    String test3out = binarySearchLengths(test3,"bb",0,2);
    String test3correct = "(0,2) (0,0) False";
    assert(test3out.equals(test3correct));
    
    // testing alpha search
    String[] test4 = {"a","b","c","d","e","f","g"};
    String test4out = binarySearchLengths(test4,"e",0,6);
    String test4correct = "(0,6) (4,6) (4,4) True";
    assert(test4out.equals(test4correct));
    
    
    System.out.println("All assert tests passed");
  }
  
  public static void mergeSortLengths(String[] stringArray){
    if(stringArray.length <= 1) return; 
    
    int left_size = stringArray.length / 2;
    if(stringArray.length % 2 == 1) {
      // we want to put the bigger "half" in the left
      left_size ++;
    }
    
    String[] left = new String[left_size];
    String[] right = new String[stringArray.length - left_size];
    
    // left gets the values from inArray index 0...left_size-1
    for(int i=0; i<left_size; i++) {
      left[i] = stringArray[i];
    }
    
    // right gets the values from inArray index left_size...inArray.length-1
    for(int j=left_size; j<stringArray.length; j++) {
      right[j-left_size] = stringArray[j];
    }
    
    //make recursive calls to mergeSort
    mergeSortLengths(left);
    mergeSortLengths(right);
    
    // merge
    int left_compare = 0;
    int right_compare = 0;
    int insert_index = 0;
    
    // take the minimum of the left and right arrays at _compare and put in inArray
    while(left_compare < left.length && right_compare < right.length){
      boolean leftShorter = left[left_compare].length() < right[right_compare].length();
      boolean sameLength = left[left_compare].length() == right[right_compare].length();
      boolean leftComesFirst = left[left_compare].compareTo(right[right_compare]) < 0;
      if(leftShorter || (sameLength && leftComesFirst ) ) {
        stringArray[insert_index] = left[left_compare];
        left_compare++;
        insert_index++;
      }else {
        stringArray[insert_index] = right[right_compare];
        right_compare++;
        insert_index++;
      }
    }
    while(left_compare < left.length) {
      stringArray[insert_index] = left[left_compare];
      left_compare++;
      insert_index++;
    }
    while(right_compare < right.length) {
      stringArray[insert_index] = right[right_compare];
      right_compare++;
      insert_index++;
    }
  }
  
  public static String binarySearchLengths(String[] inArray, String search, int start, int end){
    if(start > end) return "(" + start + "," + end + ") False";
    if(start == end) return "(" + start + "," + end + ") " + ((inArray[start].equals(search))?"True":"False");
    
    int middle = (end-start)/2 + start;
    boolean searchShorter = inArray[middle].length() > search.length();
    boolean searchSameLength = inArray[middle].length() == search.length();
    boolean searchComesBefore = inArray[middle].compareTo(search) > 0;
    
    if(inArray[middle].equals(search)) {
      return "(" + start + "," + end + ") True";
    }else if(searchShorter || ( searchSameLength && searchComesBefore )) {
      return "(" + start + "," + end + ") " +  binarySearchLengths(inArray, search, start, middle-1);
    }else {
      return "(" + start + "," + end + ") " +  binarySearchLengths(inArray, search, middle+1, end);
    }
    
  }
}

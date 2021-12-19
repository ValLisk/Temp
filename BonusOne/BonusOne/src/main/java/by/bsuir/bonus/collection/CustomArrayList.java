package by.bsuir.bonus.collection;


import java.util.*;
import java.util.stream.Collectors;


public class CustomArrayList{
    private ArrayList<String> arrayList;
    private int capacity = 10;

    public CustomArrayList(){
        arrayList = new ArrayList<>();
    }

    public CustomArrayList(int capacity){
        arrayList = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<String> getArrayList() {
        return List.copyOf(arrayList);
    }

    public String get(int index) {
        return arrayList.get(index);
    }

    public String set(int index, String element) {
        return arrayList.set(index, element);
    }

    public boolean add(String s) {//1
        boolean res = arrayList.add(s);
        if (res){
            if (arrayList.size() >= capacity){
                capacity = (capacity * 3) / 2 + 1;
            }
        }
        return res;

    }


    public String remove(int index) {
        return arrayList.remove(index);
    }

    public boolean remove(String o) {
        return arrayList.remove(o);
    }

    @Override
    public boolean equals(Object o) {
        return arrayList.equals(o);
    }

    @Override
    public int hashCode() {
        return arrayList.hashCode();
    }

    public Map<String, Long> countSameStrings(){//2
        Map<String, Long> sameStrings = arrayList.stream()
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        sameStrings.entrySet().removeIf(count -> count.getValue() == 1);
        return sameStrings;
    }

    public List<String> reverseAll(){//4
       return arrayList.stream()
               .map(str -> new StringBuilder(str)
                       .reverse().toString())
               .toList();
    }

    public Map<String, Long> countCharacters(){//5
        Map<String, Long> sameStrings = arrayList
                .stream()
                .flatMap(str -> Arrays.stream(str.split("")))
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        return sameStrings;

    }

    public List<String> containsAll(String line){//6
        return arrayList.stream().filter(str -> str.contains(line)).toList();
    }

    public int compareInnerObjects(int firstIndex, int secondIndex){//8
        String left = arrayList.get(firstIndex);
        String right = arrayList.get(secondIndex);
        return left.compareTo(right);

    }

    public List<Integer> countInnerSize(){//9
        return arrayList.stream().map(String::length).sorted().toList();
    }

    public void staticAdd(String str){
            int size = arrayList.size();
            if (size >= capacity){
                arrayList.remove(0);
            }
                arrayList.add(str);

    }

    public int size(){
        return arrayList.size();
    }

    @Override
    public String toString(){
       return arrayList.toString();
    }

}

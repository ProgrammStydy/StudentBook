public class CollectionsDemo {
    public static void main(String[] args) {
        MyArrayList<String> myList = new MyArrayList<>();
        myList.add("First");
        myList.add("Second");
        System.out.println("Элемент 0: " + myList.get(0));
        System.out.println("Удален: " + myList.remove(0));
        System.out.println("Размер: " + myList.size());

        MyHashSet<Integer> mySet = new MyHashSet<>();
        mySet.add(10);
        mySet.add(20);
        mySet.add(10);
        System.out.println("Размер HashSet: " + mySet.size());
        mySet.remove(10);
        System.out.println("Размер после удаления: " + mySet.size());
    }
}
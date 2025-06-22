public class CollectionsDemo {
    public static void main(String[] args) {
        MyArrayList myList = new MyArrayList();
        myList.add("First");
        myList.add("Second");
        System.out.println("Элемент 0: " + myList.get(0));
        System.out.println("Удален: " + myList.remove(0));
        System.out.println("Размер: " + myList.size());


        MyHashSet mySet = new MyHashSet();
        mySet.insert(10);
        mySet.insert(20);
        mySet.insert(10);
        System.out.println("Размер HashSet: " + mySet.size());
        mySet.remove(10);
        System.out.println("Размер после удаления: " + mySet.size());
    }
}
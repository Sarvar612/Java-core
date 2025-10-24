import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //1task
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
//        numbers.stream().filter(n->n%2!=0).forEach(s-> System.out.print(s*s+" "));
//        System.out.println();
        //2task
//        List<String> words = List.of("apple", "banana", "pear", "pineapple");
//        words.stream().filter(word -> word.length()>5).forEach(s-> System.out.print(s+" "));
//        System.out.println();
        //3task
//        List<Integer> nums = List.of(10, 2, 33, 4, 25);
//        System.out.println(nums.stream().max(Integer::compare).get());
        //4task
//        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
//        int sum = names.stream().mapToInt(s->s.length()).sum();
//        System.out.println(sum/names.size());

        //5task
//        List<String> input = List.of("apple", "pear", "apple", "banana", "pear");
//        input.stream().distinct().sorted(Comparator.comparing(s->s.length())).forEach(s-> System.out.print(s+" "));
//        System.out.println();

        //6task
//        List<String> fruits = List.of("apple", "banana", "kiwi");
//        Map<String,Integer> a=fruits.stream().collect(Collectors.toMap(w -> w, w->w.length()));
//        a.forEach((b,c)-> System.out.print(b+" "+c+" "));
//        System.out.println();
        //7task
//        List<String> names2 = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine");
//        names2.stream().sorted(Comparator.naturalOrder()).forEach(s-> System.out.print(s+" "));
//        System.out.println();

        //8task
//        List<String> names3 = List.of("Tom", "Jerry", "Spike");
////        names3.stream().forEach(s-> System.out.print(s+", "));//1st  method
////        System.out.println();
////        System.out.println(names3.stream().collect(Collectors.joining(",")));//2nd method
//        System.out.println(String.join(",", names3));//3rd method

        //9task
//        List<String> sentences = List.of("Java is cool", "Streams are powerful");
//        sentences.stream().forEach(s -> {
//                    for (String word : s.split(" ")) {
//                        System.out.print(word+" ");
//                    }
//                });
//        System.out.println();
        //10task
//        List<Product> products = List.of(
//                new Product("Phone", "Electronics", 1200),
//                new Product("TV", "Electronics", 1800),
//                new Product("Apple", "Fruits", 2.5),
//                new Product("Mango", "Fruits", 4.0));
//        products.stream().sorted(Comparator.comparing(s->s.getPrice())).forEach(s-> System.out.print(s+" "));

        //11task
//        List<String> names4 = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine","");
//        Predicate<String> word=n->!n.equals("")&& n.length()>3;
//        names4.stream().filter(word).forEach(s-> System.out.print(s+" "));

        //12task
//        Function<String, Integer> wordF=  s -> s.length();
//        System.out.println(wordF.apply("Banana"));

        //13task
//        Supplier<UUID> supplier= UUID::randomUUID;
//        System.out.println(supplier.get());

        //14task
//        Consumer<String> consumer= s-> System.out.println(s.toUpperCase());
//        consumer.accept("banana");

        //15task
//        BiFunction<Integer, Integer, Integer> biFunction=(a,b)->a+b;//or Integer::sum
//        System.out.println(biFunction.apply(1,2));

        //16task
//        String someWord="  some Word";
//        Function<String,String> trim= n->n.trim();
//        Function<String,String> toUpperCase= String::toUpperCase;
//        System.out.println(trim.apply(someWord));
//        System.out.println(toUpperCase.apply(someWord));

        //17task
//        Scanner scan=new Scanner(System.in);
//        String word=scan.nextLine();
//        Consumer<String> consumer1=s-> System.out.println(word);
//        Consumer<String> consumer2=s-> System.out.println(s.length());
//        Consumer<String> bothConsumers=consumer1.andThen(consumer2);
//        bothConsumers.accept(word);

        //18task
//        Predicate<Integer> isEven= n->n%2==0;
//        Predicate<Integer> isOdd= n->n%2!=0;
//        System.out.println(isEven.test(8));
//        System.out.println(isEven.test(7));
//        System.out.println(isOdd.test(7));


        //19task
//        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
//        multiply.apply(7,9);
//        Function<Integer, String> toStr = x -> "Result: " + x;
//        System.out.println(multiply.andThen(toStr));

        //20task
//        UnaryOperator<String> unaryOperator= n->n+"!!!";
//        System.out.println(unaryOperator.apply("Hello"));

        //21task
//        List<String> fruits = List.of("apple", "banana", "kiwi");
//        System.out.println(filter(fruits, n -> n.length() > 4));

        //22task
//        List<String> fruits = List.of("apple", "banana", "kiwi");
//        Map<String,Integer> vmap= map(fruits,String::length);
//        System.out.println(vmap);

        //23task
//        List<String> fruits = List.of("apple", "banana", "kiwi");
//        forEach(fruits, System.out::println);

        //24task
//        List<UUID> generated = generate(UUID::randomUUID, 7);
//        generated.forEach(System.out::println);
    }



    public static <T> List<T> generate(Supplier<T> supplier,int n){
        List<T> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(supplier.get());
        }
        return list;

    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer){
        list.forEach(consumer);
    }
    public static <T> List<T> filter(List<T> list,Predicate<T> predicate){
        //simple no stream use code
//        List<T> list1=new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            if(predicate.test((T) list)){
//                list1.add(list1.get(i));
//            }
//        }
//        return list1;

        return list.stream().filter(predicate).collect(Collectors.toList());
    }
    public static <T, M> Map<T, M> map(List<T> list, Function<T, M> function) {
        //simple map usage
//        Map<T,M> map=new HashMap<>();
//        for (int i = 0; i < list.size(); i++) {
//            map.put(list.get(i), function.apply(list.get(i)));
//        }
//        return map;



        return list.stream()
                .collect(Collectors.toMap(
                        t -> t,
                        function
                ));
    }
}
class Product{
    String name,category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
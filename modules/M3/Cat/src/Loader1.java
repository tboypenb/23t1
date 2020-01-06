public class Loader1 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(cat.getWeight());
        for(int i = 0; i < 3000; i++)
        {
            cat.meow();
        }

        Cat vasya = new Cat();

        System.out.println(cat.getWeight());
        System.out.println(cat.getStatus());

    }
}
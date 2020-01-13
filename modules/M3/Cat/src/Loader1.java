

public class Loader1 {
    public static void main(String[] args) {
        Cat murka = new Cat(1000);
        System.out.println("murka weight: " + murka.getWeight());
        murka.feed(murka.getWeight() * 2);
        System.out.println("murka weight: " + murka.getWeight() );
        System.out.println("status murka: " + murka.getStatus());
        System.out.println("count: " + murka.getCount());

        System.out.println("////////////////////////////////");


        Cat vasya = new Cat();
        System.out.println("vasya weight: " + vasya.getWeight());
        for(int i = 0; i < 35; i++)
        {
            vasya.meow();
        }
        System.out.println("vasya weight: " + vasya.getWeight());
        System.out.println("vasya status: " + vasya.getStatus());

        System.out.println("////////////////////////////////");

        Cat usha = new Cat();
        System.out.println("usha weight: " + usha.getWeight());
        usha.restroom();

        System.out.println("////////////////////////////////");

        Cat murzik = new Cat();
        System.out.println("murzik weight: " + murzik.getWeight());
        murzik.feed((double) 60);
        System.out.println("murzik weight: " + murzik.getWeight());
        System.out.println("feed weight: " + murzik.feedReturn());

        System.out.println("////////////////////////////////");

        Cat kesha = new Cat();
        System.out.println("kesha weight: " + kesha.getWeight());
        System.out.println("count: " + kesha.getCount());

        System.out.println("////////////////////////////////");
    }

}

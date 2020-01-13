

public class Cat
{
    public static final int ESEY_COUNTS = 2;
    public static final int maxweight = 9000;
    public static final int minweight = 1000;

    private double originWeight;
    private double weight;
    private double weightFeed;
    private static int count;

    private double minWeight;
    private double maxWeight;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count ++;

    }

    public Cat(int weight)
    {
        this();
        this.weight = weight;
    }

    public static int getCount()
    {
        return count;
    }

    public void restroom()
    {
        weight = weight - 10;
        System.out.println("weight decreased");
    }

    public double feedReturn()
    {
        return weightFeed;
    }

    public void meow()
    {
        weight = weight - 100;
        System.out.println("Meow");
    }

    public void feed(Double amount)
    {
        weightFeed += amount;
        weight = weight + amount;
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            count --;
            return "Dead";
        }
        else if(weight > maxWeight) {
            count--;
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    public void setColorWhite(colorCat colorWhite)
    {
    }

    public colorCat getColorWhite()
    {
        return colorCat.WHITE;
    }

    public void setColorGreey(colorCat colorGreey)
    {
    }

    public colorCat getColorGreey()
    {
        return colorCat.GREEY;
    }

    public void setColorBlack(colorCat colorBlack)
    {
    }

    public colorCat getColorBlack()
    {
        return colorCat.BLACK;
    }

    public void setColorRedHead(colorCat colorRedHead)
    {
    }

    public colorCat getColorRedHead()
    {
        return colorCat.REDHEAD;
    }
}
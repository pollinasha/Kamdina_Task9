public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.catchMouse();
        cat.giveVoice();

        Dog dog = new Dog();
        dog.bringStick();
        dog.play();


        Hamster hamster = new Hamster();
        hamster.hideFood();
        hamster.sleep();

        Fish fish = new Fish();
        fish.sleep();

        Spider spider = new Spider();
        System.out.println("У паука " + spider.getPawsCount() + " лапок.");
    }

}

abstract class Pet {

    int pawsCount = 0;
    private String voice = "";

    public Pet(String voice, int pawsCount){
        this.voice = voice;
        this.pawsCount = pawsCount;

    }

    public void sleep(){
        System.out.println("Сплю");
    }

    public void play(){
        System.out.println("Играю");
    }

    public void giveVoice(){
        System.out.println(voice);
    }

}


class Fish extends Pet{
    public Fish(){
        super("Рыбка спит", 0);
    }

}


class Spider extends Pet{
    public Spider(){
        super("Хы", 8);
    }

    public int getPawsCount(){
       return super.pawsCount;

    }
}


class Dog extends Pet{
    public Dog(){
        super(" Собачка говорит - Гав", 4);
    }

    public void bringStick(){
       System.out.println("Принёс палочку, как хороший мальчик!");
    }
}


class Cat extends Pet{
    public Cat(){
        super("Кошека Мяу", 4);
    }

    public void catchMouse(){
        System.out.println("Поймала мышку!");
    }
}


class Hamster extends Pet{
    public Hamster(){
        super("Я хомяк", 4);
    }

    public void hideFood(){
        System.out.println("Вся еда — в щёчках!");
    }
}


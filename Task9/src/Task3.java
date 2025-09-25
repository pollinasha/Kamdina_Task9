import java.util.Scanner;

public class Task3 {
    public static void main(String[] args){
        System.out.println("Вас приветствует виртуальная АТС!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваш номер телефона:");
        String number = scanner.next();
        System.out.println("Введите номер пользователя, которому хотите позвонить:");
        String friendNumber = scanner.next();
        System.out.println("Выберите модель телефона собеседника, 1 - стационарный телефон, 2 - мобильный телефон, 3 - смартфон:");
        int type = scanner.nextInt();

        if (type < 1 || type > 3) {
            System.out.println("Введена неверная модель телефона");
            return;
        }
        getPhone(type, number).makeCall(friendNumber);
    }

    public static Phone getPhone(int type, String number) {
        if (type == 1) {
            // если выбран стационарный телефон, создайте объект класса LandlinePhone
            return new LandlinePhone(number);
        } else if (type == 2) {
            // если выбран мобильный телефон, создайте объект класса MobilePhone
            return new MobilePhone(number);
        } else {
            // иначе создайте экземпляр класса Smartphone
            return new Smartphone(number);
        }
    }
}

abstract class Phone {
    private final String number;

    public Phone(String number) {
        this.number = number;
    }

    public final void makeCall(String targetNumber) {
        System.out.println("Звоним с номера " + number);
        System.out.println("Набираем номер " + targetNumber + " и звоним по сотовой связи");
        System.out.println("Привет!");
    }

    public String getNumber() {
        return number;
    }
}

// допишите реализацию класса LandlinePhone
class LandlinePhone extends Phone{
    public LandlinePhone(String number) {
        super(number);
    }
}

class MobilePhone extends Phone{
    public MobilePhone(String number) {
        super(number);
    }

    //объявите метод sendSms()
    public void sendSms(String messageText, String targetNumber) {
        System.out.println("Отправляем сообщение " + messageText + " по номеру " + targetNumber);
    }
}

// допишите реализацию класса Smartphone
class Smartphone extends MobilePhone{

    public Smartphone(String number) {
        super(number);
    }

    // объявите метод sendEmail()
    public void sendEmail(String messageText, String email) {
        System.out.println("Напишем другу сообщение " + messageText + " по email " + email);
    }

    //Полиморфный метод, принимает другие аргументы, имя то же(перегрузка)
    public void makeCall(String appName, String targetNumber) {
        System.out.println("Звоним с номера " + getNumber());
        System.out.printf("Позвоним через приложение %s по номеру %s\n", appName, targetNumber);
        System.out.println("Привет!");
    }
}

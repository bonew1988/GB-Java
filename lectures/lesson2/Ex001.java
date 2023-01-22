package lectures.lesson2;

public class Ex001 {
    public static void main(String[] args) {
        String[] name = {"В", "Л", "А", "Д", "И", "М", "И", "Р"};
        String sk = "ВЛАДИМИР КО";
        System.out.println(sk.toLowerCase());
        System.out.println(String.join("", name));
        System.out.println(String.join("", "В", "Л", "А", "Д", "И", "М", "И", "Р"));
        System.out.println(String.join(",", "В", "Л", "А", "Д", "И", "М", "И", "Р"));
    }
}

import java.util.Objects;

public class Song {

    public static void main(String[] args) {
        String[] animals = {"fly", "spider", "bird", "cat", "dog", "horse"};
        printSong(animals);
    }

    public static void printSong(String[] animals) {
        for (int i = 0; i < animals.length; i++) {
            if(i == animals.length -1) {
               System.out.println("There was an old lady who swallowed a " +animals[i] + "... \n...She's dead of course!");
            }
            else{
                printVerse(animals, i);
                System.out.println();
            }

        }
    }

    public static void printVerse(String[] animals, int index) {
        System.out.println("There was an old lady who swallowed a " + animals[index] + ".");
        for (int i = index; i > 0; i--) {
            System.out.println("She swallowed the " + animals[i] +
                    " to catch the " + animals[i - 1] + ".");
        }

        System.out.println("I don't know why she swallowed a fly - perhaps she'll die!");
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> options = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        start : for(int i=0; i<n; i++){
            String[] words = br.readLine().split(" ");

            for(int j=0; j<words.length; j++){
                char current = words[j].charAt(0);
                if(!options.contains(current)){
                    char upperCase = Character.toUpperCase(current);
                    char lowerCase = Character.toLowerCase(current);

                    options.add(upperCase);
                    options.add(lowerCase);

                    StringBuilder sb = new StringBuilder(words[j]);
                    sb.insert(0,"[");
                    sb.insert(2,"]");
                    words[j] = sb.toString();
                    printWords(words);
                    continue start;
                }
            }

            for(int j=0; j<words.length; j++){
                String current = words[j];
                for(int k=0; k<current.length(); k++){
                    if(!options.contains(current.charAt(k))){
                        char upperCase = Character.toUpperCase(current.charAt(k));
                        char lowerCase = Character.toLowerCase(current.charAt(k));
                        options.add(upperCase);
                        options.add(lowerCase);

                        StringBuilder sb = new StringBuilder(words[j]);
                        sb.insert(k,"[");
                        sb.insert(k+2,"]");
                        words[j] = sb.toString();
                        printWords(words);
                        continue start;
                    }
                }
            }
            printWords(words);
        }
    }

    public static void printWords(String[] arr){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < arr.length ; i++){
            if(i == arr.length - 1) sb.append(arr[i]);
            else sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}

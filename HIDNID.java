import java.io.*;
import java.util.Scanner;

public class HIDNID {
    static String Findclass(String str) {
        int index = str.indexOf('.');
        String str1 = str.substring(0, index);
        int int1 = Integer.parseInt(str1);
        if (int1 >= 0 && int1 <= 127)
            return "A";
        if (int1 >= 128 && int1 <= 191)
            return "B";
        if (int1 >= 192 && int1 <= 223)
            return "C";
        if (int1 >= 224 && int1 <= 239)
            return "D";
        else
            return "E";

    }

    static void FindID(String str, String ipClass) {
        String network = "", host = "";
        if (ipClass == "A") {
            int index = str.indexOf('.');
            network = str.substring(0, index);
            host = str.substring(index + 1, str.length());
        } else if (ipClass == "B") {
            int index = -1;
            int point = 2;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '.') {
                    point -= 1;
                    if (point == 0) {
                        index = i;
                        break;
                    }
                }
            }
            network = str.substring(0, index);
            host = str.substring(index + 1, str.length());
        } else if (ipClass == "C") {
            int index = -1;
            int point = 3;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '.') {
                    point -= 1;
                    if (point == 0) {
                        index = i;
                        break;
                    }
                }
            }
            network = str.substring(0, index);
            host = str.substring(index + 1, str.length());
        } else if (ipClass == "D" || ipClass == "E") {
            System.out.println("In these Classes, IP addresses are not divided into Network and Host IDs");
            return;
        }
        System.out.println("Network ID is " + network);
        System.out.println("Host ID is " + host);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the IP Address");
        String str = sc.nextLine();
        String ipClass = Findclass(str);
        System.out.println("Given IP address belings to Class " + ipClass);
        FindID(str, ipClass);
        sc.close();

    }
}
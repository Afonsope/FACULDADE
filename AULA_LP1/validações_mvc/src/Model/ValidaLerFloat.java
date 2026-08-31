package Model;

import java.util.Scanner;

public class ValidaLerFloat {
        public static float lerFloat(Scanner scanner){
        while(!scanner.hasNextFloat()){
            System.out.println("Digite um número válido:");
            scanner.next();
        }
        return scanner.nextFloat();
    }
}

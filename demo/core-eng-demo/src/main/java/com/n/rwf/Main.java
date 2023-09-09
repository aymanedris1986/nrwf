package com.n.rwf;

import com.n.rwf.flux.RequestHandler;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RequestHandler requestHandler = new RequestHandler();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter something (or type 'exit' to quit): ");
            String userInput = scanner.nextLine();
            requestHandler.startProcess(userInput);
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program.");
                break;
            }

        }
        scanner.close();
        //System.out.println("Hello world!");
    }
}
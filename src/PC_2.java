/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//Proje Yolunu Kişisel Bilgisayarımıza göre değiştiriyoruz
package com.mycompany.Chat2;

/**
 *
 * @author Berat
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

//proje ismini kişisel bilgisayar proje ismine göre değiştiriyoruz
public class PC_2 {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Sohbet Odası Girildi! Mesajınızı Yazabilirsiniz");

            // Gelen veriyi okumak için thread kullanıyoruz
            Thread readThread = new Thread(() -> {
                String receivedMessage;
                try {
                    while ((receivedMessage = in.readLine()) != null) {
                        System.out.println("PC_1: " + receivedMessage);
                    }
                } catch (IOException e) {
                    System.err.println("İstemci hata Raporu: " + e.getMessage());
                }
            });
            readThread.start();
            // Sürekli mesajlaşmak için değişkeni while döngüsüne sokuyoruz
            String userInputMessage;
            while ((userInputMessage = userInput.readLine()) != null) {
                out.println(userInputMessage);
            }

        } catch (IOException e) {
            System.err.println("Sunucu Hata Raporu: " + e.getMessage());
        }
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

//Proje Yolunu Kişisel Bilgisayarımıza göre değiştiriyoruz
package com.mycompany.Chat1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;


/**
 *
 * @author Berat
 */

//proje ismini kişisel bilgisayar proje ismine göre değiştiriyoruz
public class PC_1 {
    public static void main(String[] args) {
        
        final String IP_V4 = "192.168.0.5"; // Karşı Bilgisayarın IP_v4 adresi buraya yazılmalı

        try (Socket socket = new Socket(IP_V4, 9999);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Sohbet Odası Girildi! Mesajınızı Yazabilirsiniz");

            // Gelen veriyi okumak için thread kullanıyoruz
            Thread readThread = new Thread(() -> {
                String receivedMessage;
                try {
                    while ((receivedMessage = in.readLine()) != null) {
                        System.out.println("PC_2: " + receivedMessage);
                    }
                } catch (IOException e) {
                    System.err.println("Sunucu ile iletişim hatası: " + e.getMessage());
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

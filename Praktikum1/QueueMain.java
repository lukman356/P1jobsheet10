package Praktikum1;

import java.util.Scanner;

public class QueueMain {
    public static void menu() {
        System.out.println("Masukkan oprasi yang diinginkan: ");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. Peek");
        System.out.println("5. Clear");
        System.out.println("6. Exit");
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah maksimal elemen queue: ");
        int n = sc.nextInt();

        Queue Q = new Queue(n);
        int pilih;

        do {
            menu();
            System.out.print("Pilih menu: ");
            pilih = sc.nextInt();

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan data: ");
                    int data = sc.nextInt();
                    Q.Enqueue(data);
                    break;
                case 2:
                    if (!Q.isEmpty()) {
                        int hasil = Q.Dequeue();
                        System.out.println("Data yang dikeluarkan: " + hasil);
                    } else {
                        Q.Dequeue();
                    }
                    break;
                case 3:
                    Q.print();
                    break;
                case 4:
                    Q.peek();
                    break;
                case 5:
                    Q.clear();
                    break;
            }
        } while (pilih ==1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5);

        sc.close();
    }
}

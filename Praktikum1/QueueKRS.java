package Praktikum1;

public class QueueKRS {
    Mahasiswa[] data;
    int front;
    int rear;
    int size;
    int max;
    int sudahProses;
    final int maxProses = 30;

    public QueueKRS(int max) {
        this.max = max;
        data = new Mahasiswa[max];
        front = rear = -1;
        size = 0;
        sudahProses = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void clear() {
        front = rear = -1;
        size = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }

    public void enqueue(Mahasiswa mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh!");
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % max;
            }
            data[rear] = mhs;
            size++;
            System.out.println("Mahasiswa masuk ke antrian.");
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println("Mahasiswa yang diproses KRS:");

            for (int i = 0; i < 2; i++) {
                if (!isEmpty() && sudahProses < maxProses) {
                    data[front].tampilkanData();
                    front = (front + 1) % max;
                    size--;
                    sudahProses++;
                }
            }

            if (size == 0) {
                front = rear = -1;
            }
        }
    }

    public void tampilSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Daftar seluruh antrian:");
            int i = front;
            for (int count = 0; count < size; count++) {
                data[i].tampilkanData();
                i = (i + 1) % max;
            }
        }
    }

    public void tampilDepan() {
        if (size < 2) {
            System.out.println("Antrian kurang dari 2.");
        } else {
            System.out.println("2 Antrian terdepan:");
            data[front].tampilkanData();
            data[(front + 1) % max].tampilkanData();
        }
    }

    public void tampilBelakang() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Antrian paling akhir:");
            data[rear].tampilkanData();
        }
    }

    public void jumlahAntrian() {
        System.out.println("Jumlah mahasiswa dalam antrian: " + size);
    }

    public void jumlahSudahProses() {
        System.out.println("Jumlah mahasiswa sudah proses KRS: " + sudahProses);
    }

    public void jumlahBelumProses() {
        System.out.println("Jumlah mahasiswa belum proses KRS: " + (maxProses - sudahProses));
    }
}


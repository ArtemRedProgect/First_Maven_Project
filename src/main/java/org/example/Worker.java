package org.example;

/**
 * Работник библиотеки.
 */
public class Worker extends People {
    private static int idCounter = 0;
    private final String status;
    private final int idWorker;

    public Worker(String fio, String birthday, String status) {
        super(fio, birthday);
        this.status = status;
        idCounter++;
        this.idWorker = idCounter;
    }

    public int getIdWorker() {
        return idWorker;
    }

    public String getStatus() {
        return status;
    }
}
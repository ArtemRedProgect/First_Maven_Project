package org.example;

/**
 * Базовый класс для всех людей в системе библиотеки (читатель, работник, автор).
 */
public abstract class People {
    protected String fio;
    protected String birthday;

    protected People(String fio, String birthday){
        this.fio = fio;
        this.birthday = birthday;
    }

    public String getFIO(){
        return fio;
    }

    public String getBirthday(){
        return birthday;
    }
}
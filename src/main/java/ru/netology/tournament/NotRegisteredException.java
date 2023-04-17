package ru.netology.tournament;
public class NotRegisteredException extends Throwable {
    public NotRegisteredException(String msg) {
        super(msg);
    }
}
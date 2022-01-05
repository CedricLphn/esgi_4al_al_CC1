package fr.leprohon.esgi.al4.al.kernel.event;

public interface QueryBus {
    <Q extends Query, R> R send(Q query);
}

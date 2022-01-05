package fr.leprohon.esgi.al4.al.kernel.event;

@FunctionalInterface
public interface QueryHandler<Q extends Query, R> {
    R handle(Q query);
}

package fr.leprohon.esgi.al4.al.securepay.infrastructure;

public interface PaymentTransaction<E, C> {
    C call(E transaction) throws InterruptedException;
}

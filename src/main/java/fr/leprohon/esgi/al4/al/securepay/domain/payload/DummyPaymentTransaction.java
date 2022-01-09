package fr.leprohon.esgi.al4.al.securepay.domain.payload;

import fr.leprohon.esgi.al4.al.securepay.domain.entity.HistoryTransaction;
import fr.leprohon.esgi.al4.al.securepay.infrastructure.PaymentTransaction;

public class DummyPaymentTransaction
        implements PaymentTransaction<HistoryTransaction, Boolean> {


    private DummyPaymentTransaction() {
    }

    public static Boolean of(HistoryTransaction transaction) throws InterruptedException {
        DummyPaymentTransaction dummyPaymentTransaction = new DummyPaymentTransaction();
        return dummyPaymentTransaction.call(transaction);
    }

    @Override
    public Boolean call(HistoryTransaction transaction) throws InterruptedException {
        Thread.sleep(2000);
        return true;
    }
}

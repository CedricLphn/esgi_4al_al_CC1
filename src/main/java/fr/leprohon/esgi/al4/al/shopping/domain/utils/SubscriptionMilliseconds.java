package fr.leprohon.esgi.al4.al.shopping.domain.utils;

public enum SubscriptionMilliseconds {
    MONTHS(2678400000L);

    private final long l;

    public long getLong() {
        return l;
    }

    SubscriptionMilliseconds(long l) {
        this.l = l;
    }
}

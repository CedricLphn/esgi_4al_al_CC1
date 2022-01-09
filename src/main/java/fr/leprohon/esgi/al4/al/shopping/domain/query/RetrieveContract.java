package fr.leprohon.esgi.al4.al.shopping.domain.query;

import fr.leprohon.esgi.al4.al.kernel.event.Query;

public class RetrieveContract implements Query {
    public final int id;

    public RetrieveContract(int id) {
        this.id = id;
    }
}

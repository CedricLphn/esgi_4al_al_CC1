package fr.leprohon.esgi.al4.al.shopping.domain.query;

import fr.leprohon.esgi.al4.al.kernel.event.Query;

import java.util.Date;

public class RetrieveContractsByExpirationDate implements Query {

    public final Date date;

    public RetrieveContractsByExpirationDate(Date date) {
        this.date = date;
    }
}

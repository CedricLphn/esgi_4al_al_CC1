package fr.leprohon.esgi.al4.al.shopping.domain.query;

import fr.leprohon.esgi.al4.al.kernel.event.Query;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.Status;

public class RetrieveContractsByStatus implements Query {

    public final Status status;

    public RetrieveContractsByStatus(Status status) {
        this.status = status;
    }
}

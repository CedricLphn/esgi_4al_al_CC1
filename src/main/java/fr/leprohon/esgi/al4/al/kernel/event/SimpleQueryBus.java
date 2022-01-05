package fr.leprohon.esgi.al4.al.kernel.event;

import java.util.Map;

public class SimpleQueryBus implements QueryBus {

    private final Map<Class<? extends Query>, QueryHandler> data;

    public SimpleQueryBus(Map<Class<? extends Query>, QueryHandler> data) {
        this.data = data;
    }

    @Override
    public <Q extends Query, R> R send(Q query) {
        return dispatch(query);
    }

    private <Q extends Query, R> R dispatch(Q query) {
        final QueryHandler queryHandle = data.get(query.getClass());
        if(queryHandle == null) {
            throw new RuntimeException("No such query handler for " + query.getClass().getName());
        }

        return (R)queryHandle.handle(query);
    }
}

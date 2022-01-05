package fr.leprohon.esgi.al4.al.securepay.domain.payload;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import fr.leprohon.esgi.al4.al.securepay.domain.entity.HistoryTransaction;
import fr.leprohon.esgi.al4.al.shopping.domain.utils.Status;

import java.io.IOException;

public class HistoryTransactionTypeAdapter extends TypeAdapter<HistoryTransaction> {

    public Status convertStatus(String str) {
        Status status = null;
        switch (str) {
            case "NEW":
                status = Status.NEW;
                break;
            case "ACCEPTED":
                status = Status.ACCEPTED;
                break;
            case "REFUSED":
                status = Status.REFUSED;
                break;
        }
        return status;
    }

    @Override
    public void write(JsonWriter jsonWriter, HistoryTransaction historyTransaction) throws IOException {
        jsonWriter.beginObject();

        jsonWriter.name("contractId").value(historyTransaction.getContractId().toString());
        jsonWriter.name("firstname").value(historyTransaction.getFirstName());
        jsonWriter.name("lastname").value(historyTransaction.getLastname());
        jsonWriter.name("amount").value(historyTransaction.getAmount());
        jsonWriter.name("status").value(historyTransaction.getStatus().toString());

        jsonWriter.endObject();

    }

    @Override
    public HistoryTransaction read(JsonReader jsonReader) throws IOException {
        final HistoryTransaction transaction = new HistoryTransaction();

        jsonReader.beginObject();
        while (jsonReader.hasNext()) {

            switch (jsonReader.nextName()) {
                case "contractId":
                    transaction.setContractId(jsonReader.nextString());
                    break;
                case "firstname":
                    transaction.setFirstName(jsonReader.nextString());
                    break;
                case "lastname":
                    transaction.setLastname(jsonReader.nextString());
                    break;
                case "amount":
                    transaction.setAmount(Float.parseFloat(jsonReader.nextString()));
                    break;
                case "status":
                    transaction.setStatus(convertStatus(jsonReader.nextString()));
                    break;
            }
        }

        jsonReader.endObject();

        return transaction;

    }
}

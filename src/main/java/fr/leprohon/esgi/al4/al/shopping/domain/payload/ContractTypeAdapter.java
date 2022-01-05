package fr.leprohon.esgi.al4.al.shopping.domain.payload;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import fr.leprohon.esgi.al4.al.shopping.domain.entity.Contract;

import java.io.IOException;

public class ContractTypeAdapter extends TypeAdapter<Contract> {

    @Override
    public void write(JsonWriter jsonWriter, Contract contract) throws IOException {
        jsonWriter.beginObject();

        jsonWriter.name("contractId").value(contract.getId().toString());
        jsonWriter.name("firstname").value(contract.getUser().getFirstname());
        jsonWriter.name("lastname").value(contract.getUser().getLastname());
        jsonWriter.name("amount").value(contract.getAmount());
        jsonWriter.name("status").value(contract.getPaymentStatus().toString());


        jsonWriter.endObject();
    }

    @Override
    public Contract read(JsonReader jsonReader) throws IOException {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}

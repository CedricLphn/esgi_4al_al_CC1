package shopping.domain.service;

import shopping.domain.repository.ContractRepository;
import shopping.domain.entity.Contract;

import java.util.UUID;

public class ContractService {

    private final ContractRepository repository;

    public ContractService(ContractRepository repository) {
        this.repository = repository;
    }

    public void add(Contract c) {
        repository.add(c);
    }

    public void update(int id, Contract data) {
        repository.update(id, data);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Contract findById(int id) {
        return repository.findById(id);
    }

    public Contract findByContractId(UUID id) {
        return repository.findByContractId(id);
    }

    public int findInternalContractId(UUID uuid) {
        return repository.findInternalId(uuid);
    }

}

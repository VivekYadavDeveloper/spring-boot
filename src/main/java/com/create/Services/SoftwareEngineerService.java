package com.create.Services;

import com.create.Model.SoftwareEngineer;
import com.create.Repository.SoftwareEngineerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepository repository;

    public SoftwareEngineerService(SoftwareEngineerRepository repository) {
        this.repository = repository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return repository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {

        repository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new IllegalStateException("SoftwareEngineer with id " + id + " not found!"));
    }

    public void deleteSoftwareEngineerById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new IllegalStateException("SoftwareEngineer with id " + id + " not found!");
        }
    }

    @Transactional
    public SoftwareEngineer updateSoftwareEngineer(Integer id, SoftwareEngineer softwareEngineer) {
        if (repository.existsById(id)) {
            softwareEngineer.setId(id);
            return repository.save(softwareEngineer);
        } else {
            throw new IllegalStateException("SoftwareEngineer with id " + id + " not found!");
        }
    }
}

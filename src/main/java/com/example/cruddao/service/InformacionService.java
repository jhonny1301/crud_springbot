package com.example.cruddao.service;

import com.example.cruddao.model.Informacion;
import com.example.cruddao.repository.InformacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformacionService {

    @Autowired
    private InformacionRepository informacionRepository;

    public List<Informacion> getAllInformacion() {
        return informacionRepository.findAll();
    }

    public Optional<Informacion> getInformacionById(Long id) {
        return informacionRepository.findById(id);
    }

    public Informacion createInformacion(Informacion informacion) {
        return informacionRepository.save(informacion);
    }

    public Informacion updateInformacion(Long id, Informacion updatedInformacion) {
        Optional<Informacion> optionalInformacion = informacionRepository.findById(id);
        if (optionalInformacion.isPresent()) {
            Informacion existingInformacion = optionalInformacion.get();
            existingInformacion.setFirstName(updatedInformacion.getFirstName());
            existingInformacion.setLastName(updatedInformacion.getLastName());
            existingInformacion.setGender(updatedInformacion.getGender());
            existingInformacion.setEmail(updatedInformacion.getEmail());
            return informacionRepository.save(existingInformacion);
        } else {
            throw new RuntimeException("Informacion not found with id " + id);
        }
    }

    public void deleteInformacion(Long id) {
        informacionRepository.deleteById(id);
    }
}

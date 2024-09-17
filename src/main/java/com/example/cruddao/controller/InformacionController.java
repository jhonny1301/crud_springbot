package com.example.cruddao.controller;

import com.example.cruddao.model.Informacion;
import com.example.cruddao.service.InformacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/informacion")
public class InformacionController {

    @Autowired
    private InformacionService informacionService;

    @GetMapping
    public List<Informacion> getAllInformacion() {
        return informacionService.getAllInformacion();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Informacion> getInformacionById(@PathVariable Long id) {
        Optional<Informacion> informacion = informacionService.getInformacionById(id);
        return informacion.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Informacion createInformacion(@RequestBody Informacion informacion) {
        return informacionService.createInformacion(informacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Informacion> updateInformacion(@PathVariable Long id, @RequestBody Informacion updatedInformacion) {
        try {
            return ResponseEntity.ok(informacionService.updateInformacion(id, updatedInformacion));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInformacion(@PathVariable Long id) {
        informacionService.deleteInformacion(id);
        return ResponseEntity.noContent().build();
    }
}

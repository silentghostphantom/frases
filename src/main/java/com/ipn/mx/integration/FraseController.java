package com.ipn.mx.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.mx.domain.entity.Frase;
import com.ipn.mx.service.FraseService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/apiFrases")
public class FraseController {
	@Autowired
	FraseService service;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> handleApiRoot() {
		String message = "La ruta /apiFrases está disponible. Consulta la documentación de la API para obtener más detalles.";
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping("/frases")
	@ResponseStatus(HttpStatus.OK)
	public List<Frase> readAll() {
		return service.findAll();
	}

	@GetMapping("/frases/random")
	@ResponseStatus(HttpStatus.OK)
	public Frase readRandom() {
		return service.mostrarFraseAleatoria(service.findAll());
	}

	@PostMapping("/frases")
	@ResponseStatus(HttpStatus.CREATED)
	public Frase save(@RequestBody Frase frase) {
		return service.save(frase);
	}

	@GetMapping("/frases/{id}")
	public Frase read(@PathVariable Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/frases/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}

	@PutMapping("/frases/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Frase update(@RequestBody Frase frase, @PathVariable Long id) {
		Frase c = service.findById(id);
		c.setAutor(frase.getAutor());
		c.setFecha(frase.getFecha());
		c.setTextoFrase(frase.getTextoFrase());
		return service.save(frase);
	}
}

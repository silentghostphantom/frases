package com.ipn.mx.service;

import java.util.List;

import com.ipn.mx.domain.entity.Frase;



public interface FraseService {
	public List<Frase> findAll();
	public Frase findById(Long id);
	public Frase save(Frase frase);
	public void deleteById(Long id);
	
	public Frase mostrarFraseAleatoria(List<Frase> listaDeFrases);
}

package com.ipn.mx.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.domain.entity.Frase;
import com.ipn.mx.domain.repository.FraseRepository;

@Service
public class FraseServiceImpl implements FraseService {
	@Autowired
	FraseRepository dao;

	@Override
	@Transactional(readOnly = true)
	public List<Frase> findAll() {
		return (List<Frase>) dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Frase findById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Frase save(Frase frase) {
		return dao.save(frase);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		dao.deleteById(id);
	}

	@Override
	public Frase mostrarFraseAleatoria(List<Frase> listaDeFrases) {
		return listaDeFrases.get(new Random().nextInt(listaDeFrases.size()));
	}

}

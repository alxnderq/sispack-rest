package com.icafruta.sispack.repository;

import com.icafruta.sispack.entity.administracion.Personal;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by alxnderq on 13/11/2016.
 */
public interface SecurityRepository extends JpaRepository<Personal, Integer>{

    Personal findByUsuario(String usuario);

}
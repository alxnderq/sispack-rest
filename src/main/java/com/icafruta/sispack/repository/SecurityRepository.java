package com.icafruta.sispack.repository;

import com.icafruta.sispack.entity.administracion.Personal;
import com.icafruta.sispack.entity.seguridad.VwPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by alxnderq on 13/11/2016.
 */
public interface SecurityRepository extends JpaRepository<Personal, Integer>{

    Personal findByUsuario(String usuario);

}
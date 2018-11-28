package com.icafruta.sispack.repository;

import java.util.List;

import com.icafruta.sispack.entity.seguridad.VwPerfil;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by alxnderq on 11/22/2016.
 */
public interface VwPerfilRepository extends JpaRepository<VwPerfil, Integer> {

    List<VwPerfil> findByIdPerfil(Integer idPerfil);
}

package com.icafruta.sispack.repository;

import com.icafruta.sispack.entity.seguridad.VwPerfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by alxnderq on 11/22/2016.
 */
public interface VwPerfilRepository extends JpaRepository<VwPerfil, Integer> {

    List<VwPerfil> findByIdPerfil(Integer idPerfil);
}

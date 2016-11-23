package com.icafruta.sispack.service.impl;

import com.icafruta.sispack.dto.MenuDTO;
import com.icafruta.sispack.dto.PerfilDTO;
import com.icafruta.sispack.dto.PersonalDTO;
import com.icafruta.sispack.entity.administracion.Personal;
import com.icafruta.sispack.entity.seguridad.Perfil;
import com.icafruta.sispack.entity.seguridad.VwPerfil;
import com.icafruta.sispack.repository.PerfilRepository;
import com.icafruta.sispack.repository.VwPerfilRepository;
import com.icafruta.sispack.repository.SecurityRepository;
import com.icafruta.sispack.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alxnderq on 13/11/2016.
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    SecurityRepository securityRepository;

    @Autowired
    PerfilRepository perfilRepository;

    @Autowired
    VwPerfilRepository vwPerfilRepository;

    @Override
    public List<PersonalDTO> findAll() {
        List<PersonalDTO> lista = new ArrayList<>();
        List<Personal> listaPersonal = securityRepository.findAll();
        if (listaPersonal != null && !listaPersonal.isEmpty()){
            for (Personal p: listaPersonal) {
                lista.add(p.toPersonalDTO());
            }
        }
        return lista;
    }

    @Override
    public Personal findByUser(String user){
        return securityRepository.findByUsuario(user);
    }

    @Override
    public List<PerfilDTO> findProfile(Integer id) {
        List<PerfilDTO> list = null;
        Perfil p = perfilRepository.findOne(id);
        if (p != null) {
            list = new ArrayList<>();
            PerfilDTO dto = p.toPerfilDTO();
            dto.setListaMenu(findMenu(p.getId()));
            list.add(dto);
        }
        return list;
    }

    private List<MenuDTO> findMenu(Integer idProfile) {
        List<MenuDTO> list = null;
        List<VwPerfil> listVw = vwPerfilRepository.findByIdPerfil(idProfile);
        if (listVw != null && !listVw.isEmpty()){
            list = getListMenu(listVw, null, null);
        }
        return list;
    }

    private List<MenuDTO> getListMenu(List<VwPerfil> listVw, List<Integer> listaIds, Integer idPadre){
        if (listaIds == null){
            listaIds = new ArrayList<>();
        }
        List<MenuDTO> list = new ArrayList<>();
        for (VwPerfil vw: listVw) {
            if (!listaIds.contains(vw.getId())){
                if (idPadre != null) {
                    if (vw.getIdPadreMenu() != null){
                        if (vw.getIdPadreMenu().compareTo(idPadre) == 0) {
                            MenuDTO dto = vw.toMenuDTO();
                            dto.setSubmenu(getListMenu(listVw, listaIds, dto.getId()));
                            listaIds.add(vw.getId());
                            list.add(dto);
                        }
                    }
                } else {
                    MenuDTO dto = vw.toMenuDTO();
                    dto.setSubmenu(getListMenu(listVw, listaIds, dto.getId()));
                    listaIds.add(vw.getId());
                    list.add(dto);
                }
            }
        }
        return list;
    }

}

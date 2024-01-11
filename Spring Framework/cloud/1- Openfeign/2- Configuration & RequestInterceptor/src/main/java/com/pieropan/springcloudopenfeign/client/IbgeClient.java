package com.pieropan.springcloudopenfeign.client;

import com.pieropan.springcloudopenfeign.model.Estado;
import com.pieropan.springcloudopenfeign.model.Municipio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "ibge-client", url = "https://servicodados.ibge.gov.br/api/v1/")
public interface IbgeClient {

    @RequestMapping(method = RequestMethod.GET, value = "localidades/estados")
    List<Estado> obterEstados();

    @RequestMapping(method = RequestMethod.GET, value = "estados/{estado}/municipios")
    List<Municipio> obterMunicipiosPorEstado(@PathVariable String estado);
}
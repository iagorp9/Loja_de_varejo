package br.com.nicolasmelos.loja_varejo.controller;

import br.com.nicolasmelos.loja_varejo.dto.ProviderDto;
import br.com.nicolasmelos.loja_varejo.model.Provider;
import br.com.nicolasmelos.loja_varejo.service.ProviderService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/provider")
public class ProviderController {

    private ProviderService providerService;
    public ProviderController(ProviderService providerService){
        this.providerService = providerService;
    }

    @GetMapping
    public List<ProviderDto> findAll(){
        var providersDto = new ArrayList<ProviderDto>();
        var providersModel = providerService.findAll();
        providersModel.forEach(model -> {
            var dto = convertToDto(model);
            providersDto.add(dto);
        });
        return providersDto;
    }

    @PostMapping
    public ProviderDto insert(@Valid @RequestBody ProviderDto providerDto){
        var providerModel = new Provider();
        BeanUtils.copyProperties(providerDto,providerModel);
        providerModel = providerService.insert(providerModel);
        return convertToDto(providerModel);
    }

    @PutMapping
    public ProviderDto update(@RequestBody ProviderDto providerDto){
        var providerModel = new Provider();
        BeanUtils.copyProperties(providerDto,providerModel);
        providerService.update(providerModel);
        return providerDto;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") UUID id){
        providerService.delete(id);
        return "Fornecedor removido com sucesso!!!";
    }

    @GetMapping("/{id}")
    public ProviderDto findById(@PathVariable("id") UUID id){
        var result = providerService.findById(id);
        if(result.isPresent())
            return convertToDto(result.get());
        return null;
    }

    @GetMapping("/name/{name}")
    public ProviderDto findByName(@PathVariable("name") String name){
        var result = providerService.findByName(name);
        if(result.isPresent())
            return convertToDto(result.get());
        return null;
    }

    private static ProviderDto convertToDto(Provider provider){
        return new ProviderDto(
                provider.getId(),
                provider.getName(),
                provider.getCnpj(),
                provider.getPhone(),
                provider.getEmail()

        );
    }
}

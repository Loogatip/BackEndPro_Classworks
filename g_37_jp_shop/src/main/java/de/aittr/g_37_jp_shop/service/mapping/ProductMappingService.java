package de.aittr.g_37_jp_shop.service.mapping;

import de.aittr.g_37_jp_shop.domain.dto.ProductDto;
import de.aittr.g_37_jp_shop.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface ProductMappingService {

    // Маппинг в ручном режиме:
//    public ProductDto mapEntityToDto(Product entity){
//        ProductDto dto = new ProductDto();
//        dto.setId(entity.getId());
//        dto.setTitle(entity.getTitle());
//        dto.setPrice(entity.getPrice());
//        return dto;
//    }
//    public Product mapDtoToEntity(ProductDto dto){
//
//    }

    // Маппинг через mapstruct:

    ProductDto mapEntityToDto(Product entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
//    @Mapping(target = "id", expression = "java(new Long(0))")
    Product mapDtoToEntity(ProductDto dto);
}

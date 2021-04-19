package net.kuleasycode.tksmartchoice.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import net.kuleasycode.tksmartchoice.dto.ProductDto;
import net.kuleasycode.tksmartchoice.entity.ProductEntity;

@Component
public class ProductConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	public ProductDto convertEntityToDto(ProductEntity entity) {
		if (StringUtils.isEmpty(entity)) {
			return null;
		}
		ProductDto result = modelMapper.map(entity, ProductDto.class);
		return result;
	}
	
	public ProductEntity convertDtoToEntity (ProductDto dto) {
		ProductEntity result = modelMapper.map(dto, ProductEntity.class);
		return result;
	}
	
}

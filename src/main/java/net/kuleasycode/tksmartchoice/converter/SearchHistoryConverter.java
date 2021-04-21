package net.kuleasycode.tksmartchoice.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import net.kuleasycode.tksmartchoice.dto.SearchHistoryDto;
import net.kuleasycode.tksmartchoice.entity.SearchHistoryEntity;

@Component
public class SearchHistoryConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	public SearchHistoryDto convertEntityToDto(SearchHistoryEntity entity) {
		if (StringUtils.isEmpty(entity)) {
			return null;
		}
		SearchHistoryDto result = modelMapper.map(entity, SearchHistoryDto.class);
		return result;
	}
	
	public SearchHistoryEntity convertDtoToEntity (SearchHistoryDto dto) {
		SearchHistoryEntity result = modelMapper.map(dto, SearchHistoryEntity.class);
		return result;
	}
}

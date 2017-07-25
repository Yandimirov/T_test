package com.yandimirov.navi.mapper;

import com.yandimirov.navi.model.dto.OfficeDto;
import com.yandimirov.navi.model.entity.Office;
import lombok.NonNull;

public interface OfficeMapper {

    Office mapDtoToEntity(@NonNull OfficeDto officeDto);

    OfficeDto mapEntityToDto(@NonNull Office office);
}

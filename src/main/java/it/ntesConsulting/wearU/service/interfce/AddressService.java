package it.ntesConsulting.wearU.service.interfce;

import it.ntesConsulting.wearU.dto.AddressDto;
import it.ntesConsulting.wearU.dto.Response;

public interface AddressService {

	 Response saveAndUpdateAddress(AddressDto addressDto);
	
}

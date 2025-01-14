package it.ntesConsulting.wearU.service.interfce.implmentation;

import org.springframework.stereotype.Service;

import it.ntesConsulting.wearU.dto.AddressDto;
import it.ntesConsulting.wearU.dto.Response;
import it.ntesConsulting.wearU.entity.Address;
import it.ntesConsulting.wearU.entity.User;
import it.ntesConsulting.wearU.repository.AddressRepository;
import it.ntesConsulting.wearU.service.interfce.AddressService;
import it.ntesConsulting.wearU.service.interfce.UserService;
import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{

	
	   private final AddressRepository addressRepository;
	   private final UserService userService;
	
	   @Override
	    public Response saveAndUpdateAddress(AddressDto addressDto) {
		    //get user login
	        User user = userService.getLoginUser();
	        
	        Address address = user.getAddress();

	        if (address == null){
	            address = new Address();
	            address.setUser(user);
	        }
	        if (addressDto.getStreet() != null) address.setStreet(addressDto.getStreet());
	        if (addressDto.getCity() != null) address.setCity(addressDto.getCity());
	        if (addressDto.getState() != null) address.setState(addressDto.getState());
	        if (addressDto.getZipCode() != null) address.setZipCode(addressDto.getZipCode());
	        if (addressDto.getCountry() != null) address.setCountry(addressDto.getCountry());

	        addressRepository.save(address);

	        String message = (user.getAddress() == null) ? "Address successfully created" : "Address successfully updated";
	        return Response.builder()
	                .status(200)
	                .message(message)
	                .build();
	    }
	
	
	
}

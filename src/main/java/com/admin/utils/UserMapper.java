package com.admin.utils;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.admin.datamodel.User;
import com.admin.datamodel.UserDTO;

@Mapper
public interface UserMapper {

	UserMapper INSTANE = Mappers.getMapper(UserMapper.class);

	User userToUserDT(UserDTO userDTO);

	UserDTO userToUserDT(User user);

	// @Mapping(source = "numberOfSeats", target = "seatCount")
	// CarDto carToCarDto(Car car); 2

	List<User> listUserToUserDTO(List<UserDTO> dtolist);

	// @Mapping(target = "studentId", source = "student.studentId.studentId")
	// @Mapping(target = "address", source = "address.addres.localAddress")

	/*
	 * @Mapping(source = "mySourceField", target = "myTargetField",
	 * qualifiedByName = "myTransformation")// or you can use a
	 * custom @Qualifier annotation with qualifiedBy TypeDest
	 * toSiteCatTag(TypeSrc obj);
	 * 
	 * @Named("myTransformation")// or your custom @Qualifier annotation default
	 * Integer myCustomTransformation(String obj) { return
	 * Formatter.toSquare(Formatter.toInteger(obj)); }
	 */
	/*
	 * @Mapping(source = "address", target = "localAddress")
	 * 
	 * @Named("checkQualifiedNamed") default Boolean addressMapper(One one,
	 * Integer projId, Integer val, String code) { if (one.getProjectId() ==
	 * projId && one.getVal() == val && one.getCode().equalsIgnoreCase(code)) {
	 * return Boolean.TRUE; } return Boolean.FALSE; }
	 */
	/*
	 * @Mapping(source="name", target="title") SongDTO songToDto(Song song);
	 */
	// @Mapping(target = "address", source = "userDomain.addres.localAddress")
	// @Mapping(target = "zipcode", source = "userDomain.address.pincode")
	// @Mapping(target = "zipcode", source =
	// "userDomain.address.pincode.pincodeValue")
	// @Mapping(target = "zipcode", source =
	// "userDomain.addres.pincode.pincodeValue")
	@Mapping(target = "zipcode", source = "userDomain.addres.pincode.pincodeValue")
	com.admin.datamodel.User usertoDomainUser(com.admin.datamodel.UserDomain userDomain);

	// @Mapping(source = "userDomain.addres.localAddress", target = "address")
	// User usertoUserDomain(UserDomain domain);

}

package com.libraryManagment.demo.service;


import com.libraryManagment.demo.DTO.MembersDto;
import com.libraryManagment.demo.entity.Members;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MembersService {
	public String save(MembersDto MembersDto);

	public List<Members> searchMemberByName(String name);

	public List<Members> searchMemberAfterJoiningYear(Integer year);

	public String uodateMobileNumber(Integer id,String mobileNo);

}

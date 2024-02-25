package com.libraryManagment.demo.service.impl;


import com.libraryManagment.demo.DTO.MembersDto;
import com.libraryManagment.demo.entity.BookEntity;
import com.libraryManagment.demo.entity.Members;

import com.libraryManagment.demo.repository.MembersRepository;
import com.libraryManagment.demo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembersServiceImpl implements MembersService {
	@Autowired
    MembersRepository membersRepository;

    @Override
    public String save(MembersDto membersDto) {
        try
		{
			Members member=new Members();
			member.setName(membersDto.getName());
			member.setGender(membersDto.getGender());
			member.setAge(membersDto.getAge());
			member.setMobileno(membersDto.getMobileno());
			member.setJoiningyear(membersDto.getJoiningyear());
			membersRepository.save(member);
			return "member save successfully";
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
    }

	@Override
	public  List<Members> searchMemberByName(String name) {
		List<Members> member = null;
		try
		{
			member = membersRepository.findByName(name);
		}
		catch(Exception e)
		{
		}
		return member;
	}

	@Override
	public List<Members> searchMemberAfterJoiningYear(Integer year) {
		List<Members> member = null;
		try
		{
			member = membersRepository.findByjoiningyearAfter(year);
		}
		catch(Exception e)
		{
		}
		return member;
	}

	@Override
	public String uodateMobileNumber(Integer id, String mobileNo) {
		try
		{
			Optional<Members> members = membersRepository.findById(id);
			if(members.isPresent())
			{
				members.get().setMobileno(mobileNo);
				membersRepository.save(members.get());
				return "Members Mobile Number updated";
			}
			else {
				return "Invalid member id";
			}
		}
		catch(Exception e)
		{
			return "failed to update mobile number";
		}

	}

}



















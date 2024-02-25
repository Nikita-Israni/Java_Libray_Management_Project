package com.libraryManagment.demo.controller;


import com.libraryManagment.demo.DTO.APIResponseDTO;
import com.libraryManagment.demo.DTO.MembersDto;
import com.libraryManagment.demo.entity.BookEntity;
import com.libraryManagment.demo.entity.Members;
import com.libraryManagment.demo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MembersController {
	@Autowired
	MembersService memberService;

	@PostMapping(value = "/save_members")
	public ResponseEntity<APIResponseDTO> saveMember(@RequestBody MembersDto membersDto)
	{
		APIResponseDTO response = new APIResponseDTO();
		try
		{
			String message=memberService.save(membersDto);

			response.setMessage(message);
			response.setStatus(200);

		} catch (Exception exception) {
			response.setMessage("Failed To save");
			response.setStatus(400);
		}
		return new ResponseEntity<APIResponseDTO>(response, HttpStatus.OK);
	}


	@GetMapping(value = "/get_member_name")
	public ResponseEntity<APIResponseDTO> findByAuthor(@RequestHeader String name) {
		APIResponseDTO response = new APIResponseDTO();
		try {
			List<Members> members = memberService.searchMemberByName(name);
			if (!members.equals(null)&&!members.isEmpty()) {

				response.setMessage("Member SuccessFully Find");
				response.setBody(members);
				response.setStatus(200);
			}
			else{
				response.setMessage("Failed to fetch book details");
				response.setBody(null);
				response.setStatus(400);
			}

		} catch (Exception exception) {
			response.setMessage("Failed To fetch book");
			response.setStatus(400);
		}
		return new ResponseEntity<APIResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/get_member_joining_year")
	public ResponseEntity<APIResponseDTO> findByAuthor(@RequestHeader Integer year) {
		APIResponseDTO response = new APIResponseDTO();
		try {
			List<Members> members = memberService.searchMemberAfterJoiningYear(year);
			if (!members.equals(null)&&!members.isEmpty()) {

				response.setMessage("Member SuccessFully Find");
				response.setBody(members);
				response.setStatus(200);
			}
			else{
				response.setMessage("Failed to fetch book details");
				response.setBody(null);
				response.setStatus(400);
			}

		} catch (Exception exception) {
			response.setMessage("Failed To fetch book");
			response.setStatus(400);
		}
		return new ResponseEntity<APIResponseDTO>(response, HttpStatus.OK);
	}

	@PutMapping(value = "/update_mobile_number")
	public ResponseEntity<APIResponseDTO> uodateMobileNumber(@RequestHeader Integer id,@RequestHeader String mobileNo) {
		APIResponseDTO response = new APIResponseDTO();
		try {
			String message = memberService.uodateMobileNumber(id,mobileNo);
			if (message.equals("Members Mobile Number updated")) {

				response.setMessage(message);
				response.setStatus(200);
			}
			else{
				response.setMessage(message);
				response.setBody(null);
				response.setStatus(400);
			}

		} catch (Exception exception) {
			response.setMessage("Failed To fetch member");
			response.setStatus(400);
		}
		return new ResponseEntity<APIResponseDTO>(response, HttpStatus.OK);
	}
	}




package com.tedu.duanzu.Service;

import java.util.Date;
import java.util.List;

import com.tedu.duanzu.entity.Guests;

public interface GuestsService {
	public List<Guests> fandAll(Guests guests);
	
	public List<Guests> member(Integer landlordId,String memberlevel);
	
	public void Addbkk(Guests guests);
	
	int deleteObjects(Integer guestId);
	
	public Guests Select(Integer gusetId);
}

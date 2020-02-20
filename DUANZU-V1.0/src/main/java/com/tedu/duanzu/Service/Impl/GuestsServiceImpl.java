package com.tedu.duanzu.Service.Impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.duanzu.Dao.GuestsDao;
import com.tedu.duanzu.Service.GuestsService;
import com.tedu.duanzu.common.ServiceException;
import com.tedu.duanzu.entity.Guests;

@Service
public class GuestsServiceImpl implements GuestsService{
	@Autowired
	private GuestsDao guestss;
	
	@Override
	public List<Guests> fandAll(Guests guests) {
		
		
		List<Guests> fa = guestss.fandAll(guests);
		
		System.out.println(guests);
		
		if (fa==null) throw new ServiceException("您暂时没有宾客");
		return fa;
	}

	@Override
	public List<Guests> member(Integer landlordId, String memberlevel) {
		
		List<Guests> member = guestss.member(landlordId, memberlevel);
		System.out.println(member);
		if(member.size()==0) throw new ServiceException(memberlevel+"没有宾客");
		return member;
	}

	@Override
	public void Addbkk(Guests guests) {
		int BK = guestss.Addbk(guests);
		int ZJ = guestss.Addzj(guests);
	}

	@Override
	public int deleteObjects(Integer guestId) {
		if (guestId==null||guestId==0)throw new  ServiceException("此宾客可能已经被删除了");
		int deleteObjects = guestss.deleteObjects(guestId);
		return deleteObjects;
	}

	@Override
	public Guests Select(Integer gusetId) {
		Guests sese = guestss.Select(gusetId);
		return sese;
	}



	
}

package com.busybox.cbs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.busybox.cbs.dao.MemberDetailsRepo;
import com.busybox.cbs.exception.DeatilsNullOrMissingException;
import com.busybox.cbs.model.MemberDetails;
import com.busybox.cbs.service.ProjectService;
import com.busybox.cbs.service.impl.helper.MemberDetailsHelper;

@Service
public class MemberDeatilsServiceImpl implements ProjectService<MemberDetails, Long> {

	@Autowired private MemberDetailsHelper memberDetailsHelper;
	@Autowired private MemberDetailsRepo memberDetailsRepo;
	
	
	@Override
	public List<MemberDetails> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MemberDetails> getById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public MemberDetails create(MemberDetails entity) {
		if(entity==null) throw new DeatilsNullOrMissingException("Member Deatils Missing");
		// verifying all the required entries, checking for any duplicates
		memberDetailsHelper.allInfoRequiedTrue(entity);
		
		return memberDetailsRepo.save(entity);
	}

	@Override
	public MemberDetails update(Long id, MemberDetails entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<MemberDetails> findAllPaginated(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDetails> search(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}

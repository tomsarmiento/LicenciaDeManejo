package springdata2.relationships.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import springdata2.relationships.models.License;
import springdata2.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository lcsRepo;
	
	public LicenseService(LicenseRepository lcsRepo) {
		this.lcsRepo = lcsRepo;
	}
	
	public void createLicense(License lcs) {
		lcsRepo.save(lcs);
	}
	
	public long getCount() {
		return lcsRepo.count();
	}
	
	public License findByPerson_id(Long id) {
		Optional<License> optLcs = lcsRepo.findByPerson_id(id);
		if(optLcs.isPresent()) {
			return optLcs.get();
		}
		else {
			return null;
		}
		
	}
}

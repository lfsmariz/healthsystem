package edu.ufrn.pds.healthsystem.service;

import edu.ufrn.pds.healthsystem.dto.AdminDTO;
import edu.ufrn.pds.healthsystem.entity.Admin;
import edu.ufrn.pds.healthsystem.form.AdminForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ufrn.pds.healthsystem.repository.AdminRepository;

@Service
public class AdminService {
    private AdminRepository adminRepository;

    @Autowired
    AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    public AdminDTO create(AdminForm adminForm){
        Admin admin = new Admin(adminForm.getName());
        Admin a = adminRepository.save(admin);
        return new AdminDTO(a);
    }
}

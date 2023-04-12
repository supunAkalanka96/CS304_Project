package lk.pdn.ac.hostel.service;

import lk.pdn.ac.hostel.dto.ApplicationDto;
import lk.pdn.ac.hostel.entity.Application;
import lk.pdn.ac.hostel.entity.User;
import lk.pdn.ac.hostel.repository.ApplicationRepository;
import lk.pdn.ac.hostel.repository.UserRepository;
import org.hibernate.boot.model.process.internal.UserTypeMutabilityPlanAdapter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;


    public ApplicationDto saveApplication(ApplicationDto applicationDto){

        Application application = modelMapper.map(applicationDto,Application.class);
        application.setUser(userRepository.findById(applicationDto.getUserId()));
        Application application1 = applicationRepository.save(application);

        return modelMapper.map(application1,new TypeToken<ApplicationDto>(){}.getType());

    }

    public List<ApplicationDto> getAllApplications(){
        List<Application> applications = applicationRepository.findAll();
        return modelMapper.map(applications,new TypeToken<ArrayList<ApplicationDto>>(){}.getType());
    }



}

package lk.pdn.ac.hostel.service;

import lk.pdn.ac.hostel.dto.ComplainDto;
import lk.pdn.ac.hostel.entity.Complain;
import lk.pdn.ac.hostel.repository.ComplainRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplainService {

    @Autowired
    private ComplainRepository complainRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ComplainDto addComplain(ComplainDto complainDto){
        Complain complain = modelMapper.map(complainDto, Complain.class);
        Complain complain1 = complainRepository.save(complain);
        return modelMapper.map(complain1,new TypeToken<ComplainDto>(){}.getType());
    }

}

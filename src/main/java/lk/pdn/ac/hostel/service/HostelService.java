package lk.pdn.ac.hostel.service;

import lk.pdn.ac.hostel.Enum.HostelType;
import lk.pdn.ac.hostel.dto.HostelDto;
import lk.pdn.ac.hostel.entity.Hostel;
import lk.pdn.ac.hostel.repository.HostelRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HostelService {

    @Autowired
    private HostelRepository hostelRepository;

    @Autowired
    private ModelMapper modelMapper;

    public HostelDto save(HostelDto hostelDto){
        Hostel hostel = modelMapper.map(hostelDto,Hostel.class);
        Hostel hostel1 = hostelRepository.save(hostel);
        return modelMapper.map(hostel1,new TypeToken<HostelDto>(){}.getType());
    }

    public List<HostelDto> allHostels(){
        List<Hostel> hostels = hostelRepository.findAll();
        return modelMapper.map(hostels,new TypeToken<ArrayList<HostelDto>>(){}.getType());
    }

}

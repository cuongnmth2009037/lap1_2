package com.example.lap1.service;

import com.example.lap1.entity.TblClass;
import com.example.lap1.repository.TblClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TblClassService {
@Autowired
    TblClassRepository tblClassRepository;

@Autowired
    public TblClassService(TblClassRepository tblClassRepository){this.tblClassRepository = tblClassRepository;}
    public List<TblClass> findAll() {return tblClassRepository.findAll();}
    public Optional<TblClass> findById(Long id) {return tblClassRepository.findById(id);}

    public TblClass update(Long id, TblClass tblClassUpdate){
        Optional<TblClass> tblClassOptional = tblClassRepository.findById(id);
        if (tblClassOptional.isPresent()){
            TblClass tblClass = tblClassOptional.get();
            tblClass.setName(tblClassUpdate.getName());
            tblClass.setRoom(tblClassUpdate.getRoom());
            tblClass.setNote(tblClassUpdate.getNote());
            tblClassRepository.save(tblClass);
            return tblClass;
        }
        return null;
    }
    public TblClass save(TblClass tblClass) {return tblClassRepository.save(tblClass);}
    public boolean deleteById(Long id) {
        Optional<TblClass> tblClassOptional = tblClassRepository.findById(id);
        if (tblClassOptional.isPresent()){
            tblClassRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

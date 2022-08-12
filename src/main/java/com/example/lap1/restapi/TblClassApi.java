package com.example.lap1.restapi;

import com.example.lap1.entity.TblClass;
import com.example.lap1.service.TblClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/classes")
public class TblClassApi {
    @Autowired
    TblClassService tblClassService;

    @GetMapping
    public ResponseEntity<List<TblClass>> findAll() {
        return ResponseEntity.ok(tblClassService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<TblClass> tblClassOptional = tblClassService.findById(id);
        if(tblClassOptional.isPresent()) {
            return ResponseEntity.ok(tblClassOptional.get());
        }
        return ResponseEntity.badRequest().body("Class not found");
    }

    @PostMapping
    public ResponseEntity<TblClass> save(@RequestBody TblClass tblClass){
        return ResponseEntity.ok(tblClassService.save(tblClass));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TblClass tblClassUpdate, @PathVariable Long id){
        TblClass tblClass = tblClassService.update(id, tblClassUpdate);
        if (tblClass != null){
            return ResponseEntity.ok(tblClass);
        }
        return ResponseEntity.badRequest().body("Class not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if (tblClassService.deleteById(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body("Class not found");
    }
}

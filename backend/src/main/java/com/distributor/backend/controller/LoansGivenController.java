package com.distributor.backend.controller;

import com.distributor.backend.dto.LoansGivenDto;
import com.distributor.backend.service.LoansGivenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/loansgiven")
public class LoansGivenController {
    private LoansGivenService loansGivenService;
    @PostMapping
    public ResponseEntity<LoansGivenDto> addLoansGiven(@RequestBody LoansGivenDto loansGivenDto){
        LoansGivenDto savedLoan = loansGivenService.giveLoan(loansGivenDto);
        return new ResponseEntity<>(savedLoan, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LoansGivenDto>> allLoansGiven(){
        List<LoansGivenDto> allLoans = loansGivenService.allLoans();
        return new ResponseEntity<>(allLoans,HttpStatus.CREATED);
    }

    /*

     */
    @DeleteMapping("/del/{gst}/{id}")
    public ResponseEntity<String> deleteLoan(
            @PathVariable("gst") String gst,
            @PathVariable("id") Long id) {

        loansGivenService.deleteLoan(id, gst);
        return ResponseEntity.ok("Loan deleted successfully.");
        /*
         Ju n
         */
    }


}

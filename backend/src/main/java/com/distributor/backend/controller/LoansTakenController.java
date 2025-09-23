package com.distributor.backend.controller;

import com.distributor.backend.dto.LoansTakenDto;
import com.distributor.backend.service.LoansTakenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/loanstaken")
public class LoansTakenController {
    private LoansTakenService loansTakenService;
    @PostMapping
    public ResponseEntity<LoansTakenDto> addLoansTaken(@RequestBody LoansTakenDto loansTakenDto){
        LoansTakenDto savedLoan = loansTakenService.takeLoan(loansTakenDto);
        return new ResponseEntity<>(savedLoan, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LoansTakenDto>> allLoansTaken(){
        List<LoansTakenDto> allLoans = loansTakenService.allLoans();
        return new ResponseEntity<>(allLoans,HttpStatus.CREATED);
    }

    @DeleteMapping("/del/{gst}/{id}")
    public ResponseEntity<String> deleteLoan(
            @PathVariable("gst") String gst,
            @PathVariable("id") Long id) {

        loansTakenService.deleteLoan(id, gst);
        return ResponseEntity.ok("Loan deleted successfully.");
    }
}

package com.distributor.backend.controller;

import com.distributor.backend.dto.LoansTakenDto;
import com.distributor.backend.service.LoansTakenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/loans")
public class LoansTakenController {
    private LoansTakenService loansTakenService;
    @PostMapping
    public ResponseEntity<LoansTakenDto> addLoansTaken(@RequestBody LoansTakenDto loansTakenDto){
        LoansTakenDto savedLoan = loansTakenService.takeLoan(loansTakenDto);
        return new ResponseEntity<>(savedLoan, HttpStatus.CREATED);
    }
}

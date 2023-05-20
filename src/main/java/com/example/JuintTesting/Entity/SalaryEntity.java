package com.example.JuintTesting.Entity;

import com.example.JuintTesting.common.Salary;
import com.example.JuintTesting.common.SalaryProcessedBy;
import com.example.JuintTesting.service.SalaryService;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@SalaryProcessedBy(SalaryService.class)
public class SalaryEntity implements EmployeeHeader , Salary {

    private int id;

    private int amount;

    private int pfAmount;

    private Integer employeeId;

    @Override
    public void setEmployeeId(Integer id) {
        this.employeeId = id;
    }
}
